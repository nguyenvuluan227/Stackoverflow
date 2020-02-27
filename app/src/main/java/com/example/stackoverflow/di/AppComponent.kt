package com.example.stackoverflow.di

import android.app.Application
import com.example.data.di.RemoteModule
import com.example.data.di.RemoteUserModule
import com.example.data.di.RepositoryModule
import com.example.stackoverflow.App
import com.example.stackoverflow.activity.main.MainModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton


@Singleton
@Component(
    modules = [
        AppModule::class,
        AppBindingModule::class,
        RemoteModule::class,
        RemoteUserModule::class,
        RepositoryModule::class,
        AndroidSupportInjectionModule::class,
        MainModule::class
    ]
)
interface AppComponent : AndroidInjector<App> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(app: App): Builder

        fun build(): AppComponent
    }

    fun inject(application: Application)
}