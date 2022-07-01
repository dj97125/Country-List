package com.example.countrylist.Model.Local.DataBase

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.filters.SmallTest
import com.example.countrylist.Model.Local.CountryDao
import com.example.countrylist.Model.Local.CountryDataBase
import com.example.countrylist.Model.Local.CountryEntity
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
    fun insertLocalCountry() = runTest {
        val country = listOf(
            CountryEntity(1, "uno", "uno", "uno", "uno"),
            CountryEntity(2, "dos", "dos", "dos", "dos"),
        )
        countryDao.insertLocalCountry(country)

        val allCountries = countryDao.getAllCachedCountries()

        assertThat(allCountries).contains(country)

    }

    @Test
    fun deleteAllCountryLocalItem() = runTest {
        val countryList = listOf(
            CountryEntity(1, "uno", "uno", "uno", "uno"),
            CountryEntity(2, "dos", "dos", "dos", "dos")
        )

        countryDao.insertLocalCountry(countryList)
        countryDao.deleteAllCountryLocalItem()

        val allCountries = countryDao.getAllCachedCountries()

        assertThat(allCountries).doesNotContain(countryList)

    }

    @Test
    fun getAllCachedCountries() = runTest {
        val countryList = listOf(
            CountryEntity(1, "uno", "uno", "uno", "uno"),
            CountryEntity(2, "dos", "dos", "dos", "dos")
        )
        countryDao.insertLocalCountry(countryList)



        val totalCountries = countryDao.getAllCachedCountries()

        assertThat(totalCountries).isEqualTo(2)


    }


}