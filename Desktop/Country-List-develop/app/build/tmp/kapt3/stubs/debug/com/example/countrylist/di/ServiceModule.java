package com.example.countrylist.di;

import java.lang.System;

@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007J\b\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006H\u0007J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0007J\u001a\u0010\u000e\u001a\u00020\u000f2\b\b\u0001\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0012H\u0007J\b\u0010\u0013\u001a\u00020\u0012H\u0007J\u0012\u0010\u0014\u001a\u00020\r2\b\b\u0001\u0010\u0015\u001a\u00020\u0016H\u0007\u00a8\u0006\u0017"}, d2 = {"Lcom/example/countrylist/di/ServiceModule;", "", "()V", "provideApiUrl", "", "provideCoroutineDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "provideCoroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "dispatcher", "provideCountryDao", "Lcom/example/countrylist/Model/Local/CountryDao;", "dataBase", "Lcom/example/countrylist/Model/Local/CountryDataBase;", "provideNycService", "Lcom/example/countrylist/Model/remote/RemoteService;", "apiUrl", "okHttpClient", "Lokhttp3/OkHttpClient;", "provideOkHttpClient", "provideRoom", "context", "Landroid/content/Context;", "app_debug"})
@dagger.Module()
public final class ServiceModule {
    @org.jetbrains.annotations.NotNull()
    public static final com.example.countrylist.di.ServiceModule INSTANCE = null;
    
    private ServiceModule() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @ApiUrl()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final java.lang.String provideApiUrl() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final okhttp3.OkHttpClient provideOkHttpClient() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.example.countrylist.Model.remote.RemoteService provideNycService(@org.jetbrains.annotations.NotNull()
    @ApiUrl()
    java.lang.String apiUrl, @org.jetbrains.annotations.NotNull()
    okhttp3.OkHttpClient okHttpClient) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @javax.inject.Singleton()
    public final kotlinx.coroutines.CoroutineDispatcher provideCoroutineDispatcher() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @javax.inject.Singleton()
    public final kotlinx.coroutines.CoroutineScope provideCoroutineScope(@org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.CoroutineDispatcher dispatcher) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @javax.inject.Singleton()
    public final com.example.countrylist.Model.Local.CountryDataBase provideRoom(@org.jetbrains.annotations.NotNull()
    @dagger.hilt.android.qualifiers.ApplicationContext()
    android.content.Context context) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @javax.inject.Singleton()
    public final com.example.countrylist.Model.Local.CountryDao provideCountryDao(@org.jetbrains.annotations.NotNull()
    com.example.countrylist.Model.Local.CountryDataBase dataBase) {
        return null;
    }
}