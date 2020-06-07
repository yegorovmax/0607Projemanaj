package com.projemanag.robots

import android.view.View
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.projemanag.R
import org.hamcrest.Matcher

fun profileDetail(func: MyProfileRobot.() -> Unit) = MyProfileRobot().apply { func() }

class MyProfileRobot : BaseRobot() {

    private val profileNameMatcher: Matcher<View> = withId(R.id.et_name)
    private val updateButton: Matcher<View> = withId(R.id.btn_update)

    fun tapUpdateProfileButton() = tapBy(updateButton)
    fun editProfileName(text: String) = typeInText(text, profileNameMatcher)
    fun getUserName() = getMatcherText(profileNameMatcher)
}