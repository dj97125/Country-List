package com.example.countrylist.Model.remote.CountryRepository;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0014\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bH\u0016J\u0013\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rJ\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0011"}, d2 = {"Lcom/example/countrylist/Model/remote/CountryRepository/NetworkRepositoryImpl;", "Lcom/example/countrylist/Model/remote/CountryRepository/NetworkRepository;", "countriesLocalDataSource", "Lcom/example/countrylist/Model/data/datasource/CountriesLocalDataSource;", "countriesRemoteDataSource", "Lcom/example/countrylist/Model/data/datasource/CountriesRemoteDataSource;", "(Lcom/example/countrylist/Model/data/datasource/CountriesLocalDataSource;Lcom/example/countrylist/Model/data/datasource/CountriesRemoteDataSource;)V", "countries", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/example/countrylist/domain/Countries;", "countryCached", "Lcom/example/countrylist/Common/Error;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "findByname", "name", "", "app_debug"})
public final class NetworkRepositoryImpl implements com.example.countrylist.Model.remote.CountryRepository.NetworkRepository {
    private final com.example.countrylist.Model.data.datasource.CountriesLocalDataSource countriesLocalDataSource = null;
    private final com.example.countrylist.Model.data.datasource.CountriesRemoteDataSource countriesRemoteDataSource = null;
    
    @javax.inject.Inject()
    public NetworkRepositoryImpl(@org.jetbrains.annotations.NotNull()
    com.example.countrylist.Model.data.datasource.CountriesLocalDataSource countriesLocalDataSource, @org.jetbrains.annotations.NotNull()
    com.example.countrylist.Model.data.datasource.CountriesRemoteDataSource countriesRemoteDataSource) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object countryCached(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.countrylist.Common.Error> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public kotlinx.coroutines.flow.Flow<com.example.countrylist.domain.Countries> findByname(@org.jetbrains.annotations.NotNull()
    java.lang.String name) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public kotlinx.coroutines.flow.Flow<java.util.List<com.example.countrylist.domain.Countries>> countries() {
        return null;
    }
}