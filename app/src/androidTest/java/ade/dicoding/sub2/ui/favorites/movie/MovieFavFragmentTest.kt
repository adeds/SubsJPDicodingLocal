package ade.dicoding.sub2.ui.favorites.movie

import ade.dicoding.sub2.R
import ade.dicoding.sub2.testing.SingleFragmentActivity
import ade.dicoding.sub2.utils.RecyclerViewItemCountAssertion
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onData
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withSpinnerText
import androidx.test.rule.ActivityTestRule
import org.hamcrest.Matchers
import org.hamcrest.Matchers.*
import org.hamcrest.core.AllOf.allOf
import org.junit.Before
import org.junit.Rule
import org.junit.Test


class MovieFavFragmentTest {
    private var favItemCount = 2
    private var favItemTitle = "Frozen II"
    @get:Rule
    var activityRule =
        ActivityTestRule(
            SingleFragmentActivity::class.java
        )
    private val movieFragment: MovieFavFragment = MovieFavFragment()

    @Before
    fun setUp() {
        activityRule.activity.setFragment(movieFragment)
    }

    @Test
    fun loadMovies() {
        onView(withId(R.id.rv_list))
            .check(matches(ViewMatchers.isDisplayed()))
        onView(withId(R.id.rv_list)).check(RecyclerViewItemCountAssertion(favItemCount))
        onView(withId(R.id.rv_list)).perform(
            RecyclerViewActions
                .actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click())
        )
        onView(withId(R.id.dtl_title)).check(matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun searchMovies() {
        loadMovies()
        Espresso.pressBack()
        onView(withId(R.id.rv_list))
            .check(matches(ViewMatchers.isDisplayed()))
        onView(withId(R.id.et_search)).perform(ViewActions.typeText(favItemTitle))
        onView(withId(R.id.rv_list)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
        onView(Matchers.allOf(withId(R.id.dtl_title)))
            .check(matches(ViewMatchers.withText(favItemTitle)))

    }

    @Test
    fun sort() {
        loadMovies()
        Espresso.pressBack()
        onView(withId(R.id.sp_sort))
            .check(matches(ViewMatchers.isDisplayed()))
        onView(withId(R.id.sp_sort)).perform(click())
        onData(allOf(`is`(instanceOf(String::class.java)), `is`("A-Z")))
            .perform(click())
        onView(withId(R.id.sp_sort))
            .check(matches(withSpinnerText(containsString("A-Z"))))
        onView(withId(R.id.rv_list)).check(RecyclerViewItemCountAssertion(favItemCount))

    }


}