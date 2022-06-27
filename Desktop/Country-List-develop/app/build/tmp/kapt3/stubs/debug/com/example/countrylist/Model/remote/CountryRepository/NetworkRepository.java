package com.example.countrylist.Model.remote.CountryRepository;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H&J\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\bJ\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u00032\u0006\u0010\n\u001a\u00020\u000bH&\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\f"}, d2 = {"Lcom/example/countrylist/Model/remote/CountryRepository/NetworkRepository;", "", "countries", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/example/countrylist/domain/Countries;", "countryCached", "Lcom/example/countrylist/Common/Error;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "findByname", "name", "", "app_debug"})
public abstract interface NetworkRepository {
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object countryCached(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.countrylist.Common.Error> continuation);
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<com.example.countrylist.domain.Countries> findByname(@org.jetbrains.annotations.NotNull()
    java.lang.String name);
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.example.countrylist.domain.Countries>> countries();
}