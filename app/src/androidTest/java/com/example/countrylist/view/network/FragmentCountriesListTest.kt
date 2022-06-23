package com.example.countrylist.view.network

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.MediumTest
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.example.countrylist.View.Network.MainActivity
import com.example.countrylist.common.FakeData
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import com.example.countrylist.R


@RunWith(AndroidJUnit4ClassRunner::class)
@MediumTest
@ExperimentalCoroutinesApi
class FragmentCountriesListTest {

    @get: Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    val LIST_ITEM_IN_TEST = 3
    val COUNTRY_LOCAL_IN_TEST = FakeData.countriesLocal[LIST_ITEM_IN_TEST]

    @Test
    fun test_is_list_fragment_visible() {
        onView(withId(R.id.recycler_view)).check(matches(isDisplayed()))
    }
}