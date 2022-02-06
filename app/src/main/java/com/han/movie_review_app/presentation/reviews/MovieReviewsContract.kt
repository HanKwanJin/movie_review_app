package com.han.movie_review_app.presentation.reviews

import com.han.movie_review_app.domain.model.Movie
import com.han.movie_review_app.domain.model.Review
import com.han.movie_review_app.presentation.BasePresenter
import com.han.movie_review_app.presentation.BaseView

interface MovieReviewsContract {
    interface View: BaseView<Presenter>{
        fun showLoadingIndicator()
        fun hideLoadingIndicator()
        fun showErrorDescription(message:String)
        fun showMovieInformation(movie: Movie)
        fun showReviews(reviews: List<Review>)
    }
    interface Presenter: BasePresenter{
        val movie: Movie
    }
}