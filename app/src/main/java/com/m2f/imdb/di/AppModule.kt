package com.m2f.imdb.di

import com.m2f.IMDB.core.di.CoreComponent
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun providesCoreComponent(): CoreComponent = CoreComponent.defaultInstance()

}