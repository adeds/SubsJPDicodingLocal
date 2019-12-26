package ade.dicoding.sub2.ui.detail

import ade.dicoding.sub2.R
import ade.dicoding.sub2.util.EspressoIdlingResource
import android.content.Context
import android.content.Intent
import android.widget.TextView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import org.hamcrest.core.AllOf.allOf
import org.hamcrest.core.IsInstanceOf.instanceOf
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test


class DetailActivityTest {
    @Before
    fun setUp() {
        IdlingRegistry.getInstance().register(EspressoIdlingResource.idlingResource)
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.idlingResource)
    }

    @get:Rule
    var activityTestRule: ActivityTestRule<DetailActivity> =
        object : ActivityTestRule<DetailActivity>(DetailActivity::class.java) {
            override fun getActivityIntent(): Intent {
                val targetContext: Context =
                    InstrumentationRegistry.getInstrumentation().targetContext
                val result = Intent(targetContext, DetailActivity::class.java)
                result.putExtra(DetailActivity.EXTRA_ITEM, "Frozen II")
                result.putExtra(DetailActivity.EXTRA_IS_MOVIE, true)
                result.putExtra(DetailActivity.EXTRA_ID_CONTENT, 330457)
                return result
            }
        }

    @Test
    fun loadCourse() {
        onView(withId(R.id.dtl_date)).check(matches(isDisplayed()))
        onView(withId(R.id.dtl_desc)).check(matches(isDisplayed()))
        onView(withId(R.id.dtl_img)).check(matches(isDisplayed()))
        onView(withId(R.id.dtl_title)).check(matches(isDisplayed()))
//        Espresso.onView(ViewMatchers.withText("Frozen II"))
//            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(
            allOf(
                instanceOf(TextView::class.java),
                withParent(withResourceName("toolbar"))
            )
        ).check(matches(withText("Frozen II")))
    }
}