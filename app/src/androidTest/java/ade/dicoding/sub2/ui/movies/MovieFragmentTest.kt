package ade.dicoding.sub2.ui.movies

import ade.dicoding.sub2.R
import ade.dicoding.sub2.testing.SingleFragmentActivity
import ade.dicoding.sub2.util.EspressoIdlingResource
import ade.dicoding.sub2.utils.RecyclerViewItemCountAssertion
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.rule.ActivityTestRule
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class MovieFragmentTest {
    @get:Rule
    var activityRule =
        ActivityTestRule(
            SingleFragmentActivity::class.java
        )
    private val movieFragment: MovieFragment = MovieFragment()

    @Before
    fun setUp() {
        IdlingRegistry.getInstance().register(EspressoIdlingResource.idlingResource)
        activityRule.activity.setFragment(movieFragment)
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.idlingResource)
    }

    @Test
    fun loadMovies() {
        Espresso.onView(ViewMatchers.withId(R.id.rv_list))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.rv_list)).check(RecyclerViewItemCountAssertion(10))
        Espresso.onView(ViewMatchers.withId(R.id.rv_list)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                ViewActions.click()
            )
        )

        Espresso.onView(ViewMatchers.withId(R.id.dtl_title))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun searchMovies() {
        loadMovies()
        Espresso.pressBack()
        Espresso.onView(ViewMatchers.withId(R.id.rv_list))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.et_search)).perform(ViewActions.typeText("Frozen"))
        Espresso.onView(ViewMatchers.withId(R.id.rv_list)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                ViewActions.click()
            )
        )
        Espresso.onView(ViewMatchers.withText("Frozen II"))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

    }
}