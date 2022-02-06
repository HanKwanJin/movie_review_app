package com.han.movie_review_app.data.repository

import com.han.movie_review_app.data.api.MovieApi
import com.han.movie_review_app.domain.model.Movie
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class MovieRepositoryImpl(
    private val movieApi: MovieApi,
    private val dispatchers: CoroutineDispatcher
):MovieRepository {
    override suspend fun getAllMovies(): List<Movie> = withContext(dispatchers){
        movieApi.getAllMovies()
    }

    override suspend fun getMovies(movieIds: List<String>): List<Movie> = withContext(dispatchers){
        movieApi.getMovies(movieIds)
    }
}