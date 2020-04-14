package com.arif.jetpackpro.ui.activity


import android.view.View
import android.view.ViewGroup
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.LargeTest
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.rule.ActivityTestRule
import com.arif.jetpackpro.R
import com.arifaizin.core.util.EspressoIdlingResource
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf
import org.hamcrest.TypeSafeMatcher
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@LargeTest
@RunWith(AndroidJUnit4ClassRunner::class)
class ShowMovieTest {
    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainTabActivity::class.java)

    @Before
    fun setUp() {
        IdlingRegistry.getInstance().register(EspressoIdlingResource.getEspressoIdlingResource())
    }

    @Test
    fun showDetailMovie() {
        val frameLayout = onView(
            allOf(
                childAtPosition(
                    allOf(
                        withId(R.id.recycleMovie),
                        childAtPosition(
                            withId(R.id.constraintLayout),
                            0
                        )
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        frameLayout.perform(click())
        onView(withId(R.id.detailTextTitle)).check(matches(isDisplayed()))
        onView(withId(R.id.detailTextOverview)).check(matches(isDisplayed()))
        onView(withId(R.id.detailTextRelease)).check(matches(isDisplayed()))
    }

    @Test
    fun showDetailTvShow() {
        val tabView = onView(
            allOf(
                withContentDescription("Acara TV"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.tabs),
                        0
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        tabView.perform(click())

        val frameLayout = onView(
            allOf(
                childAtPosition(
                    allOf(
                        withId(R.id.recycleMovie),
                        childAtPosition(
                            withId(R.id.constraintLayout),
                            0
                        )
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        frameLayout.perform(click())
        onView(withId(R.id.detailTextTitle)).check(matches(isDisplayed()))
        onView(withId(R.id.detailTextOverview)).check(matches(isDisplayed()))
        onView(withId(R.id.detailTextRelease)).check(matches(isDisplayed()))
    }

    private fun childAtPosition(
        parentMatcher: Matcher<View>, position: Int
    ): Matcher<View> {

        return object : TypeSafeMatcher<View>() {
            override fun describeTo(description: Description) {
                description.appendText("Child at position $position in parent ")
                parentMatcher.describeTo(description)
            }

            public override fun matchesSafely(view: View): Boolean {
                val parent = view.parent
                return parent is ViewGroup && parentMatcher.matches(parent)
                        && view == parent.getChildAt(position)
            }
        }
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.getEspressoIdlingResource())
    }
}
