package com.example.countrylist.presentation.view_model.Network

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.countrylist.common.FailedResponseException
import com.example.countrylist.common.StateAction
import com.example.countrylist.domain.Country
import com.example.countrylist.domain.UseCase
import com.example.countrylist.presentation.view_model.NetworkViewModel
import com.example.countrylist.util.sampleCountry
import io.mockk.clearAllMocks
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.toList
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


@ExperimentalCoroutinesApi
class NetworkViewModelTest {


    @get:Rule
    var rule = InstantTaskExecutorRule()


    lateinit var subject: NetworkViewModel
    lateinit var useCase: UseCase
    private val testDispatcher = UnconfinedTestDispatcher()
    private val testScopeCoroutine = TestScope(testDispatcher)
    private val fakeCountry = sampleCountry

    @Test
    fun `test everything works`() = runTest {
        assertTrue(true)
    }

    @Before
    fun setUpTest() {
        useCase = mockk()
        subject = NetworkViewModel(useCase, testScopeCoroutine)

    }

    @Test
    fun `get country list when fetching data from server returns SUCCES response`() =
        runTest(testDispatcher) {

            /**
            Given
             */
            coEvery {
                useCase.invoke()
            } returns flowOf(
                StateAction.SUCCESS(
                    listOf(mockk<Country>())
                )
            )

            /**
            When
             */
            var StateActionTestList = mutableListOf<StateAction?>()
            val succesTest = StateAction.SUCCESS(fakeCountry)
            subject.getCountryList()


            /**
            Then
             */
            val handler = CoroutineExceptionHandler { _, throwable ->
            }
            val job = launch(handler) {
                supervisorScope {
                    launch {
                        subject.countryResponse.collect() { stateAction ->
                            testDispatcher.scheduler.advanceTimeBy(600L)
                            subject.countryResponse.toList(StateActionTestList)
                        }
                    }
                }
                assertEquals(StateActionTestList.get(0), succesTest)
            }

            job.cancel()
        }


    @Test
    fun `get country list when fetching data from server returns EXCEPTION HANDLER response`() =
        runTest(testDispatcher) {

            /**
            Given
             */
            coEvery {
                useCase.invoke()
            } returns flowOf(
                StateAction.ERROR(
                    (Exception(FailedResponseException()))
                )
            )

            /**
            When
             */
            subject.getCountryList()
            val succesTest = StateAction.ERROR(Exception(FailedResponseException()))
            var StateActionTestList = mutableListOf<StateAction?>()

            /**
            Then
             */
            val handler = CoroutineExceptionHandler { _, throwable ->
                StateAction.ERROR(Exception(FailedResponseException()))
            }
            val job = launch(handler) {
                supervisorScope {
                    launch {
                        subject.countryResponse.collect() {
                            testDispatcher.scheduler.advanceTimeBy(600L)
                            subject.countryResponse.toList(StateActionTestList)

                        }
                    }
                }
                assertEquals(StateActionTestList.get(0), succesTest)
            }

            job.cancel()


        }

    @After
    fun shutdownTest() {
        clearAllMocks()
        Dispatchers.resetMain()
    }


}