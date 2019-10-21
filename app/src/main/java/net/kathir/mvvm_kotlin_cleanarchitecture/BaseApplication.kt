package net.kathir.mvvm_kotlin_cleanarchitecture

import android.app.Application
import net.kathir.mvvm_kotlin_cleanarchitecture.di.application.ApplicationComponent
import net.kathir.mvvm_kotlin_cleanarchitecture.di.application.ApplicationModule
import net.kathir.mvvm_kotlin_cleanarchitecture.di.application.DaggerApplicationComponent

class BaseApplication : Application() {

  lateinit var component : ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        inject()
    }

fun inject()
{
    component = DaggerApplicationComponent.builder().applicationModule(
        ApplicationModule(this)
    ).build()

    component.inject(this)
}

}