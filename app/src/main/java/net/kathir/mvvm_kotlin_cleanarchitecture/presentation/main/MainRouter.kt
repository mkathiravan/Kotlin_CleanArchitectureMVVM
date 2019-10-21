package net.kathir.mvvm_kotlin_cleanarchitecture.presentation.main

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import net.kathir.mvvm_kotlin_cleanarchitecture.presentation.imagedetail.ImageDetailActivity
import net.kathir.mvvm_kotlin_cleanarchitecture.presentation.restaurantdetail.RestaurantDetailActivity
import java.lang.ref.WeakReference

class MainRouter(private val activityRef:WeakReference<Activity>) {
    enum class Route{
        IMAGE_DETAIL,
        RESTAURANT_DETAIL
    }

    fun navigate(route: Route, bundle: Bundle = Bundle())
    {
        when (route) {
            Route.IMAGE_DETAIL -> { showNextScreen(ImageDetailActivity::class.java, bundle) }
            Route.RESTAURANT_DETAIL -> { showNextScreen(RestaurantDetailActivity::class.java, bundle) }
        }
    }

    private fun showNextScreen(clazz: Class<*>, bundle: Bundle?) {
        activityRef.get()?.startActivity(bundle?.let { Intent(activityRef.get(), clazz).putExtras(it) })
    }
}