package com.satellites.main_data.di

import android.content.Context
import com.satellites.main_data.repository.SatellitesRepositoryImpl
import com.satellites.main_domain.repository.SatellitesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MainDataModule {

    /* Repositories */
    @Provides
    @Singleton
    fun provideMainRepository(
        @ApplicationContext context: Context
    ): SatellitesRepository {
        return SatellitesRepositoryImpl(
            context
        )
    }
}