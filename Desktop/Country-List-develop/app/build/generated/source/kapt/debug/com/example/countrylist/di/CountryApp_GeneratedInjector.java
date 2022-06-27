package com.example.countrylist.di;

import dagger.hilt.InstallIn;
import dagger.hilt.codegen.OriginatingElement;
import dagger.hilt.components.SingletonComponent;
import dagger.hilt.internal.GeneratedEntryPoint;

@OriginatingElement(
    topLevelClass = CountryApp.class
)
@GeneratedEntryPoint
@InstallIn(SingletonComponent.class)
public interface CountryApp_GeneratedInjector {
  void injectCountryApp(CountryApp countryApp);
}
