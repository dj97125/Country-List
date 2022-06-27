package com.example.countrylist.Model.remote;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J+\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\r"}, d2 = {"Lcom/example/countrylist/Model/remote/CountrieServerDataSource;", "Lcom/example/countrylist/Model/data/datasource/CountriesRemoteDataSource;", "remoteService", "Lcom/example/countrylist/Model/remote/RemoteService;", "(Lcom/example/countrylist/Model/remote/RemoteService;)V", "findcountries", "Larrow/core/Either;", "Lcom/example/countrylist/Common/Error;", "", "Lcom/example/countrylist/domain/Countries;", "code", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class CountrieServerDataSource implements com.example.countrylist.Model.data.datasource.CountriesRemoteDataSource {
    private final com.example.countrylist.Model.remote.RemoteService remoteService = null;
    
    @javax.inject.Inject()
    public CountrieServerDataSource(@org.jetbrains.annotations.NotNull()
    com.example.countrylist.Model.remote.RemoteService remoteService) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object findcountries(@org.jetbrains.annotations.NotNull()
    java.lang.String code, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super arrow.core.Either<? extends com.example.countrylist.Common.Error, ? extends java.util.List<com.example.countrylist.domain.Countries>>> continuation) {
        return null;
    }
}