package com.han.movie_review_app.data.repository

import com.han.movie_review_app.domain.model.User

interface UserRepository {
    suspend fun getUser(): User?
    suspend fun saveUser(user: User)
}