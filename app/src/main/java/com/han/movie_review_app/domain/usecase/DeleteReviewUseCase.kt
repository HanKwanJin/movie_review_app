package com.han.movie_review_app.domain.usecase

import com.han.movie_review_app.data.repository.ReviewRepository
import com.han.movie_review_app.domain.model.Review

class DeleteReviewUseCase(
    private val reviewRepository: ReviewRepository
) {
    suspend operator fun invoke(review: Review) =
        reviewRepository.removeReview(review)
}