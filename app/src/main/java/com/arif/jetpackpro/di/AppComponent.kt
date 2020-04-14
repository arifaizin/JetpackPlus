package com.arif.jetpackpro.di

import android.content.Context
import com.arif.jetpackpro.ui.activity.DetailActivity
import com.arif.jetpackpro.ui.fragment.ListMovieFragment
import com.arifaizin.core.di.scope.AppScope
import dagger.BindsInstance
import dagger.Component

@AppScope
@Component(
//    dependencies = [CoreComponent::class],
    modules = [DataModule::class]
)
interface AppComponent {
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }

    fun inject(activity: DetailActivity)
    fun inject(fragment: ListMovieFragment)
//    fun inject(fragment: FavoriteFragment)
}


