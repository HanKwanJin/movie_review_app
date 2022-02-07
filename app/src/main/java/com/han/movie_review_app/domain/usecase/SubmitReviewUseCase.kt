package com.han.movie_review_app.domain.usecase

import com.han.movie_review_app.data.repository.ReviewRepository
import com.han.movie_review_app.data.repository.UserRepository
import com.han.movie_review_app.domain.model.Movie
import com.han.movie_review_app.domain.model.Review
import com.han.movie_review_app.domain.model.User

class SubmitReviewUseCase(
    private val userRepository: UserRepository,
    private val reviewRepository: ReviewRepository
) {

    suspend operator fun invoke(
        movie: Movie,
        content: String,
        score: Float
    ): Review {
        var user = userRepository.getUser()

        if (user == null) {
            userRepository.saveUser(User())
            user = userRepository.getUser()
        }

        return reviewRepository.addReview(
            Review(
                userId = user!!.id,
                movieId = movie.id,
                content = content,
                score = score
            )
        )
    }
}