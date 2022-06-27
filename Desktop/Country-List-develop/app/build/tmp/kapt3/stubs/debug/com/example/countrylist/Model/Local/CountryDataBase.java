package com.example.countrylist.Model.Local;

import java.lang.System;

@androidx.room.Database(version = 1, entities = {com.example.countrylist.Model.Local.DbCountries.class}, exportSchema = false)
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\'\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&\u00a8\u0006\u0005"}, d2 = {"Lcom/example/countrylist/Model/Local/CountryDataBase;", "Landroidx/room/RoomDatabase;", "()V", "countryDao", "Lcom/example/countrylist/Model/Local/CountryDao;", "app_debug"})
public abstract class CountryDataBase extends androidx.room.RoomDatabase {
    
    public CountryDataBase() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.example.countrylist.Model.Local.CountryDao countryDao();
}