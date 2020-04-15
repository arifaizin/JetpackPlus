package com.arifaizin.favorite.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.arifaizin.favorite.R

class MainFavoriteActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_favorite)

        supportActionBar?.hide()
    }
}
