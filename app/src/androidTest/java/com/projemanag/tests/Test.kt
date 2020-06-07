package com.projemanag.tests

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import com.projemanag.activities.MainActivity
import com.projemanag.robots.*
import junit.framework.Assert
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class Test : BaseTest() {
    @Rule
    @JvmField
    val rule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun addListToBoard(){
        boardList {
           // sleep(5000)
            tapBoardCard()
        }
//        board {
//           // sleep()
//            tapDeleteListButtonIfPresent()
//            tapYesButtonIfPresent()
//            //sleep()
//            tapAddListButton()
//            typeListName(listName)
//            tapSaveListNameButton()
//            //sleep(5000)
//            //      assertEquals(listName, getListName())
//            tapDeleteListButton()
//            tapYesButton()
//        }
    }

    @Test
    fun addCard(){
        boardList {
           // sleep(5000)
            tapBoardCard()
        }
//        board {
//          //  sleep()
//            tapDeleteListButtonIfPresent()
//            tapYesButtonIfPresent()
//           // sleep()
//            tapAddListButton()
//            typeListName(listName)
//            tapSaveListNameButton()
//          //  sleep(5000)
//            tapAddCardButton()
//            typeCardtName(cardName)
//            tapSaveCardNameButton()
//          //  sleep(5000)
//            Assert.assertEquals(cardName, getCardName())
//            tapDeleteListButton()
//            tapYesButton()
//        }
    }
}
