package net.kathir.domain.usecase

import io.reactivex.Observable
import net.kathir.domain.model.Restaurant
import net.kathir.domain.usecase.GetRestaurantListUseCase.Result.Failure
import net.kathir.domain.usecase.GetRestaurantListUseCase.Result.Loading
import net.kathir.domain.usecase.GetRestaurantListUseCase.Result.Success
import net.kathir.domain.repository.RestaurantRepository
import javax.inject.Inject

class GetRestaurantListUseCase @Inject constructor(private val restaurantRepository: RestaurantRepository) {

    sealed class Result{
        object Loading : Result()
        data class Success(val restaurants: List<Restaurant>) : Result()
        data class Failure(val throwable: Throwable) : Result()
    }

    fun execute(lat:Double,lng:Double,offset:Int,limit:Int) : Observable<Result>
    {
        return restaurantRepository.getRestaurantList(lat, lng, offset, limit)
            .toObservable()
            .map { Result.Success(it) as Result }
            .onErrorReturn { Result.Failure(it) }
            .startWith(Result.Loading)
    }
}