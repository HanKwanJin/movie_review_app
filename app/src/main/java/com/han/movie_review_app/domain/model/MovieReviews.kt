package com.han.movie_review_app.domain.model

data class MovieReviews(
    val myReview: Review?,
    val othersReview: List<Review>
)
