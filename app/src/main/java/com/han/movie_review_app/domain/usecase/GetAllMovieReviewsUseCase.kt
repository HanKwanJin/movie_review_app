package com.han.movie_review_app.domain.usecase

import com.han.movie_review_app.data.repository.ReviewRepository
import com.han.movie_review_app.data.repository.UserRepository
import com.han.movie_review_app.domain.model.MovieReviews
import com.han.movie_review_app.domain.model.Review
import com.han.movie_review_app.domain.model.User

class GetAllMovieReviewsUseCase(
    private val userRepository: UserRepository,
    private val reviewRepository: ReviewRepository
) {

    suspend operator fun invoke(movieId: String): MovieReviews {
        val reviews = reviewRepository.getAllMovieReviews(movieId)
        val user = userRepository.getUser()

        if (user == null) {
            userRepository.saveUser(User())

            return MovieReviews(null, reviews)
        }

        return MovieReviews(
            reviews.find { it.userId == user.id },
            reviews.filter { it.userId != user.id }
        )
    }
}