package net.kathir.mvvm_kotlin_cleanarchitecture.presentation

import androidx.appcompat.app.AppCompatActivity
import net.kathir.mvvm_kotlin_cleanarchitecture.BaseApplication
import net.kathir.mvvm_kotlin_cleanarchitecture.di.application.ApplicationComponent
import net.kathir.mvvm_kotlin_cleanarchitecture.di.screen.ScreenModule

open class BaseActivity : AppCompatActivity(){

    val screenComponent by lazy {
        getApplicationComponent().plus(ScreenModule(this))
    }

    private fun getApplicationComponent() : ApplicationComponent
    {
        return (application as BaseApplication).component
    }
}