package com.han.movie_review_app.data.repository

import com.han.movie_review_app.domain.model.Movie

interface MovieRepository {
    suspend fun getAllMovies(): List<Movie>
    suspend fun getMovies(movieIds: List<String>): List<Movie>
}