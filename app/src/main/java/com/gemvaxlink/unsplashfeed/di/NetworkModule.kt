package com.gemvaxlink.unsplashfeed.di

import com.gemvaxlink.unsplashfeed.BuildConfig.API_KEY
import com.gemvaxlink.unsplashfeed.data.collection.CollectionService
import com.gemvaxlink.unsplashfeed.data.photo.PhotoService
import com.gemvaxlink.unsplashfeed.data.search.SearchService
import com.gemvaxlink.unsplashfeed.data.user.UserService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient = OkHttpClient.Builder()
        .addInterceptor { chain ->
            val originalRequest = chain.request()
            val newRequest = originalRequest.newBuilder()
                .header("Authorization", "Client-ID ${API_KEY}")
                .build()
            chain.proceed(newRequest)
        }.build()

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .baseUrl("https://api.unsplash.com/")
        .client(okHttpClient)
        .addConverterFactory(
            Json {
                isLenient = true // Json 큰따옴표 느슨하게 체크.
                ignoreUnknownKeys = true // Field 값이 없는 경우 무시
                coerceInputValues = true // "null" 이 들어간경우 default
            }.asConverterFactory(contentType = "application/json".toMediaType())
        )
        .build()

    @Provides
    fun providePhotoService(retrofit: Retrofit): PhotoService =
        retrofit.create(PhotoService::class.java)

    @Provides
    fun provideCollectionService(retrofit: Retrofit): CollectionService =
        retrofit.create(CollectionService::class.java)

    @Provides
    fun provideSearchService(retrofit: Retrofit): SearchService =
        retrofit.create(SearchService::class.java)

    @Provides
    fun provideUserService(retrofit: Retrofit): UserService =
        retrofit.create(UserService::class.java)
}
