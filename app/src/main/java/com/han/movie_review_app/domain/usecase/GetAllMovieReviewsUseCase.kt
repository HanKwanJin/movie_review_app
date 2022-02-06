package com.han.movie_review_app.domain.usecase

import com.han.movie_review_app.data.repository.ReviewRepository
import com.han.movie_review_app.domain.model.Review

class GetAllMovieReviewsUseCase(private val reviewRepository: ReviewRepository) {
    suspend operator fun invoke(movieId: String): List<Review> =
        reviewRepository.getAllMovieReviews(movieId)
}