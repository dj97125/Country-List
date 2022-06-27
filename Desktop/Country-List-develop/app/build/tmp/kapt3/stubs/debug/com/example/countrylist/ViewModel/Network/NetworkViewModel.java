package com.example.countrylist.ViewModel.Network;

import java.lang.System;

@dagger.hilt.android.lifecycle.HiltViewModel()
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0006\u0010\u000e\u001a\u00020\u000fR\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0010"}, d2 = {"Lcom/example/countrylist/ViewModel/Network/NetworkViewModel;", "Landroidx/lifecycle/ViewModel;", "getCountries", "Lcom/example/countrylist/usecases/GetCountries;", "requestCountries", "Lcom/example/countrylist/usecases/RequestCountries;", "(Lcom/example/countrylist/usecases/GetCountries;Lcom/example/countrylist/usecases/RequestCountries;)V", "_state", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/example/countrylist/ViewModel/Network/UiState;", "state", "Lkotlinx/coroutines/flow/StateFlow;", "getState", "()Lkotlinx/coroutines/flow/StateFlow;", "onUiReady", "", "app_debug"})
public final class NetworkViewModel extends androidx.lifecycle.ViewModel {
    private final com.example.countrylist.usecases.GetCountries getCountries = null;
    private final com.example.countrylist.usecases.RequestCountries requestCountries = null;
    private final kotlinx.coroutines.flow.MutableStateFlow<com.example.countrylist.ViewModel.Network.UiState> _state = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.example.countrylist.ViewModel.Network.UiState> state = null;
    
    @javax.inject.Inject()
    public NetworkViewModel(@org.jetbrains.annotations.NotNull()
    com.example.countrylist.usecases.GetCountries getCountries, @org.jetbrains.annotations.NotNull()
    com.example.countrylist.usecases.RequestCountries requestCountries) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.example.countrylist.ViewModel.Network.UiState> getState() {
        return null;
    }
    
    public final void onUiReady() {
    }
}