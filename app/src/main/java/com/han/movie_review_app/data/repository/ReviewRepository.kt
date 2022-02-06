package com.han.movie_review_app.data.repository

import com.han.movie_review_app.domain.model.Review

interface ReviewRepository {
    suspend fun getLatestReview(movieId: String): Review?
}