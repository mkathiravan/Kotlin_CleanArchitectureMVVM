package net.kathir.mvvm_kotlin_cleanarchitecture.di.application

import dagger.Module
import dagger.Provides
import net.kathir.data.RestaurantApi
import net.kathir.data.mapper.RestaurantMapper
import net.kathir.data.repository.RestaurantRepositoryImpl
import net.kathir.domain.repository.RestaurantRepository
import javax.inject.Singleton

@Module
class RepositoryModule {
    @Provides
    @Singleton
    fun provideRestaurantRepository(restaurantApi: RestaurantApi, restaurantMapper: RestaurantMapper) : RestaurantRepository
    {
        return RestaurantRepositoryImpl(restaurantApi, restaurantMapper)
    }
}