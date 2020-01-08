package ade.dicoding.sub2.ui.tvshow

import ade.dicoding.sub2.R
import ade.dicoding.sub2.testing.SingleFragmentActivity
import ade.dicoding.sub2.util.EspressoIdlingResource
import ade.dicoding.sub2.utils.RecyclerViewItemCountAssertion
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.rule.ActivityTestRule
import org.hamcrest.Matchers
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class TvFragmentTest {
    @get:Rule
    var activityRule =
        ActivityTestRule(
            SingleFragmentActivity::class.java
        )
    private val tvFrag: TvFragment = TvFragment()

    @Before
    fun setUp() {
        IdlingRegistry.getInstance().register(EspressoIdlingResource.idlingResource)
        activityRule.activity.setFragment(tvFrag)
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.idlingResource)
    }


    @Test
    fun loadTVShows() {
        onView(withId(R.id.rv_list)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_list)).check(RecyclerViewItemCountAssertion(10))
    }

    @Test
    fun searchMovies() {
        loadTVShows()
        onView(withId(R.id.et_search)).check(matches(isDisplayed()))
        onView(withId(R.id.et_search)).perform(ViewActions.typeText("hame"))
        onView(withId(R.id.rv_list)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                ViewActions.click()
            )
        )
        onView(Matchers.allOf(withId(R.id.dtl_title)))
            .check(matches(ViewMatchers.withText("Shameless")))

    }
}