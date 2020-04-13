package com.arifaizin.favorite.dagger

import com.arifaizin.favorite.fragment.FavoriteFragment

object FavoriteApplication {

    fun inject(activity : FavoriteFragment){
        val favoriteComponent: FavoriteComponent by lazy {
            // Creates an instance of AppComponent using its Factory constructor
            // We pass the applicationContext that will be used as Context in the graph
            DaggerFavoriteComponent.factory().create(activity.requireActivity())
        }
        favoriteComponent.inject(activity)
    }
}