package com.example.countrylist.presentation.view

import androidx.test.espresso.IdlingRegistry
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.example.countrylist.common.StateAction
import com.example.countrylist.domain.Country
import com.example.countrylist.model.network.RemoteDataSource
import com.example.countrylist.util.MockWebServerRule
import com.example.countrylist.util.OkHttp3IdlingResource
import com.example.countrylist.util.fromJson
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import okhttp3.OkHttpClient
import okhttp3.mockwebserver.MockResponse
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import javax.inject.Inject
import org.junit.Assert.assertEquals


@ExperimentalCoroutinesApi
@HiltAndroidTest
class FragmentCountriesListTest {

    @get:Rule(order = 0)
    val hiltRule = HiltAndroidRule(this)

    @get:Rule(order = 1)
    val mockWebServerRule = MockWebServerRule()

    @get:Rule(order = 3)
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Inject
    lateinit var okHttpClient: OkHttpClient

    @Inject
    lateinit var remoteDataSource: RemoteDataSource

    @Before
    fun setUp() {
        mockWebServerRule.server.enqueue(
            MockResponse().fromJson("countries.json")
        )

        hiltRule.inject()

        val resource = OkHttp3IdlingResource.create("OkHttp", okHttpClient)
        IdlingRegistry.getInstance().register(resource)
    }

    @Test
    fun check_mock_server_is_wotking() = runTest{
        val countries = remoteDataSource.countryCached()
        countries.collect(){ stateAction ->
            when (stateAction){
                is StateAction.SUCCESS<*> -> {
                    val retrievevedCountries = stateAction.response as List<Country>
                    assertEquals("Kabul",retrievevedCountries[0].capital)
                }
            }

        }

    }
}