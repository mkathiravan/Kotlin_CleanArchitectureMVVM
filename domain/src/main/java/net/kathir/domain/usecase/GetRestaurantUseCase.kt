package net.kathir.domain.usecase

import io.reactivex.Observable
import net.kathir.domain.model.Restaurant
import net.kathir.domain.repository.RestaurantRepository
import javax.inject.Inject

class GetRestaurantUseCase @Inject constructor(private val restaurantRepository: RestaurantRepository) {
    sealed class Result {
        object Loading : Result()
        data class Success(val restaurant: Restaurant) : Result()
        data class Failure(val throwable: Throwable) : Result()
    }

    fun execute(id: Int): Observable<Result> {
        return restaurantRepository.getRestaurant(id)
            .toObservable()
            .map { Result.Success(it) as Result }
            .onErrorReturn { Result.Failure(it) }
            .startWith(Result.Loading)
    }
}