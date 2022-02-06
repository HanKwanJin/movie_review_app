package com.han.movie_review_app.presentation.mypage

import com.han.movie_review_app.domain.model.ReviewedMovie
import com.han.movie_review_app.presentation.BasePresenter
import com.han.movie_review_app.presentation.BaseView

interface MyPageContract {

    interface View : BaseView<Presenter> {

        fun showLoadingIndicator()

        fun hideLoadingIndicator()

        fun showNoDataDescription(message: String)

        fun showErrorDescription(message: String)

        fun showReviewedMovies(reviewedMovies: List<ReviewedMovie>)
    }

    interface Presenter : BasePresenter
}