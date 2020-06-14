package com.projemanag.tests

import androidx.test.espresso.IdlingRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import androidx.test.rule.ActivityTestRule
import com.projemanag.activities.IntroActivity
import com.projemanag.robots.*
import com.projemanag.utils.Constants.countingIdlingResource
import junit.framework.Assert.assertEquals
import org.junit.After
import org.junit.Before

open class AllTests {

    @LargeTest
    @RunWith(AndroidJUnit4::class)
    class AllTests {

        @Before
        fun setup() { IdlingRegistry.getInstance().register(countingIdlingResource) }

        @After
        fun tearDown() { IdlingRegistry.getInstance().unregister(countingIdlingResource) }

        @Rule
        @JvmField
        var activityRule: ActivityTestRule<IntroActivity> =
            ActivityTestRule(IntroActivity::class.java)
        private val boardWithImage = "board with image"
        private val abcBoadr = "ABC"
        private val xyzBoadr = "XYZ"
        private val defaultBoard = "Board"
        private val updatedCardName = "NewCardName"
        private val defaultCardName = "CardNameDefault"
        private val emptyBoardListName = "Add List"
        private val listName = "List"
        private val date = "12/05/1993"
        private val boardName = "Board"
        private val defaultName = "DefaultName"
        private val updatedName = "UpdatedName"
        private val emptyCardText = "Add Card"


        @Test
        fun addBoardTest() {
            login {
                tapSignIn()
                typeEmailToCreateBoard()
                typePassword()
                tapSignInButton()
            }
            boardList {
                tapFloatingButton()
            }

            createBoard {
                typeBoardName(testBoardName)
                tapCreateButton()
            }
        }

//        @Test
//        fun updateCardNameTest() {
//            login {
//                tapSignIn()
//                typeEmail()
//                typePassword()
//                tapSignInButton()
//            }
//
//            boardList {
//                selectBoard(abcBoadr)
//            }
//
//            boardDetail {
//                tapOncard()
//            }
//
//            cardDetail {
//                updateCardName(updatedCardName)
//                tapUpdateCardDetails()
//            }
//
//            boardDetail {
//                assertEquals(getCardNam(), updatedCardName)
//            }
//
//            boardDetail {
//                tapOncard()
//            }
//
//            cardDetail {
//                updateCardName(defaultCardName)
//                tapUpdateCardDetails()
//            }
//        }

        @Test
        fun addListToBoardTest(){
            login {
                tapSignIn()
                typeEmail()
                typePassword()
                tapSignInButton()
            }
            boardList {
                selectBoard(boardWithImage)
            }
            boardDetail {
                tapDeleteListButtonIfPresent()
                tapYesButtonIfPresent()
                tapAddListButton()
                typeListName(listName)
                tapSaveListNameButton()
                assertEquals(listName, getListNam())
                tapDeleteListButton(listName)
            }
            alert {
                tapOnYesButtonOnAlert()
            }
        }

        @Test
        fun createAndDeleteCardTest() {
            login {
                tapSignIn()
                typeEmail()
                typePassword()
                tapSignInButton()
            }

            boardList {
                selectBoard(xyzBoadr)
            }

            boardDetail {
                tapOnAddCardButton()
            }

            boardDetail {
                typeInCardNameField(defaultCardName)
                tapOnSaveCardNameButton()
                tapOncard()
            }

            cardDetail {
                tapDeleteCardButton()
            }

            alert {
                tapOnYesButtonOnAlert()
            }

            boardDetail {
                assertEquals(getEmptyCardText(), emptyCardText)
            }
        }

        @Test
        fun createAndDeleteListTest() {
            login {
                tapSignIn()
                typeEmail()
                typePassword()
                tapSignInButton()
            }

            boardList {
                selectBoard(boardWithImage)
            }

            boardDetail {
                tapOnAddListButton()
                typeInListNameField(listName)
                tapSaveListNameButton()
                tapDeleteListButton(listName)
            }

            alert {
                tapOnYesButtonOnAlert()
            }

            boardDetail {
                assertEquals(getEmptyBoardCardName(), emptyBoardListName)
            }
        }

       @Test
        fun updateUserNameTest() {

                login {
                    tapSignIn()
                    typeEmail()
                    typePassword()
                    tapSignInButton()
                }

                boardList {
                    swipeToolBar()
                }

                profile {
                    tapOnMyProfile()
                }

                profileDetail {
                    editProfileName(updatedName)
                    tapUpdateProfileButton()
                }

                boardList {
                    swipeToolBar()
                }

                profile {
                    tapOnMyProfile()
                }

                profileDetail {
                    assertEquals(getUserName(), updatedName)
                    editProfileName(defaultName)
                    tapUpdateProfileButton()
                }
        }
    }
} // test
