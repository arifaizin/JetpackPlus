package com.arifaizin.favorite.dagger

import android.content.Context
import com.arifaizin.core.di.scope.AppScope
import com.arifaizin.favorite.fragment.FavoriteFragment
import dagger.BindsInstance
import dagger.Component

@AppScope
@Component(
    modules = [DataModule::class]
)
interface FavoriteComponent {
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): FavoriteComponent
    }

    fun inject(fragment: FavoriteFragment)
}


