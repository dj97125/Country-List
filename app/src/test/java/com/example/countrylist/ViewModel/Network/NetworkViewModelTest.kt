package com.example.countrylist.ViewModel.Network

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.countrylist.Common.StateAction
import com.example.countrylist.Model.Local.Dao.CountryDao
import com.example.countrylist.Model.Network.CountryRepository.NetworkRepository
import com.example.countrylist.Model.Network.CountryResponse.CountriesResponseItem
import com.example.countrylist.util.MainCoroutineRule
import com.google.common.truth.Truth.assertThat
import io.mockk.clearAllMocks
import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf

import kotlinx.coroutines.test.*
import org.junit.*
import org.junit.Assert.assertEquals
import java.lang.Exception

@ExperimentalCoroutinesApi
class NetworkViewModelTest {

    @get:Rule
    var rule = InstantTaskExecutorRule()

    @ExperimentalCoroutinesApi
    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    lateinit var subject: NetworkViewModel
    lateinit var repository: NetworkRepository
    lateinit var countryDao: CountryDao
    private val testDispatcher = UnconfinedTestDispatcher()
    private val testScopeCoroutine = TestScope(testDispatcher)

    @Before
    fun setUpTest() {
        repository = mockk()
        subject = NetworkViewModel(repository, testScopeCoroutine)
    }

    @Test
    fun `get country list when fetching data from server returns SUCCESS response`() = mainCoroutineRule.runBlockingTest  {
        //coEvery for suspend functions
        //Every for functions
        coEvery {
            repository.countryCached()
        } returns flowOf(
            StateAction.SUCCESS(
                listOf(
                    mockk<CountriesResponseItem>()
                )
            )
        )

        var StateActionTestList = mutableListOf<StateAction>()
        subject.countryResponse.observeForever {
            StateActionTestList.add(it)
        }

        subject.getCountryList()
        Assert.assertEquals(StateActionTestList.size, 1)
        val successTest =
            StateActionTestList.get(0) as StateAction.SUCCESS<List<CountriesResponseItem>>
        //assertEquals(successTest.response.size, 1)
        assertEquals(successTest.response.size, StateActionTestList.size)

    }

    @Test
    fun `get country list when fetching data from server returns LOADING response`() = mainCoroutineRule.runBlockingTest  {
        coEvery {
            repository.countryCached()
        } returns flowOf(StateAction.LOADING)

        var StateActionTestList = mutableListOf<StateAction>()
        subject.countryResponse.observeForever {
            StateActionTestList.add(it)
        }

        subject.getCountryList()
        val loadingTest = StateActionTestList.get(0) as StateAction.LOADING
        assertThat(loadingTest).isInstanceOf(StateAction.LOADING::class.java)

    }

    @Test
    fun `get country list when fetching data from server returns ERROR response`() = mainCoroutineRule.runBlockingTest  {
        coEvery {
            repository.countryCached()
        } returns flowOf(StateAction.ERROR(Exception("Error fetching data from server")))

        var StateActionTestList = mutableListOf<StateAction>()
        subject.countryResponse.observeForever {
            StateActionTestList.add(it)
        }

        subject.getCountryList()
        val errorTest = StateActionTestList.get(0) as StateAction.ERROR
        assertThat(errorTest).isInstanceOf(StateAction.ERROR::class.java)

    }

    @After
    fun shutdownTest() {
        clearAllMocks()
        Dispatchers.resetMain()
    }

}