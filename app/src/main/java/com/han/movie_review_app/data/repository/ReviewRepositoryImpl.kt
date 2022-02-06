package com.han.movie_review_app.data.repository

import com.han.movie_review_app.data.api.ReviewApi
import com.han.movie_review_app.domain.model.Review
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class ReviewRepositoryImpl(
    private val reviewApi: ReviewApi,
    private val dispatchers: CoroutineDispatcher
):ReviewRepository {
    override suspend fun getLatestReview(movieId: String): Review? = withContext(dispatchers){
        reviewApi.getLatestReview(movieId)
    }

    override suspend fun getAllMovieReviews(movieId: String): List<Review> = withContext(dispatchers){
        reviewApi.getAllMovieReviews(movieId)
    }

    override suspend fun getAllUserReviews(userId: String): List<Review> = withContext(dispatchers){
        reviewApi.getAllUserReviews(userId)
    }


}