package com.projemanag.robots

import android.view.View
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.projemanag.R
import getJsonValue
import org.hamcrest.Matcher

fun login(func: LoginRobot.() -> Unit) = LoginRobot().apply { func() }

class LoginRobot : BaseRobot() {
    private val signInButton: Matcher<View> = withId(R.id.btn_sign_in_intro)
    private val emailMatcher: Matcher<View> = withId(R.id.et_email)
    private val passwordMatcher: Matcher<View> = withId(R.id.et_password)
    private val signInButtonMatcher: Matcher<View> = withId(R.id.btn_sign_in)
    private val signInEmail = getJsonValue("email")
    private val signInEmailToCreateBoard = getJsonValue("emailToCreateBoard")
    private val signInPassword = getJsonValue("password")

    fun tapSignIn() = tapBy(signInButton)
    fun typeEmail() = typeInText(signInEmail, emailMatcher)
    fun typeEmailToCreateBoard() = typeInText(signInEmailToCreateBoard, emailMatcher)
    fun typePassword() = typeInText(signInPassword, passwordMatcher)
    fun tapSignInButton() = tapBy(signInButtonMatcher)
}