package com.example.mipt_pd3


import android.view.View
import android.view.ViewGroup
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withClassName
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withParent
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf
import org.hamcrest.Matchers.`is`
import org.hamcrest.TypeSafeMatcher
import org.hamcrest.core.IsInstanceOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class DisplayTest {

    @Rule
    @JvmField
    var mActivityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun displayTest() {
        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        Thread.sleep(500)

        val materialButton = onView(
            allOf(
                withId(R.id._4), withText("4"),
                childAtPosition(
                    childAtPosition(
                        withClassName(`is`("android.widget.LinearLayout")),
                        4
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        materialButton.perform(click())

        val materialButton2 = onView(
            allOf(
                withId(R.id._5), withText("5"),
                childAtPosition(
                    childAtPosition(
                        withClassName(`is`("android.widget.LinearLayout")),
                        4
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        materialButton2.perform(click())

        val materialButton3 = onView(
            allOf(
                withId(R.id._6), withText("6"),
                childAtPosition(
                    childAtPosition(
                        withClassName(`is`("android.widget.LinearLayout")),
                        4
                    ),
                    2
                ),
                isDisplayed()
            )
        )
        materialButton3.perform(click())

        val materialButton4 = onView(
            allOf(
                withId(R.id.deleteSymbol), withText("<-"),
                childAtPosition(
                    childAtPosition(
                        withClassName(`is`("android.widget.LinearLayout")),
                        2
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        materialButton4.perform(click())

        val textView = onView(
            allOf(
                withId(R.id.display), withText("45"),
                withParent(withParent(IsInstanceOf.instanceOf(android.view.ViewGroup::class.java))),
                isDisplayed()
            )
        )
        textView.check(matches(withText("45")))

        val textView2 = onView(
            allOf(
                withId(R.id.display), withText("45"),
                withParent(withParent(IsInstanceOf.instanceOf(android.view.ViewGroup::class.java))),
                isDisplayed()
            )
        )
        textView2.check(matches(withText("45")))

        val materialButton5 = onView(
            allOf(
                withId(R.id.clearEntry), withText("CE"),
                childAtPosition(
                    childAtPosition(
                        withClassName(`is`("android.widget.LinearLayout")),
                        2
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        materialButton5.perform(click())

        val textView3 = onView(
            allOf(
                withId(R.id.display), withText("0"),
                withParent(withParent(IsInstanceOf.instanceOf(android.view.ViewGroup::class.java))),
                isDisplayed()
            )
        )
        textView3.check(matches(withText("0")))

        val materialButton6 = onView(
            allOf(
                withId(R.id._5), withText("5"),
                childAtPosition(
                    childAtPosition(
                        withClassName(`is`("android.widget.LinearLayout")),
                        4
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        materialButton6.perform(click())

        val materialButton7 = onView(
            allOf(
                withId(R.id.changeSymbol), withText("+-"),
                childAtPosition(
                    childAtPosition(
                        withClassName(`is`("android.widget.LinearLayout")),
                        2
                    ),
                    3
                ),
                isDisplayed()
            )
        )
        materialButton7.perform(click())

        val textView4 = onView(
            allOf(
                withId(R.id.display), withText("-5"),
                withParent(withParent(IsInstanceOf.instanceOf(android.view.ViewGroup::class.java))),
                isDisplayed()
            )
        )
        textView4.check(matches(withText("-5")))

        val materialButton8 = onView(
            allOf(
                withId(R.id.clear), withText("C"),
                childAtPosition(
                    childAtPosition(
                        withClassName(`is`("android.widget.LinearLayout")),
                        2
                    ),
                    2
                ),
                isDisplayed()
            )
        )
        materialButton8.perform(click())

        val textView5 = onView(
            allOf(
                withId(R.id.display), withText("0"),
                withParent(withParent(IsInstanceOf.instanceOf(android.view.ViewGroup::class.java))),
                isDisplayed()
            )
        )
        textView5.check(matches(withText("0")))

        val materialButton9 = onView(
            allOf(
                withId(R.id._2), withText("2"),
                childAtPosition(
                    childAtPosition(
                        withClassName(`is`("android.widget.LinearLayout")),
                        0
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        materialButton9.perform(click())

        val materialButton10 = onView(
            allOf(
                withId(R.id._5), withText("5"),
                childAtPosition(
                    childAtPosition(
                        withClassName(`is`("android.widget.LinearLayout")),
                        4
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        materialButton10.perform(click())

        val materialButton11 = onView(
            allOf(
                withId(R.id.squareRoot), withText("√"),
                childAtPosition(
                    childAtPosition(
                        withClassName(`is`("android.widget.LinearLayout")),
                        2
                    ),
                    4
                ),
                isDisplayed()
            )
        )
        materialButton11.perform(click())

        val materialButton12 = onView(
            allOf(
                withId(R.id.equal), withText("="),
                childAtPosition(
                    childAtPosition(
                        withClassName(`is`("android.widget.LinearLayout")),
                        5
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        materialButton12.perform(click())

        val textView6 = onView(
            allOf(
                withId(R.id.display), withText("5"),
                withParent(withParent(IsInstanceOf.instanceOf(android.view.ViewGroup::class.java))),
                isDisplayed()
            )
        )
        textView6.check(matches(withText("5")))

        val materialButton13 = onView(
            allOf(
                withId(R.id.multiply), withText("*"),
                childAtPosition(
                    childAtPosition(
                        withClassName(`is`("android.widget.LinearLayout")),
                        4
                    ),
                    3
                ),
                isDisplayed()
            )
        )
        materialButton13.perform(click())

        val materialButton14 = onView(
            allOf(
                withId(R.id._3), withText("3"),
                childAtPosition(
                    childAtPosition(
                        withClassName(`is`("android.widget.LinearLayout")),
                        0
                    ),
                    2
                ),
                isDisplayed()
            )
        )
        materialButton14.perform(click())

        val materialButton15 = onView(
            allOf(
                withId(R.id.equal), withText("="),
                childAtPosition(
                    childAtPosition(
                        withClassName(`is`("android.widget.LinearLayout")),
                        5
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        materialButton15.perform(click())

        val textView7 = onView(
            allOf(
                withId(R.id.display), withText("15"),
                withParent(withParent(IsInstanceOf.instanceOf(android.view.ViewGroup::class.java))),
                isDisplayed()
            )
        )
        textView7.check(matches(withText("15")))

        val materialButton16 = onView(
            allOf(
                withId(R.id.divide), withText("/"),
                childAtPosition(
                    childAtPosition(
                        withClassName(`is`("android.widget.LinearLayout")),
                        3
                    ),
                    3
                ),
                isDisplayed()
            )
        )
        materialButton16.perform(click())

        val materialButton17 = onView(
            allOf(
                withId(R.id._0), withText("0"),
                childAtPosition(
                    childAtPosition(
                        withClassName(`is`("android.widget.LinearLayout")),
                        1
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        materialButton17.perform(click())

        val materialButton18 = onView(
            allOf(
                withId(R.id.equal), withText("="),
                childAtPosition(
                    childAtPosition(
                        withClassName(`is`("android.widget.LinearLayout")),
                        5
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        materialButton18.perform(click())

        val textView8 = onView(
            allOf(
                withId(R.id.display), withText("Error"),
                withParent(withParent(IsInstanceOf.instanceOf(android.view.ViewGroup::class.java))),
                isDisplayed()
            )
        )
        textView8.check(matches(withText("Error")))
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
}
