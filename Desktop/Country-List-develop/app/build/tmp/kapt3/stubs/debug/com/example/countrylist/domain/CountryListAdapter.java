package com.example.countrylist.domain;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0010B\u0019\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\u0002\u0010\u0007J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000bH\u0016R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lcom/example/countrylist/domain/CountryListAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/example/countrylist/domain/Countries;", "Lcom/example/countrylist/domain/CountryListAdapter$NetworkViewHolder;", "listener", "Lkotlin/Function1;", "", "(Lkotlin/jvm/functions/Function1;)V", "onBindViewHolder", "holder", "position", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "NetworkViewHolder", "app_debug"})
public final class CountryListAdapter extends androidx.recyclerview.widget.ListAdapter<com.example.countrylist.domain.Countries, com.example.countrylist.domain.CountryListAdapter.NetworkViewHolder> {
    private final kotlin.jvm.functions.Function1<com.example.countrylist.domain.Countries, kotlin.Unit> listener = null;
    
    public CountryListAdapter(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.example.countrylist.domain.Countries, kotlin.Unit> listener) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.example.countrylist.domain.CountryListAdapter.NetworkViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.example.countrylist.domain.CountryListAdapter.NetworkViewHolder holder, int position) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/example/countrylist/domain/CountryListAdapter$NetworkViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/example/countrylist/databinding/CountriesListCardViewBinding;", "(Lcom/example/countrylist/databinding/CountriesListCardViewBinding;)V", "bind", "", "countries", "Lcom/example/countrylist/domain/Countries;", "app_debug"})
    public static final class NetworkViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        private final com.example.countrylist.databinding.CountriesListCardViewBinding binding = null;
        
        public NetworkViewHolder(@org.jetbrains.annotations.NotNull()
        com.example.countrylist.databinding.CountriesListCardViewBinding binding) {
            super(null);
        }
        
        public final void bind(@org.jetbrains.annotations.NotNull()
        com.example.countrylist.domain.Countries countries) {
        }
    }
}