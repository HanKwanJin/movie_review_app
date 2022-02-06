package com.han.movie_review_app.domain.model

import com.google.firebase.firestore.DocumentId

data class User(
    @DocumentId
    val id: String? = null
)
