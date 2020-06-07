package com.projemanag.robots

import android.view.View
import androidx.test.espresso.matcher.ViewMatchers
import org.hamcrest.Matcher

fun profile(func: ProfileRobot.() -> Unit) = ProfileRobot().apply { func() }

class ProfileRobot : BaseRobot() {

    private val myProfileMatcher: Matcher<View> = ViewMatchers.withText("My Profile")

    fun tapOnMyProfile() = tapBy(myProfileMatcher)
}