package com.example.countrylist.Model.Local.DataBase

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.filters.SmallTest
import com.example.countrylist.Model.Local.Dao.CountryDao
import com.example.countrylist.Model.Local.Entities.CountryEntity
import com.example.countrylist.di.RoomModule
import com.google.common.truth.Truth.assertThat
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.UninstallModules
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
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
class CountryDataBaseTest @Inject constructor(
    @Named("test_db") private var dataBase: CountryDataBase,

) {

    @get:Rule(order = 0)
    var hiltRule = HiltAndroidRule(this)

    @get:Rule(order = 1)
    var rule = InstantTaskExecutorRule()

    private lateinit var dao: CountryDao

    @Before
    fun setup() {
//        dataBase = Room.inMemoryDatabaseBuilder(
//            ApplicationProvider.getApplicationContext(),
//            CountryDataBase::class.java
//        ).allowMainThreadQueries().build()
        hiltRule.inject()
        dao = dataBase.countryDao()
    }

    @After
    fun closeDataBaseCountry() {
        dataBase.close()
    }

    @Test
    fun insertLocalCountry() = runBlockingTest {
        val country = listOf(
            CountryEntity(1, "uno", "uno", "uno", "uno"),
            CountryEntity(2, "dos", "dos", "dos", "dos"),
        )

        dao.insertLocalCountry(country)

        val allCountries = dao.getAllCachedCountries()

        assertThat(allCountries).contains(country)

    }

    @Test
    fun deleteAllCountryLocalItem() = runBlockingTest {
        val countryList = listOf(
            CountryEntity(1, "uno", "uno", "uno", "uno"),
            CountryEntity(2, "dos", "dos", "dos", "dos")
        )

        dao.insertLocalCountry(countryList)
        dao.deleteAllCountryLocalItem()

        val allCountries = dao.getAllCachedCountries()

        assertThat(allCountries).doesNotContain(countryList)

    }

    @Test
    fun getAllCachedCountries() = runBlockingTest {
        val countryList = listOf(
            CountryEntity(1, "uno", "uno", "uno", "uno"),
            CountryEntity(2, "dos", "dos", "dos", "dos")
        )
        dao.insertLocalCountry(countryList)



        val totalCountries = dao.getAllCachedCountries()

        assertThat(totalCountries.size).isEqualTo(2)


    }


}