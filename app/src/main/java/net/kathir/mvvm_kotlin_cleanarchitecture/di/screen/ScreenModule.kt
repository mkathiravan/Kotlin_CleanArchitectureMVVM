package net.kathir.mvvm_kotlin_cleanarchitecture.di.screen

import dagger.Module
import dagger.Provides
import net.kathir.mvvm_kotlin_cleanarchitecture.di.scope.PerScreen
import net.kathir.mvvm_kotlin_cleanarchitecture.presentation.BaseActivity
import net.kathir.mvvm_kotlin_cleanarchitecture.presentation.main.MainRouter
import net.kathir.mvvm_kotlin_cleanarchitecture.presentation.restaurantdetail.RestaurantDetailRouter
import java.lang.ref.WeakReference
import javax.inject.Singleton

@Module
class ScreenModule(private val activity: BaseActivity)
{

    @PerScreen
    @Provides
    fun providesActivity() : BaseActivity
    {
        return activity
    }

    @PerScreen
    @Provides
    fun providesMainRouter(): MainRouter
    {
        return MainRouter(WeakReference(activity))
    }


    @PerScreen
    @Provides
    fun providesRestaurantDetailRouter() : RestaurantDetailRouter
    {
        return RestaurantDetailRouter(WeakReference(activity))
    }


}
