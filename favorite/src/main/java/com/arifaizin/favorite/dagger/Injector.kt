package com.arifaizin.favorite.dagger

import com.arif.jetpackpro.coreComponent
import com.arifaizin.favorite.ui.FavoriteFragment

fun inject(fragment: FavoriteFragment) {
    DaggerFavoriteComponent.factory()
        .create(
            fragment.requireContext(),
            fragment.requireActivity().coreComponent()
        )
        .inject(fragment)
}