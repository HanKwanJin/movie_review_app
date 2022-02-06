package com.han.movie_review_app.domain.model

data class FeaturedMovie(
    val movie: Movie,
    val latestReview: Review?
)
