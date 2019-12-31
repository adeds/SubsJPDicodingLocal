package ade.dicoding.sub2.util

import androidx.test.espresso.IdlingResource
import java.util.concurrent.atomic.AtomicInteger


class SimpleCountingIdlingResource(resourceName: String?) :
    IdlingResource {
    private val mResourceName: String
    private val counter: AtomicInteger = AtomicInteger(0)
    @Volatile
    private var resourceCallback: IdlingResource.ResourceCallback? = null

    override fun getName(): String {
        return mResourceName
    }

    override fun isIdleNow(): Boolean {
        return counter.get() === 0
    }

    override fun registerIdleTransitionCallback(resourceCallback: IdlingResource.ResourceCallback) {
        this.resourceCallback = resourceCallback
    }

    fun increment() {
        counter.getAndIncrement()
    }

    fun decrement() {
        val counterVal: Int = counter.decrementAndGet()
        if (counterVal == 0) { // we've gone from non-zero to zero. That means we're idle now! Tell espresso.
            if (null != resourceCallback) {
                resourceCallback?.onTransitionToIdle()
            }
        }
        require(counterVal >= 0) { "Counter has been corrupted!" }
    }

    init {
        mResourceName = checkNotNull(resourceName)
    }
}