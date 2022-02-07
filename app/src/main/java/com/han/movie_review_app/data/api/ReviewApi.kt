package com.han.movie_review_app.data.api

import com.han.movie_review_app.domain.model.Review

interface ReviewApi {
    suspend fun getLatestReview(movieId: String): Review?
    suspend fun getAllMovieReviews(movieId: String): List<Review>
    suspend fun getAllUserReviews(userId: String): List<Review>
    suspend fun addReview(review: Review): Review
    suspend fun removeReview(review: Review)
}