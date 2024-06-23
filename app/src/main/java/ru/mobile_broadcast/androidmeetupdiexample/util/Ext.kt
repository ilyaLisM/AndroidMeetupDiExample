package ru.mobile_broadcast.androidmeetupdiexample.util

import ru.mobile_broadcast.androidmeetupdiexample.R
import java.text.SimpleDateFormat
import java.util.Locale

fun String.formatToRusDate(): String {
    val inputDateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH)
    val outputDateFormat = SimpleDateFormat("d MMMM, yyyy", Locale("ru", "RU"))
    val date = inputDateFormat.parse(this)
    return outputDateFormat.format(date ?: "")
}

fun Int.toShortPriceName(resourceManager: ResourceManager): String {
    val absValue = kotlin.math.abs(this)
    return when {
        absValue >= 1_000_000_000 -> {
            "$${absValue / 1_000_000_000} ${resourceManager.getString(R.string.billion_suffix)}"
        }

        absValue >= 1_000_000 -> {
            "$${absValue / 1_000_000} ${resourceManager.getString(R.string.million_suffix)}"
        }

        absValue >= 1_000 -> {
            "$${absValue / 1_000} ${resourceManager.getString(R.string.thousand_suffix)}"
        }

        else -> "$$this"
    }
}
