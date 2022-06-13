package com.example.countrylist.Model.Local.DataBase

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.filters.SmallTest
import com.example.countrylist.Domain.CountryDomain
import com.example.countrylist.Model.Local.Dao.CountryDao
import com.example.countrylist.Model.Local.Entities.CountryEntity
import com.example.countrylist.di.RoomModule
import com.google.common.truth.Truth.assertThat
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.UninstallModules
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import javax.inject.Inject
import javax.inject.Named

/**
 * Room: Google is the responsable for testing, but in an
 * dataBase with more complex sql queries and we
 * want to test it and see if still works as expected after
 * changing them
 */


@ExperimentalCoroutinesApi
//@RunWith(AndroidJUnit4::class)
@UninstallModules(RoomModule::class)
@SmallTest
@HiltAndroidTest
class CountryDataBaseTest {


    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @get:Rule
    var rule = InstantTaskExecutorRule()

    @Inject
    @Named("test_db")
    lateinit var dataBase: CountryDataBase
    lateinit var countryDao: CountryDao


    @Before
    fun setup() {
//        dataBase = Room.inMemoryDatabaseBuilder(
//            ApplicationProvider.getApplicationContext(),
//            CountryDataBase::class.java
//        ).allowMainThreadQueries().build()
        hiltRule.inject()
        countryDao = dataBase.countryDao()
    }

    @After
    fun closeDataBaseCountry() {
        dataBase.close()
    }

    @Test
    fun insertCountryItem() = runTest {
        val country = CountryEntity(id = 1, "uno", "uno", "uno", "uno")
        countryDao.insertLocalCountry(country)

        val allCountries = countryDao.getAllCachedCountries().getOrAwaitValue()

        assertThat(allCountries).contains(country)

    }

    @Test
    fun deleteCountryItem() = runTest {
        val country = CountryEntity(id = 1, "uno", "uno", "uno", "uno")
        countryDao.insertLocalCountry(country)
        countryDao.deleteAllCountryLocalItem(country)

        val allCountries = countryDao.observeCountries().getOrAwaitValue()

        assertThat(allCountries).doesNotContain(country)

    }

    @Test
    fun observeTotalCountryItem() = runTest {
        val country1 = CountryDomain(id = 1, "uno", "uno", "uno", "uno")
        val country2 = CountryDomain(id = 2, "dos", "dos", "dos", "dos")
        val country3 = CountryDomain(id = 3, "tres", "tres", "tres", "tres")
        countryDao.insertLocalCountry(country1)
        countryDao.insertLocalCountry(country2)
        countryDao.insertLocalCountry(country3)


        val totalCountries = countryDao.observeTotalLocalCountries().getOrAwaitValue()

        assertThat(totalCountries).isEqualTo(3)


    }


}