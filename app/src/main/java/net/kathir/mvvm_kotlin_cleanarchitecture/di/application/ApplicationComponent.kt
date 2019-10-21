package net.kathir.mvvm_kotlin_cleanarchitecture.di.application

import dagger.Component
import net.kathir.mvvm_kotlin_cleanarchitecture.BaseApplication
import net.kathir.mvvm_kotlin_cleanarchitecture.di.screen.ScreenComponent
import net.kathir.mvvm_kotlin_cleanarchitecture.di.screen.ScreenModule
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class, RepositoryModule::class, EndpointModule::class])
interface ApplicationComponent {

    fun inject(activity: BaseApplication)

    fun plus(screenModule: ScreenModule): ScreenComponent
}