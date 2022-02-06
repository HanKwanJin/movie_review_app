package com.han.movie_review_app.extension

import java.text.DecimalFormat

fun Float.toDecimalFormatString(format: String) : String =
    DecimalFormat(format).format(this)