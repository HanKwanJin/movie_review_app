package com.han.movie_review_app.di

import android.app.Activity
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.han.movie_review_app.data.api.*
import com.han.movie_review_app.data.preference.PreferenceManager
import com.han.movie_review_app.data.preference.SharedPreferenceManager
import com.han.movie_review_app.data.repository.*
import com.han.movie_review_app.domain.model.Movie
import com.han.movie_review_app.domain.usecase.*
import com.han.movie_review_app.presentation.home.HomeContract
import com.han.movie_review_app.presentation.home.HomeFragment
import com.han.movie_review_app.presentation.home.HomePresenter
import com.han.movie_review_app.presentation.mypage.MyPageContract
import com.han.movie_review_app.presentation.mypage.MyPageFragment
import com.han.movie_review_app.presentation.mypage.MyPagePresenter
import com.han.movie_review_app.presentation.reviews.MovieReviewsContract
import com.han.movie_review_app.presentation.reviews.MovieReviewsFragment
import com.han.movie_review_app.presentation.reviews.MovieReviewsPresenter
import kotlinx.coroutines.Dispatchers
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val appModule = module {
    single { Dispatchers.IO }
}
val dataModule = module {
    single { Firebase.firestore }
    single<MovieApi> { MovieFirestoreApi(get()) }
    single<ReviewApi> { ReviewFirestoreApi(get()) }
    single<UserApi> { UserFirestoreApi(get()) }

    single<MovieRepository> {MovieRepositoryImpl(get(),get())}
    single<ReviewRepository> {ReviewRepositoryImpl(get(),get())}
    single<UserRepository> { UserRepositoryImpl(get(),get(),get()) }

    single { androidContext().getSharedPreferences("preference", Activity.MODE_PRIVATE) }
    single<PreferenceManager> {SharedPreferenceManager(get())}
}
val domainModule = module {
    factory { GetRandomFeaturedMovieUseCase(get(),get()) }
    factory { GetAllMoviesUseCase(get()) }
    factory { GetAllMovieReviewsUseCase(get(),get()) }
    factory { GetMyReviewedMoviesUseCase(get(),get(),get()) }

    factory { SubmitReviewUseCase(get(),get()) }
    factory { DeleteReviewUseCase(get()) }
}
val presenterModule = module {
    scope<HomeFragment> {
        scoped<HomeContract.Presenter> { HomePresenter(getSource(), get(),get()) }
    }
    scope<MovieReviewsFragment> {
        scoped<MovieReviewsContract.Presenter> { (movie: Movie) ->
            MovieReviewsPresenter(movie, getSource(), get(),get(),get())
        }
    }

    scope<MyPageFragment>{
        scoped<MyPageContract.Presenter>{ MyPagePresenter(getSource(),get()) }
    }
}