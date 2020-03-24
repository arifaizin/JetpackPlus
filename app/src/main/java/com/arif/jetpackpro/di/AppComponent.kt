package com.arif.jetpackpro.di

import android.content.Context
import com.arif.jetpackpro.activity.DetailActivity
import com.arif.jetpackpro.fragment.FavoriteFragment
import com.arif.jetpackpro.fragment.ListMovieFragment
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton




@Singleton  //TODO 4 : Add Dagger Scope - @Singleton
//TODO 2 : Add @Component - Ngasih tau dagger kelas mana saja yg butuh request injection
@Component(modules = [DatabaseModule::class])
interface AppComponent {
    @Component.Factory
    interface Factory {
        // With @BindsInstance, the Context passed in will be available in the graph
        fun create(@BindsInstance context: Context): AppComponent
    }

    fun inject(activity: DetailActivity)
    fun inject(fragment: ListMovieFragment)
    fun inject(fragment: FavoriteFragment)
}


