package com.arif.jetpackpro.fragment

import android.content.Context
import com.arif.jetpackpro.di.AppComponent
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [DatabaseTestModule::class])
interface TestComponent : AppComponent {
    @Component.Factory
    interface Factory {
        // With @BindsInstance, the Context passed in will be available in the graph
        fun create(@BindsInstance context: Context): TestComponent
    }

    fun inject(test: FavoriteTest)
}