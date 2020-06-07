package com.projemanag.robots

import android.view.View
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.projemanag.R
import org.hamcrest.Matcher

fun letsGetStarted(func: LetsGetStarted.() -> Unit) = LetsGetStarted().apply { func() }

class LetsGetStarted : BaseRobot() {
    private val signInBtnMatcher: Matcher<View> = withId(R.id.btn_sign_in_intro)
    private val signUpBtnMatcher: Matcher<View> = withId(R.id.btn_sign_up_intro)

    fun tapSignInBtn() = tapBy(signInBtnMatcher)
    fun tapSignUpBtn() = isDisplayedBy(signUpBtnMatcher)

}