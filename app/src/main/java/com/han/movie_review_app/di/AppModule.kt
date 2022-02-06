package com.han.movie_review_app.di

import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.han.movie_review_app.data.api.MovieApi
import com.han.movie_review_app.data.api.MovieFirestoreApi
import com.han.movie_review_app.data.api.ReviewApi
import com.han.movie_review_app.data.api.ReviewFirestoreApi
import com.han.movie_review_app.data.repository.MovieRepository
import com.han.movie_review_app.data.repository.MovieRepositoryImpl
import com.han.movie_review_app.data.repository.ReviewRepository
import com.han.movie_review_app.data.repository.ReviewRepositoryImpl
import com.han.movie_review_app.domain.usecase.GetAllMoviesUseCase
import com.han.movie_review_app.domain.usecase.GetRandomFeaturedMovieUseCase
import com.han.movie_review_app.presentation.home.HomeContract
import com.han.movie_review_app.presentation.home.HomeFragment
import com.han.movie_review_app.presentation.home.HomePresenter
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module

val appModule = module {
    single { Dispatchers.IO }
}
val dataModule = module {
    single { Firebase.firestore }
    single<MovieApi> { MovieFirestoreApi(get()) }
    single<ReviewApi> { ReviewFirestoreApi(get()) }

    single<MovieRepository> {MovieRepositoryImpl(get(),get())}
    single<ReviewRepository> {ReviewRepositoryImpl(get(),get())}

}
val domainModule = module {
    factory { GetRandomFeaturedMovieUseCase(get(),get()) }
    factory { GetAllMoviesUseCase(get()) }
}
val presenterModule = module {
    scope<HomeFragment> {
        scoped<HomeContract.Presenter> { HomePresenter(getSource(), get(),get()) }
    }
}