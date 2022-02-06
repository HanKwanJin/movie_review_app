package com.han.movie_review_app.data.preference

interface PreferenceManager {
    fun getString(key: String): String?
    fun putString(key: String, value: String)
}