package com.arifaizin.jetpackpro.favorite

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity


class MainFavoriteActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_favorite)

        supportActionBar?.hide()
    }
}
