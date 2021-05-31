package com.example.hofff.main.domain.model

import java.text.SimpleDateFormat
import java.util.*

fun Date.format(): String =
    SimpleDateFormat("от dd MMMM yyyy, hh:mm", Locale("ru"))
        .format(this)