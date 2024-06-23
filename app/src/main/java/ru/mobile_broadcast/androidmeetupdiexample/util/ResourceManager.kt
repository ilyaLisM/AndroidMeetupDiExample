package ru.mobile_broadcast.androidmeetupdiexample.util

import android.app.Application
import android.content.Context
import androidx.annotation.StringRes
import javax.inject.Inject

interface ResourceManager {

    fun getString(@StringRes id: Int): String

    fun getContext(): Context
}

class ResourceManagerImpl @Inject constructor(
    private val context: Application
) : ResourceManager {

    override fun getString(id: Int): String = context.getString(id)

    override fun getContext(): Context {
        return context
    }
}