package com.satellites.core.data.di

import android.app.Application
import android.content.SharedPreferences
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKeys
import com.satellites.core.data.local.preferences.PreferenceHelperImpl
import com.satellites.core.data.remote.ServiceCreator
import com.satellites.core.data.remote.interceptor.DefaultHeaderInterceptor
import com.satellites.core.domain.preferences.PreferenceHelper
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CoreDataModule {

    @Provides
    @Singleton
    fun provideSharedPreferences(
        app: Application
    ): SharedPreferences {
        val masterKeyAlias = MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC)
        return EncryptedSharedPreferences.create(
            "com.satellites.preferences",
            masterKeyAlias,
            app,
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
        )
    }

    @Provides
    @Singleton
    fun providePreference(sharedPreferences: SharedPreferences): PreferenceHelper {
        return PreferenceHelperImpl(sharedPreferences)
    }

    @Provides
    @Singleton
    fun provideDefaultHeaderInterceptor(): DefaultHeaderInterceptor {
        return DefaultHeaderInterceptor()
    }

    @Provides
    @Singleton
    fun provideMoshi(moshiBuilder: Moshi.Builder): Moshi {
        return moshiBuilder.build()
    }

    @Provides
    @Singleton
    fun provideMoshBuilder(): Moshi.Builder {
        return Moshi.Builder()
    }

    @Provides
    @Singleton
    fun serviceCreator(
        defaultHeaderInterceptor: DefaultHeaderInterceptor,
        moshi: Moshi
    ): ServiceCreator {
        return ServiceCreator("https://www.google.com", defaultHeaderInterceptor, moshi)
    }
}