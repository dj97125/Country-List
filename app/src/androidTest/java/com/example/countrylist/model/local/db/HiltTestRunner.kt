package com.example.countrylist.model.local.db
//com.example.countrylist.model.local.db.HiltTestRunner
//com.example.countrylist.Model.Local.DataBase.HiltTestRunner
import android.app.Application
import android.content.Context
import androidx.test.runner.AndroidJUnitRunner
import dagger.hilt.android.testing.HiltTestApplication

class HiltTestRunner : AndroidJUnitRunner() {

    override fun newApplication(cl: ClassLoader?, name: String?, context: Context?): Application {
        return super.newApplication(cl, HiltTestApplication::class.java.name, context)
    }

}