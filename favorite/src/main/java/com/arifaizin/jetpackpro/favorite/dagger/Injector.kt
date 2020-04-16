package com.arifaizin.jetpackpro.favorite.dagger

import com.arifaizin.jetpackpro.coreComponent
import com.arifaizin.jetpackpro.favorite.ui.FavoriteFragment

fun inject(fragment: FavoriteFragment) {
    DaggerFavoriteComponent.factory()
        .create(
            fragment.requireContext(),
            fragment.requireActivity().coreComponent()
        )
        .inject(fragment)
}