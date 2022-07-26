package com.example.countrylist.model.local
//
//import androidx.arch.core.executor.testing.InstantTaskExecutorRule
//import androidx.test.filters.SmallTest
//import com.example.countrylist.di.ServiceModule
//import com.example.countrylist.model.local.CountryDao
//import com.example.countrylist.model.local.CountryDataBase
//import com.example.countrylist.di.TestDB
//import com.example.countrylist.model.local.db.util.sampleCountry
//import com.google.common.truth.Truth.assertThat
//import dagger.hilt.android.testing.HiltAndroidRule
//import dagger.hilt.android.testing.HiltAndroidTest
//import dagger.hilt.android.testing.UninstallModules
//import kotlinx.coroutines.ExperimentalCoroutinesApi
//import kotlinx.coroutines.test.UnconfinedTestDispatcher
//import kotlinx.coroutines.test.runTest
//import org.junit.After
//import org.junit.Before
//import org.junit.Rule
//import org.junit.Test
//import javax.inject.Inject
//
///**
// * Room: Google is the responsable for testing, but in an
// * dataBase with more complex sql queries and we
// * want to test it and see if still works as expected after
// * changing them
// */
//
//
//@ExperimentalCoroutinesApi
////@RunWith(AndroidJUnit4::class)
//@UninstallModules(ServiceModule::class)
//@SmallTest
//@HiltAndroidTest
//class CountryEntityDataBaseTest {
//
//
//    @get:Rule(order = 1)
//    var hiltRule = HiltAndroidRule(this)
//
//    @get:Rule(order = 2)
//    var rule = InstantTaskExecutorRule()
//
//
////    @Inject
////    lateinit var dataBase: CountryDataBase
////
////    @Inject
////    lateinit var countryDao: CountryDao
//
//    private val testDispatcher = UnconfinedTestDispatcher()
//    private val fakeCountry = sampleCountry
//
//    @Before
//    fun setup() {
//        hiltRule.inject()
////        countryDao = dataBase.countryDao()
//    }
//
//    @After
//    fun closeDataBaseCountry() {
////        dataBase.close()
//    }
//
//
//    fun insertLocalCountry() = runTest(testDispatcher) {
//
//        countryDao.insertLocalCountry(fakeCountry)
//        val allCountries = countryDao.getAllCachedCountries()
//        assertThat(allCountries).contains(fakeCountry)
//
//    }
//
//
//    fun deleteAllCountryLocalItem() = runTest(testDispatcher) {
//
//
//        countryDao.insertLocalCountry(fakeCountry)
//        countryDao.deleteAllCountryLocalItem()
//
//        val allCountries = countryDao.getAllCachedCountries()
//
//        assertThat(allCountries).doesNotContain(fakeCountry)
//
//    }
//
//
//    fun getAllCachedCountries() = runTest(testDispatcher) {
//
//        countryDao.insertLocalCountry(fakeCountry)
//
//        val totalCountries = countryDao.getAllCachedCountries()
//
//        assertThat(totalCountries.size).isEqualTo(fakeCountry.size)
//
//
//    }
//
//
//}