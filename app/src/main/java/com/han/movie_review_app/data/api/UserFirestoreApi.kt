package com.han.movie_review_app.data.api

import com.google.firebase.firestore.FirebaseFirestore
import com.han.movie_review_app.domain.model.User
import kotlinx.coroutines.tasks.await

class UserFirestoreApi(
    private val firestore: FirebaseFirestore
): UserApi {
    override suspend fun saveUser(user: User): User =
        firestore.collection("users")
            .add(user)
            .await()
            .let { User(it.id) }
}