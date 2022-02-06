package com.han.movie_review_app.presentation

interface BaseView<PresenterT: BasePresenter> {
    val presenter: PresenterT

}