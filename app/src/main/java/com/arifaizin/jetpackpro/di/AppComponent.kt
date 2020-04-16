package com.arif.jetpackpro.di

import android.content.Context
import com.arif.jetpackpro.ui.activity.DetailActivity
import com.arif.jetpackpro.ui.fragment.ListMovieFragment
import com.arifaizin.core.di.CoreComponent
import com.arifaizin.core.di.scope.AppScope
import dagger.BindsInstance
import dagger.Component

@AppScope
@Component(
    dependencies = [CoreComponent::class]
)
interface AppComponent {
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context, coreComponent: CoreComponent): AppComponent
    }

    fun inject(activity: DetailActivity)
    fun inject(fragment: ListMovieFragment)
}

