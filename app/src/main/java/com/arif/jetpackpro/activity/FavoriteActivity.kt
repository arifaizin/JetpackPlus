package com.arif.jetpackpro.activity

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.arif.jetpackpro.R
import com.arif.jetpackpro.fragment.FavoriteFragment
import kotlinx.android.synthetic.main.activity_main_tab.*

class FavoriteActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorite)

        supportActionBar?.hide()
        setupViewPager()
    }

    private fun setupViewPager() {
        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
        view_pager.adapter = sectionsPagerAdapter
        tabs.setupWithViewPager(view_pager)
    }

    class SectionsPagerAdapter(private val context: Context, fm: FragmentManager) : FragmentPagerAdapter(fm) {

        private val tabTitles = arrayOf(
            R.string.tab_text_1,
            R.string.tab_text_2
        )

        override fun getItem(position: Int): androidx.fragment.app.Fragment {
            return FavoriteFragment.newInstance(position + 1)
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return context.resources.getString(tabTitles[position])
        }

        override fun getCount(): Int {
            return 2
        }
    }
}
