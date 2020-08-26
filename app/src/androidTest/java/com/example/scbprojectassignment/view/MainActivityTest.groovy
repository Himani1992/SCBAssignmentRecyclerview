package com.example.scbprojectassignment.view

import androidx.test.core.app.ActivityScenario
import androidx.test.runner.AndroidJUnitRunner
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityTest {

    @Test
    fun _isVisible(){
        var activitySchenario= ActivityScenario.launch(MainActivity.class)

        onView(withId(R.id.listOfMovies)).check(matches(isDisplayed()))         // check Recyclertview is visible

    }

    @Test
    fun _performClick(){
        var activitySchenario= ActivityScenario.launch(MainActivity.class)

        onView(withId(R.id.listOfMovies))
                .perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
    }
}
