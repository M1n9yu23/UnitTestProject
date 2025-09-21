package com.bossmg.android.unittestproject

import androidx.lifecycle.Lifecycle
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ApplicationProvider.getApplicationContext
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.closeSoftKeyboard
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.bossmg.android.unittestproject.uitest.InputActivity
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import kotlin.jvm.java

@RunWith(AndroidJUnit4::class)
@LargeTest
class StringTransformFlowTest {
    private val myApplication = getApplicationContext<TestMyApplication>()

    @Before
    fun setUp() {
        IdlingRegistry.getInstance().register(myApplication.countingIdlingResource)
        val scenario = ActivityScenario.launch(InputActivity::class.java)
        scenario.moveToState(Lifecycle.State.RESUMED)
    }

    @Test
    fun verifyStringTransformation() {
        onView(withId(R.id.input_edit_text)).perform(typeText("android"), closeSoftKeyboard())

        onView(withId(R.id.transform_button)).perform(click())
        onView(withId(R.id.result_text_view))
            .check(matches(withText("Result: ANDROID")))
    }
}
