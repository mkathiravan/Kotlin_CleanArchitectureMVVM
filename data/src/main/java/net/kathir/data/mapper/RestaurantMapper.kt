package net.kathir.data.mapper

import net.kathir.data.response.RestaurantResponse
import net.kathir.domain.model.Restaurant
import javax.inject.Inject

class RestaurantMapper @Inject constructor() {

    fun map(responseList : List<RestaurantResponse>): List<Restaurant>
    {
        return responseList.map { (map(it)) }
    }

    fun map(response: RestaurantResponse): Restaurant {
        return Restaurant(
            id = response.id,
            name = response.name,
            description = response.description,
            coverImgUrl = response.coverImgUrl,
            status = response.status,
            deliveryFee = response.deliveryFee
        )
    }
}