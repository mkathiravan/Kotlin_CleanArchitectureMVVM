package net.kathir.mvvm_kotlin_cleanarchitecture.di.application

import dagger.Module
import dagger.Provides
import net.kathir.data.RestaurantEndpoint
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class EndpointModule {

    @Provides
    @Singleton

    fun provideRestaurantEndpoint(retrofit: Retrofit) : RestaurantEndpoint{
        return retrofit.create(RestaurantEndpoint::class.java)
    }
}