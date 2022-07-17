package com.example.countrylist.model.local.DataBase

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.filters.SmallTest
import com.example.countrylist.di.ServiceModule
import com.example.countrylist.model.local.CountryDao
import com.example.countrylist.model.local.CountryDataBase
import com.example.countrylist.model.local.CountryEntity
import com.example.countrylist.model.local.DataBase.DI.TestDB
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

/**
 * Room: Google is the responsable for testing, but in an
 * dataBase with more complex sql queries and we
 * want to test it and see if still works as expected after
 * changing them
 */


@ExperimentalCoroutinesApi
//@RunWith(AndroidJUnit4::class)
@UninstallModules(ServiceModule::class)
@SmallTest
@HiltAndroidTest
class CountryEntityDataBaseTest @Inject constructor(
   @TestDB private val dataBase: CountryDataBase
) {


    @get:Rule(order = 1)
    var hiltRule = HiltAndroidRule(this)

    @get:Rule(order = 2)
    var rule = InstantTaskExecutorRule()


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
        val countryEntities = listOf(
            CountryEntity( "uno", "uno", "uno", "uno"),
            CountryEntity( "dos", "dos", "dos", "dos"),
        )
        countryDao.insertLocalCountry(countryEntities)

        val allCountries = countryDao.getAllCachedCountries()

        assertThat(allCountries).contains(countryEntities)

    }

    @Test
    fun deleteAllCountryLocalItem() = runTest {
        val countryEntityLists = listOf(
            CountryEntity( "uno", "uno", "uno", "uno"),
            CountryEntity( "dos", "dos", "dos", "dos")
        )

        countryDao.insertLocalCountry(countryEntityLists)
        countryDao.deleteAllCountryLocalItem()

        val allCountries = countryDao.getAllCachedCountries()

        assertThat(allCountries).doesNotContain(countryEntityLists)

    }

    @Test
    fun getAllCachedCountries() = runTest {
        val countryEntityLists = listOf(
            CountryEntity( "uno", "uno", "uno", "uno"),
            CountryEntity( "dos", "dos", "dos", "dos")
        )
        countryDao.insertLocalCountry(countryEntityLists)



        val totalCountries = countryDao.getAllCachedCountries()

        assertThat(totalCountries).isEqualTo(2)


    }


}