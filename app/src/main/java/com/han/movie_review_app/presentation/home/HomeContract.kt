package com.han.movie_review_app.presentation.home

import com.han.movie_review_app.domain.model.FeaturedMovie
import com.han.movie_review_app.domain.model.Movie
import com.han.movie_review_app.presentation.BasePresenter
import com.han.movie_review_app.presentation.BaseView

interface HomeContract {
    interface View: BaseView<Presenter>{
        fun showLoadingIndicator()
        fun hideLoadingIndicator()
        fun showErrorDescription(message: String)
        fun showMovies(
            featuredMovie: FeaturedMovie?,
            movies: List<Movie>
        )
    }
    interface Presenter: BasePresenter
}