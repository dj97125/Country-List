package com.example.countrylist.ViewModel.Network;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003H\u00c6\u0003J\u0011\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\bH\u00c6\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bH\u00c6\u0001J\u0013\u0010\u0014\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0016\u001a\u00020\u0017H\u00d6\u0001J\t\u0010\u0018\u001a\u00020\u0019H\u00d6\u0001R\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u001a"}, d2 = {"Lcom/example/countrylist/ViewModel/Network/UiState;", "", "loading", "", "countries", "", "Lcom/example/countrylist/domain/Countries;", "error", "Lcom/example/countrylist/Common/Error;", "(ZLjava/util/List;Lcom/example/countrylist/Common/Error;)V", "getCountries", "()Ljava/util/List;", "getError", "()Lcom/example/countrylist/Common/Error;", "getLoading", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "app_debug"})
public final class UiState {
    private final boolean loading = false;
    @org.jetbrains.annotations.Nullable()
    private final java.util.List<com.example.countrylist.domain.Countries> countries = null;
    @org.jetbrains.annotations.Nullable()
    private final com.example.countrylist.Common.Error error = null;
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.countrylist.ViewModel.Network.UiState copy(boolean loading, @org.jetbrains.annotations.Nullable()
    java.util.List<com.example.countrylist.domain.Countries> countries, @org.jetbrains.annotations.Nullable()
    com.example.countrylist.Common.Error error) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    public UiState() {
        super();
    }
    
    public UiState(boolean loading, @org.jetbrains.annotations.Nullable()
    java.util.List<com.example.countrylist.domain.Countries> countries, @org.jetbrains.annotations.Nullable()
    com.example.countrylist.Common.Error error) {
        super();
    }
    
    public final boolean component1() {
        return false;
    }
    
    public final boolean getLoading() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.example.countrylist.domain.Countries> component2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.example.countrylist.domain.Countries> getCountries() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.example.countrylist.Common.Error component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.example.countrylist.Common.Error getError() {
        return null;
    }
}