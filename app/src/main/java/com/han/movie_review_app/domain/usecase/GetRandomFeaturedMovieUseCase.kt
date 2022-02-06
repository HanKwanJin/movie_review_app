package com.han.movie_review_app.domain.usecase

import com.han.movie_review_app.data.repository.MovieRepository
import com.han.movie_review_app.data.repository.ReviewRepository
import com.han.movie_review_app.domain.model.FeaturedMovie

class GetRandomFeaturedMovieUseCase(
    private val movieRepository: MovieRepository,
    private val reviewRepository: ReviewRepository
) {
    suspend operator fun invoke(): FeaturedMovie? {
        val featuredMovies = movieRepository.getAllMovies()
            .filter { it.id.isNullOrBlank().not()}
            .filter { it.isFeatured == true }

        if (featuredMovies.isNullOrEmpty()){
            return null
        }
        return featuredMovies.random()
            .let { movie ->
                val latestReview = reviewRepository.getLatestReview(movie.id!!)
                FeaturedMovie(movie,latestReview)
            }
    }

}