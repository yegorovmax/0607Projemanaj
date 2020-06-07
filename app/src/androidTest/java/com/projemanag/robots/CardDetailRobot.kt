package com.projemanag.robots

import android.view.View
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withEffectiveVisibility
import androidx.test.espresso.matcher.ViewMatchers.Visibility
import androidx.test.espresso.matcher.ViewMatchers.withClassName
import com.projemanag.R
import org.hamcrest.Matcher
import org.hamcrest.Matchers

fun cardDetail(func: CardDetailRobot.() -> Unit) = CardDetailRobot().apply { func() }

class CardDetailRobot : BaseRobot() {
    val cardNameMatcher: Matcher<View> = withId(R.id.et_name_card_details)
    val updateButton: Matcher<View> = withId(R.id.btn_update_card_details)
    val deleteBoardMatcher: Matcher<View> = withId(R.id.action_delete_card)

    fun updateCardName(name: String) = typeInText(name, cardNameMatcher)
    fun tapUpdateCardDetails() = tapBy(updateButton)
    fun tapDeleteCardButton() = tapBy(deleteBoardMatcher)
}