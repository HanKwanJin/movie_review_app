package com.han.movie_review_app.presentation.reviews

import com.han.movie_review_app.domain.model.Movie
import com.han.movie_review_app.domain.model.MovieReviews
import com.han.movie_review_app.domain.model.Review
import com.han.movie_review_app.presentation.BasePresenter
import com.han.movie_review_app.presentation.BaseView

interface MovieReviewsContract {
    interface View: BaseView<Presenter>{
        fun showLoadingIndicator()
        fun hideLoadingIndicator()
        fun showErrorDescription(message:String)
        fun showMovieInformation(movie: Movie)
        fun showReviews(reviews: MovieReviews)
        fun showErrorToast(message: String)

    }
    interface Presenter: BasePresenter{
        val movie: Movie

        fun requestAddReview(content: String, score: Float)
        fun requestRemoveReview(review: Review)
    }
}