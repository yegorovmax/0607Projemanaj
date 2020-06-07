package com.projemanag.robots

import android.view.View
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.projemanag.R
import org.hamcrest.Matcher

fun signIn(func: SignInRobot.() -> Unit) = SignInRobot().apply { func() }

class SignInRobot : BaseRobot() {
    private val emailFieldMatcher: Matcher<View> = withId(R.id.et_password )
    private val passwordFieldMatcher: Matcher<View> = withId(R.id.et_email)
    //   private val signInButtonMatcher: Matcher<View> = with

    fun typeEmail(email: String) = typeInText(email, emailFieldMatcher)
    fun typepassword(password: String) = typeInText(password, passwordFieldMatcher)
//    fun tapSignInButton() = tapBy(signInButtonMatcher)
}