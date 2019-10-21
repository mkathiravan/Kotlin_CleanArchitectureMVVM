package net.kathir.mvvm_kotlin_cleanarchitecture.di.screen

import dagger.Subcomponent
import net.kathir.mvvm_kotlin_cleanarchitecture.di.scope.PerScreen
import net.kathir.mvvm_kotlin_cleanarchitecture.presentation.imagedetail.ImageDetailActivity
import net.kathir.mvvm_kotlin_cleanarchitecture.presentation.main.MainActivity
import net.kathir.mvvm_kotlin_cleanarchitecture.presentation.restaurantdetail.RestaurantDetailActivity

@PerScreen
@Subcomponent(modules = [ScreenModule::class])
interface ScreenComponent {

    fun inject(mainActivity: MainActivity)

    fun inject(restaurantDetailActivity: RestaurantDetailActivity)

    fun inject(imageDetailActivity: ImageDetailActivity)
}