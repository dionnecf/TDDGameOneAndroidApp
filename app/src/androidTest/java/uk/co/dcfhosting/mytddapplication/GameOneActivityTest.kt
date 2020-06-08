package uk.co.dcfhosting.mytddapplication

import android.content.Intent
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.GradientDrawable
import android.graphics.drawable.ShapeDrawable
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.annotation.ColorInt
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.BoundedMatcher
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.internal.util.Checks
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import kotlinx.android.synthetic.main.activity_main.*
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.equalTo
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class GameOneActivityTest {

    companion object {

        private fun withBackgroundColor(@ColorInt color: Int): Matcher<View> {
            Checks.checkNotNull(color)
            return object : BoundedMatcher<View, ConstraintLayout>(ConstraintLayout::class.java) {
                override fun describeTo(description: Description?) {
                    description?.appendText("ConstraintLayout background color to be $color")
                }

                override fun matchesSafely(item: ConstraintLayout?): Boolean {
                    val backgroundColor = item?.background as ColorDrawable
                    val colorDrawable = ColorDrawable(ContextCompat.getColor(item.context, color))
                    return colorDrawable.color == backgroundColor.color
                }

            }
        }

        fun textViewTextColorMatcher(matcherColor: Int): Matcher<View?>? {
            return object : BoundedMatcher<View?, TextView>(TextView::class.java) {
                override fun describeTo(description: Description) {
                    description.appendText("with text color: $matcherColor")
                }

                override fun matchesSafely(textView: TextView): Boolean {
                    return matcherColor == textView.currentTextColor
                }
            }
        }
    }

    @get:Rule var activityTestRule = ActivityTestRule(GameOneActivity::class.java)

    @Test
    public fun checkNumberAnswerLayoutExists() {
        activityTestRule.launchActivity(Intent())
        onView(withId(R.id.numbers_answer)).check(matches(isDisplayed()))
        onView(withId(R.id.numbers_answer)).check(matches(withBackgroundColor(R.color.colorWhite)))
    }
    @Test
    public fun checkNumberButtonsExists() {
        onView(withId(R.id.numberBtn1)).check(matches(withText("")))
        onView(withId(R.id.numberBtn2)).check(matches(isDisplayed()))
        onView(withId(R.id.numberBtn2)).check(matches(withText("")))
    }
}