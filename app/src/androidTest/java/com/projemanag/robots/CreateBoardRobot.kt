package com.projemanag.robots

import android.view.View
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.projemanag.R
import org.hamcrest.Matcher

fun createBoard(func: CreateBoardRobot.() -> Unit) = CreateBoardRobot().apply { func() }

class CreateBoardRobot : BaseRobot() {
    private val boardNameFieldMatcher: Matcher<View> = withId(R.id.et_board_name)
    private val createBoardButtonMatcher: Matcher<View> = withId(R.id.btn_create)

    fun tapCreateButton() = tapBy(createBoardButtonMatcher)
    fun typeBoardName(testBoardName: String) = typeInText(testBoardName, boardNameFieldMatcher)

}