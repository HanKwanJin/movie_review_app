package com.han.movie_review_app.domain.usecase

import com.han.movie_review_app.data.repository.MovieRepository
import com.han.movie_review_app.domain.model.Movie

class GetAllMoviesUseCase(private val movieRepository: MovieRepository) {
    suspend operator fun invoke(): List<Movie> = movieRepository.getAllMovies()
}