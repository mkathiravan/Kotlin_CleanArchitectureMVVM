package net.kathir.data

import io.reactivex.Single
import net.kathir.data.response.RestaurantResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RestaurantEndpoint {

    @GET("restaurant/")
    fun getRestaurantList(@Query("lat") lat:Double,@Query("lng") lng:Double,
                          @Query("offset") offset:Int,@Query("limit") limit: Int) : Single<List<RestaurantResponse>>

    @GET("restaurant/{id}")
    fun getRestaurant(@Path("id") id: Int) : Single<RestaurantResponse>

}