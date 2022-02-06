package com.han.movie_review_app.data.api

import com.google.firebase.firestore.FieldPath
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.toObject
import com.han.movie_review_app.domain.model.Movie
import kotlinx.coroutines.tasks.await

class MovieFirestoreApi(
    private val firestore: FirebaseFirestore
):MovieApi {
    override suspend fun getAllMovies(): List<Movie> =
        firestore.collection("movies")
            .get()
            .await()
            .map { it.toObject<Movie>() }

    override suspend fun getMovies(movieIds: List<String>): List<Movie> =
        firestore.collection("movies")
            .whereIn(FieldPath.documentId(), movieIds)
            .get()
            .await()
            .map { it.toObject<Movie>() }
}