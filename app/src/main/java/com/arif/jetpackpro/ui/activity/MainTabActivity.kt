package com.arif.jetpackpro.ui.activity

import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.arif.jetpackpro.BuildConfig
import com.arif.jetpackpro.R
import com.arif.jetpackpro.ui.adapter.SectionsPagerAdapter
import com.google.android.play.core.splitinstall.SplitInstallManagerFactory
import com.google.android.play.core.splitinstall.SplitInstallRequest
import kotlinx.android.synthetic.main.activity_main_tab.*


class MainTabActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_tab)

        setupViewPager()

        setSupportActionBar(toolbar)
    }

    private fun setupViewPager() {
        val sectionsPagerAdapter =
            SectionsPagerAdapter(
                this,
                supportFragmentManager
            )
        view_pager.adapter = sectionsPagerAdapter
        tabs.setupWithViewPager(view_pager)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.action_change_settings) {
            val mIntent = Intent(Settings.ACTION_LOCALE_SETTINGS)
            startActivity(mIntent)
        } else if (item.itemId == R.id.action_favorite) {
//            startActivity<FavoriteActivity>()
            installFavoriteModule()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun installFavoriteModule() {
        val splitInstallManager = SplitInstallManagerFactory.create(applicationContext)
        val request = SplitInstallRequest.newBuilder()
            .addModule("favorite")
            .build()

        splitInstallManager.startInstall(request)
            .addOnSuccessListener {
                Log.d("installl", it.toString())
            }
            .addOnFailureListener {
                Log.e("install", it.toString())
            }

        if (splitInstallManager.installedModules.contains("favorite")) {
            val i = Intent()
            i.setClassName(BuildConfig.APPLICATION_ID, "com.arifaizin.favorite.ui.MainFavoriteActivity")
            i.putExtra("ExtraInt", 3) // Test intent for Dynamic feature
            startActivity(i)
        } else {
            Log.e("intal", "Registration feature is not installed")
        }
    }
}