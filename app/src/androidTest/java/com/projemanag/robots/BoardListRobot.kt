package com.projemanag.robots

import android.view.View
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.projemanag.R
import org.hamcrest.Matcher

fun boardList(func: BoardListRobot.() -> Unit) = BoardListRobot().apply { func() }

class BoardListRobot : BaseRobot() {
    private val floatingButton: Matcher<View> = withId(R.id.fab_create_board)
    private val boardImage: Matcher<View> = withId(R.id.iv_board_image)

    private val boardsListRecyclerMatcher: Matcher<View> = withId(R.id.rv_boards_list)
    private val recyclerViewMatcher: Matcher<View> = withId(R.id.rv_boards_list)

    fun selectBoard(name: String) = tapRecyclerItemWithText(name, boardsListRecyclerMatcher)
    fun swipeToolBar() = swipeFromLeftToRight(recyclerViewMatcher)

    fun tapBoardCard() = tapBy(boardImage)
    fun tapFloatingButton() = tapBy(floatingButton)

}