package com.projemanag.robots

import android.view.View
import androidx.test.espresso.matcher.ViewMatchers.withText
import org.hamcrest.Matcher

fun alert(func: AlertRobot.() -> Unit) = AlertRobot().apply { func() }

class AlertRobot : BaseRobot() {
    val yesButtonMatcher: Matcher<View> = withText("Yes")
    val okButtonMatcher: Matcher<View> = withText("OK")

    fun tapOnYesButtonOnAlert() = tapBy(yesButtonMatcher)
    fun tapOnOkButtonMatcher() = tapBy(okButtonMatcher)
}