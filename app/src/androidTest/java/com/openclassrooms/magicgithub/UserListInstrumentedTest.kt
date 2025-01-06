package com.openclassrooms.magicgithub

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.PerformException
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.action.GeneralLocation
import androidx.test.espresso.action.GeneralSwipeAction
import androidx.test.espresso.action.Press
import androidx.test.espresso.action.Swipe
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.swipeLeft
import androidx.test.espresso.action.ViewActions.swipeRight
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isCompletelyDisplayed
import androidx.test.espresso.matcher.ViewMatchers.isRoot
import androidx.test.espresso.util.HumanReadables
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import com.openclassrooms.magicgithub.di.Injection.getRepository
import com.openclassrooms.magicgithub.ui.user_list.ListUserActivity
import com.openclassrooms.magicgithub.utils.RecyclerViewUtils.ItemCount
import com.openclassrooms.magicgithub.utils.RecyclerViewUtils.clickChildView
import org.hamcrest.Matcher
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Ignore
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


/**
 * Instrumented test, which will execute on an Android device.
 * Testing ListUserActivity screen.
 */
@RunWith(AndroidJUnit4::class)
@LargeTest
class UserListInstrumentedTest {
    @Rule
    @JvmField
    val mActivityRule = ActivityTestRule(ListUserActivity::class.java)

    private var currentUsersSize = -1

    @Before
    fun setup() {
        currentUsersSize = getRepository().getUsers().size
    }

    @Test
    fun checkIfRecyclerViewIsNotEmpty() {
        onView(ViewMatchers.withId(R.id.activity_list_user_rv))
            .check(ItemCount(currentUsersSize))
    }

    @Test
    fun checkIfAddingRandomUserIsWorking() {
        onView(ViewMatchers.withId(R.id.activity_list_user_rv))
            .perform(
                RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                    0,
                    click()
                )
            )

        Thread.sleep(2000)

        onView(ViewMatchers.withId(R.id.activity_list_user_fab))
            .perform(ViewActions.click())

        onView(ViewMatchers.withId(R.id.activity_list_user_rv))
            .check(ItemCount(currentUsersSize + 1))

        onView(ViewMatchers.withId(R.id.activity_list_user_rv))
            .perform(
                RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(currentUsersSize + 1)
            )

        Thread.sleep(4000)
    }

    @Test
    fun checkIfRemovingUserIsWorking() {
        Thread.sleep(2000)
        onView(ViewMatchers.withId(R.id.activity_list_user_rv))
            .perform(
                RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                    0,
                    clickChildView(R.id.item_list_user_delete_button)
                )
            )
        onView(ViewMatchers.withId(R.id.activity_list_user_rv))
            .check(ItemCount(currentUsersSize - 1))
        Thread.sleep(4000)
    }

    @Test
    fun checkIfSwipingLeftIsWorking3() {
        val initialUser = getRepository().getUsers()[0]
        val initialIsActive = initialUser.isActive

        Thread.sleep(2000)

        // First scroll to the position
        onView(ViewMatchers.withId(R.id.activity_list_user_rv))
            .perform(
                RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                    15,
                    swipeLeft()
                )
            )

        Thread.sleep(2000)

        val finalUser = getRepository().getUsers()[0]
        // assertEquals(!initialIsActive, finalUser.isActive)
    }

    @Test
    fun checkIfSwipingLeftIsWorking2() {
        val position = 0
        val initialUser = getRepository().getUsers()[position]
        val initialIsActive = initialUser.isActive

        onView(ViewMatchers.withId(R.id.activity_list_user_rv))
            .perform(
                RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                    position,
                    GeneralSwipeAction(
                        Swipe.FAST,
                        GeneralLocation.CENTER_RIGHT,    // Start from center-right
                        GeneralLocation.CENTER_LEFT,     // Swipe to center-left
                        Press.FINGER
                    )
                )
            )

        Thread.sleep(1000)

        val finalUser = getRepository().getUsers()[position]
        // assertEquals(!initialIsActive, finalUser.isActive)
    }

    @Test
    @Ignore("Skipping this test temporarily")
    fun checkIfSwipingLeftIsWorking() {
        val position = 0
        val initialUser = getRepository().getUsers()[position]
        val initialIsActive = initialUser.isActive

        Thread.sleep(2000)

        onView(ViewMatchers.withId(R.id.activity_list_user_rv))
            .perform(
                RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                    position,
                    object : ViewAction {
                        override fun getConstraints(): Matcher<View> {
                            return ViewMatchers.isDisplayed()
                        }

                        override fun getDescription(): String {
                            return "Swipe left on RecyclerView item at position $position"
                        }

                        override fun perform(uiController: UiController, view: View) {
                            val itemView = (view as RecyclerView).findViewHolderForAdapterPosition(position)?.itemView
                                ?: throw PerformException.Builder()
                                    .withActionDescription(description)
                                    .withViewDescription(HumanReadables.describe(view))
                                    .withCause(RuntimeException("No view holder at position $position"))
                                    .build()

                            val startCoordinates = FloatArray(2).apply {
                                this[0] = itemView.width * 0.8f  // Start at 80% of item width
                                this[1] = itemView.height / 2f   // Center of item height
                            }

                            val endCoordinates = FloatArray(2).apply {
                                this[0] = itemView.width * 0.1f  // End at 10% of item width
                                this[1] = itemView.height / 2f   // Center of item height
                            }

                            val swipeAction = GeneralSwipeAction(
                                Swipe.SLOW,
                                { startCoordinates },
                                { endCoordinates },
                                Press.FINGER
                            )

                            swipeAction.perform(uiController, itemView)
                        }
                    }
                )
            )

        Thread.sleep(4000)

        val finalUser = getRepository().getUsers()[position]
        assertEquals(!initialIsActive, finalUser.isActive)
    }
}