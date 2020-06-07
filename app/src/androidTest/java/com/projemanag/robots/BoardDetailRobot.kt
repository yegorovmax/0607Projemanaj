package com.projemanag.robots
import android.view.View
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withEffectiveVisibility
import androidx.test.espresso.matcher.ViewMatchers.Visibility
import androidx.test.espresso.matcher.ViewMatchers.hasSibling
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.projemanag.R
import org.hamcrest.CoreMatchers
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf

fun boardDetail(func: BoardDetailRobot.() -> Unit) = BoardDetailRobot().apply { func() }

class BoardDetailRobot : BaseRobot() {
    val cardNameMatcher: Matcher<View> = withId(R.id.tv_card_name)
    val createListMatcher: Matcher<View> = withId(R.id.tv_add_task_list)
    val listNameFieldMatcher: Matcher<View> = withId(R.id.et_task_list_name)
    val saveListNameMatcher: Matcher<View> = withId(R.id.ib_done_list_name)
    val deleteListButtonMatcher: Matcher<View> = withId(R.id.ib_delete_list)
    val addCardMatcher: Matcher<View> = allOf(
        withId(R.id.tv_add_card),
        withEffectiveVisibility(Visibility.VISIBLE)
    )
    val cardNameFieldMatcher: Matcher<View> = allOf(
        withId(R.id.et_card_name),
        withEffectiveVisibility(Visibility.VISIBLE)
    )
    val saveCardNameMatcher: Matcher<View> = allOf(
        withId(R.id.ib_done_card_name),
        withEffectiveVisibility(Visibility.VISIBLE)
    )
    fun tapDeleteListButton(text: String) {
        onView(allOf(deleteListButtonMatcher, hasSibling(withText(text))))
            .perform(click())
    }

    fun tapOncard() = tapBy(cardNameMatcher)
    fun getCardNam() = getMatcherText(cardNameMatcher)
    fun getEmptyBoardCardName() = getMatcherText(createListMatcher)
    fun tapOnAddListButton() = tapBy(createListMatcher)
    fun typeInListNameField(text: String) = typeInText(text, listNameFieldMatcher)
    fun tapSaveListNameButton() = tapBy(saveListNameMatcher)
    fun typeInCardNameField(text: String) = typeInText(text, cardNameFieldMatcher)
    fun tapOnSaveCardNameButton() = tapBy(saveCardNameMatcher)
    fun tapOnAddCardButton() = tapBy(addCardMatcher)
    fun getEmptyCardText() = getMatcherText(addCardMatcher)



    private val addListButtonMatcher: Matcher<View> = withId(R.id.tv_add_task_list)
    private val deleteListButonMatcher: Matcher<View> = CoreMatchers.allOf(
        withId(R.id.ib_delete_list),
        hasSibling(withText("listName"))
    )
    private val editListButtonMatcher: Matcher<View> = withId(R.id.ib_edit_list_name)
    private val addCardButtonMatcher: Matcher<View> = CoreMatchers.allOf(
        withId(R.id.tv_add_card),
        withEffectiveVisibility(Visibility.VISIBLE)
    )
    private val listNameTextFieldMatcher: Matcher<View> = withId(R.id.et_task_list_name)
    private val cardNameTextFieldMatcher: Matcher<View> = CoreMatchers.allOf(
        withId(R.id.et_card_name),
        withEffectiveVisibility(Visibility.VISIBLE)
    )
    private val saveCardNameButtonMatcher: Matcher<View> = CoreMatchers.allOf(
        withId(R.id.ib_done_card_name),
        withEffectiveVisibility(Visibility.VISIBLE)
    )
    private val saveListNameButtonMatcher: Matcher<View> = withId(R.id.ib_done_list_name)
    private val listNameMatcher: Matcher<View> = withText("listName")
    private val alertButtonYesMatcher: Matcher<View> = withId(android.R.id.button1)

    fun tapYesButtonIfPresent() = if(ifExist(alertButtonYesMatcher)) {
        tapBy(alertButtonYesMatcher)
    } else {}
    fun getCadName() = getMatcherText(cardNameMatcher)
    fun getListNam() = getMatcherText(listNameMatcher)
    fun tapAddListButton() = tapBy(addListButtonMatcher)
    fun tapDeleteListButton() = tapBy(deleteListButonMatcher)
    fun tapDeleteListButtonIfPresent() = if(ifExist(deleteListButonMatcher)) {
        tapBy(deleteListButonMatcher)
    } else {}
    fun tapEditListButton() = tapBy(editListButtonMatcher)
    fun tapAddCardButton() = tapBy(addCardButtonMatcher)
    fun tapSaveListNameButon() = tapBy(saveListNameButtonMatcher)
    fun tapSaveCardNameButton() = tapBy(saveCardNameButtonMatcher)
    fun typeListName(listName: String) = typeInText(listName, listNameTextFieldMatcher)
    fun typeCardtName(cardName: String) = typeInText(cardName, cardNameTextFieldMatcher)

}
