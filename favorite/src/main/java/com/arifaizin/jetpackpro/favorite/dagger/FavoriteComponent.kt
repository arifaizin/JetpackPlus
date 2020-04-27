package com.arifaizin.jetpackpro.favorite.dagger

import android.content.Context
import com.arifaizin.core.data.datasource.MovieRepository
import com.arifaizin.core.di.CoreComponent
import com.arifaizin.core.di.scope.AppScope
import com.arifaizin.core.domain.FavoriteInteractor
import com.arifaizin.core.domain.FavoriteUseCase
import com.arifaizin.jetpackpro.favorite.ui.FavoriteFragment
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.Provides

@AppScope
@Component(
    modules = [FavoriteModule::class],
    dependencies = [CoreComponent::class]
)
interface FavoriteComponent {
    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance context: Context,
            coreComponent: CoreComponent
        ): FavoriteComponent
    }

    fun inject(fragment: FavoriteFragment)
}




