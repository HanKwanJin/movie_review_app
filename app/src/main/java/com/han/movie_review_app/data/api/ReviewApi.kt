package com.han.movie_review_app.data.api

import com.han.movie_review_app.domain.model.Review

interface ReviewApi {
    suspend fun getLatestReview(movieId: String): Review?
}