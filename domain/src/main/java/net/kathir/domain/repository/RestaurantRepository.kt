package net.kathir.domain.repository

import io.reactivex.Single
import net.kathir.domain.model.Restaurant

interface RestaurantRepository {

  fun getRestaurantList(lat: Double, lng: Double, offset: Int, limit: Int): Single<List<Restaurant>>

  fun getRestaurant(id: Int): Single<Restaurant>

}
