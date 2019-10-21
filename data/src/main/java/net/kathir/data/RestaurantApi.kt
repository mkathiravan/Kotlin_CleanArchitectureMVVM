package net.kathir.data

import io.reactivex.Single
import net.kathir.data.response.RestaurantResponse
import javax.inject.Inject

class RestaurantApi @Inject constructor(private val restaurantEndpoint:RestaurantEndpoint)
{
  fun getRestaurantList(lat:Double,lng:Double,offset:Int,limit:Int) : Single<List<RestaurantResponse>>
  {
      return restaurantEndpoint.getRestaurantList(lat, lng, offset, limit)
  }

  fun getRestaurant(id: Int) : Single<RestaurantResponse>
  {
      return restaurantEndpoint.getRestaurant(id)
  }
}