package com.arifaizin.core.di

import android.content.Context
import com.arif.jetpackpro.di.DatabaseModule
import com.arifaizin.core.data.room.MovieDao
import com.arifaizin.core.data.room.MovieDatabase
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [DatabaseModule::class]
)
interface CoreComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): CoreComponent
    }

    //harus ada ini untuk provide ke component yg depend kesini
    fun provideDatabase(): MovieDatabase
    fun provideMovieDao(): MovieDao
}