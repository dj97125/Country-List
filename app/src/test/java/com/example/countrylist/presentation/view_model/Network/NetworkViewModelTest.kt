package com.example.countrylist.presentation.view_model.Network

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import app.cash.turbine.test
import com.example.countrylist.common.StateAction
import com.example.countrylist.domain.Country
import com.example.countrylist.domain.UseCase
import com.example.countrylist.presentation.view_model.NetworkViewModel
import com.example.countrylist.util.MainCoroutineRule
import com.example.countrylist.util.sampleCountry
import com.google.common.truth.Truth.assertThat
import io.mockk.clearAllMocks
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.whenever


@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class NetworkViewModelTest {


    @get:Rule
    var rule = InstantTaskExecutorRule()

    @ExperimentalCoroutinesApi
    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    lateinit var subject: NetworkViewModel

    @Mock
    lateinit var useCase: UseCase

    private val testDispatcher = UnconfinedTestDispatcher()
    private val testScopeCoroutine = TestScope(testDispatcher)
    private val countries = listOf(sampleCountry.copy(capital = "EU"))

    @Test
    fun `test everything works`() {
        assertTrue(true)
    }

    @Before
    fun setUpTest() {

        subject = NetworkViewModel(useCase, testScopeCoroutine)

    }
    @Test
    fun `get country list when fetching data from server returns SUCCESS response`() =
       runTest(testDispatcher) {
            whenever(useCase.invoke())
           doReturn(flowOf(StateAction.SUCCESS(countries)))

//                .thenReturn(flowOf(StateAction.SUCCESS(listOf(mockk<Country>()))))

            subject.getCountryList()

            subject.countryResponse.test {
                assertEquals(StateAction.SUCCESS(countries) , awaitItem())
                cancelAndConsumeRemainingEvents()
            }

//            assertEquals(StateActionTestList.size,1)
//            val success = StateActionTestList.get(0) as StateAction.SUCCESS<List<Country>>
//            assertEquals(success.response.size, StateActionTestList.size)
//            //assertThat(StateActionTestList[0]).isEqualTo(success)



        }

//    @Test
//    fun `get country list when fetching data from server returns SUCCESS response`() =
//        runTest {
//            whenever(useCase.invoke())
//                .thenReturn(flowOf(StateAction.SUCCESS(listOf(mockk<Country>()))))
//
//            var StateActionTestList = mutableListOf<StateAction?>()
//
//
//            val job = launch(testDispatcher) {
//                testDispatcher.scheduler.advanceTimeBy(4000L)
//                subject.countryResponse.toList(StateActionTestList)
//            }
//            subject.getCountryList()
//            assertEquals(StateActionTestList.size,1)
//            val success = StateActionTestList.get(0) as StateAction.SUCCESS<List<Country>>
//            assertEquals(success.response.size, StateActionTestList.size)
////            assertThat(StateActionTestList[0]).isEqualTo(StateAction.SUCCESS<Country>)
//
//            job.cancel()
//
//
//        }

//    @Test
//    fun `get country list when fetching data from server returns ERROR response`() =
//        runTest(testDispatcher) {
//            whenever(
//                useCase()
//            ).thenReturn(
//                flowOf(StateAction.ERROR(Exception("Error fetching data from server")))
//            )
//            subject.getCountryList()
//
//            var StateActionTestList = mutableListOf<StateAction?>()
//
//            val job = launch(testDispatcher) {
//                subject.countryResponse.toList(StateActionTestList)
//            }
//
//            assertThat(subject.countryResponse.value is StateAction.ERROR)
//            assertEquals(1, StateActionTestList.size)
//            job.cancel()
//
//
//
//
//            job.cancel()
//
//
//        }

//    @Test
//    fun `get country list when fetching data from server returns ERROR response`() =
//        runTest(testDispatcher) {
//            whenever(
//                useCase()
//            ).thenReturn(
//                flowOf(StateAction.ERROR(Exception("Error fetching data from server")))
//            )
//            subject.getCountryList()
//            var StateActionTestList = mutableListOf<StateAction?>()
//
//            useCase().test {
//                expectMostRecentItem()
//
//            }
//
//
//        }

    @After
    fun shutdownTest() {
        clearAllMocks()
        Dispatchers.resetMain()
    }

}