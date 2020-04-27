package com.arifaizin.jetpackpro.ui.fragment

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.arifaizin.jetpackpro.R
import com.arifaizin.jetpackpro.ui.activity.MainTabActivity
import com.arifaizin.jetpackpro.ui.adapter.SectionsPagerAdapter
import kotlinx.android.synthetic.main.fragment_main_tab.*

class MainTabFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main_tab, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if(activity is MainTabActivity){
            (activity as MainTabActivity).setSupportActionBar(toolbar)
        }

        setHasOptionsMenu(true)
        setupViewPager()
    }

    private fun setupViewPager() {
        val sectionsPagerAdapter =
            SectionsPagerAdapter(
                context as Context,
                childFragmentManager
            )
        view_pager.adapter = sectionsPagerAdapter
        tabs.setupWithViewPager(view_pager)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu, inflater)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.action_change_settings) {
            val mIntent = Intent(Settings.ACTION_LOCALE_SETTINGS)
            startActivity(mIntent)
        } else if (item.itemId == R.id.action_favorite) {
            view?.findNavController()?.navigate(R.id.action_mainTabFragment_to_favoriteNav)

        }
        return super.onOptionsItemSelected(item)
    }
}
