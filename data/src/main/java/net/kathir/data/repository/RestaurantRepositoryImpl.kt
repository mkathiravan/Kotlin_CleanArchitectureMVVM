package net.kathir.data.repository

import io.reactivex.Single
import net.kathir.data.RestaurantApi
import net.kathir.data.mapper.RestaurantMapper
import net.kathir.domain.model.Restaurant
import net.kathir.domain.repository.RestaurantRepository

class RestaurantRepositoryImpl(private val restaurantApi:RestaurantApi , private val restaurantMapper:RestaurantMapper) :
    RestaurantRepository

{
    override fun getRestaurantList(lat: Double, lng: Double, offset: Int, limit: Int): Single<List<Restaurant>> {
        return restaurantApi.getRestaurantList(lat, lng, offset, limit)
            .map { restaurantMapper.map(it) }
    }

    override fun getRestaurant(id: Int): Single<Restaurant> {
        return restaurantApi.getRestaurant(id)
            .map { restaurantMapper.map(it) }
    }

}
