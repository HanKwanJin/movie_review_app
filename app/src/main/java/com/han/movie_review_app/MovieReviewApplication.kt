package com.han.movie_review_app

import android.app.Application
import com.han.movie_review_app.di.appModule
import com.han.movie_review_app.di.dataModule
import com.han.movie_review_app.di.domainModule
import com.han.movie_review_app.di.presenterModule
import com.han.movie_review_app.utility.MovieDataGenerator
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MovieReviewApplication:Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.NONE)
            androidContext(this@MovieReviewApplication)
            modules(appModule + dataModule + domainModule + presenterModule)
        }
    }
}