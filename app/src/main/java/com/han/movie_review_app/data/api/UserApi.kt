package com.han.movie_review_app.data.api

import com.han.movie_review_app.domain.model.User

interface UserApi {
    suspend fun saveUser(user: User): User
}