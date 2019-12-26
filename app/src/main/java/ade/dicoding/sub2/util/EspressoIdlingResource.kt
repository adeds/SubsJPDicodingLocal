package ade.dicoding.sub2.util

import androidx.test.espresso.IdlingResource


object EspressoIdlingResource {
    private const val RESOURCE = "GLOBAL"
    private val mCountingIdlingResource =
        SimpleCountingIdlingResource(
            RESOURCE
        )

    fun increment() {
        mCountingIdlingResource.increment()
    }

    fun decrement() {
        mCountingIdlingResource.decrement()
    }

    val idlingResource: IdlingResource
        get() = mCountingIdlingResource
}