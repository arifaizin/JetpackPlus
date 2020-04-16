package com.arifaizin.jetpackpro.favorite.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.arifaizin.jetpackpro.favorite.R


class MainFavoriteActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_favorite)

        supportActionBar?.hide()
    }
}
