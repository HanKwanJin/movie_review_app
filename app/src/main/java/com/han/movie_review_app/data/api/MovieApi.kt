package com.han.movie_review_app.data.api

import com.han.movie_review_app.domain.model.Movie

interface MovieApi {
    suspend fun getAllMovies(): List<Movie>
    suspend fun getMovies(movieIds: List<String>): List<Movie>
}