package com.satellites.main_domain.di

import com.satellites.main_domain.interactor.CallSatelliteDetailUseCase
import com.satellites.main_domain.interactor.CallSatelliteListUseCase
import com.satellites.main_domain.interactor.CallSatellitePositionsUseCase
import com.satellites.main_domain.repository.SatellitesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object MainDomainModule {

    @ViewModelScoped
    @Provides
    fun provideCallSatelliteListUseCase(
        satellitesRepository: SatellitesRepository
    ): CallSatelliteListUseCase {
        return CallSatelliteListUseCase(
            satellitesRepository
        )
    }

    @ViewModelScoped
    @Provides
    fun provideCallSatelliteDetailUseCase(
        satellitesRepository: SatellitesRepository
    ): CallSatelliteDetailUseCase {
        return CallSatelliteDetailUseCase(
            satellitesRepository
        )
    }

    @ViewModelScoped
    @Provides
    fun provideCallSatellitePositionsUseCase(
        satellitesRepository: SatellitesRepository
    ): CallSatellitePositionsUseCase {
        return CallSatellitePositionsUseCase(
            satellitesRepository
        )
    }

}