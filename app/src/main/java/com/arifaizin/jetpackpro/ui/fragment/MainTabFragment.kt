package com.arifaizin.jetpackpro.ui.fragment

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.arifaizin.jetpackpro.BuildConfig
import com.arifaizin.jetpackpro.R
import com.arifaizin.jetpackpro.ui.activity.MainTabActivity
import com.arifaizin.jetpackpro.ui.adapter.SectionsPagerAdapter
import com.gaelmarhic.quadrant.QuadrantConstants
import com.google.android.play.core.splitinstall.SplitInstallManagerFactory
import com.google.android.play.core.splitinstall.SplitInstallRequest
import kotlinx.android.synthetic.main.fragment_main_tab.*

/**
 * A simple [Fragment] subclass.
 */
class MainTabFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val inflate = inflater.inflate(R.layout.fragment_main_tab, container, false)
        return inflate
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
//            startActivity<FavoriteActivity>()
//            installFavoriteModule()
//            Navigation.createNavigateOnClickListener(R.id.action_mainTabFragment_to_favoriteNav)
            view?.findNavController()?.navigate(R.id.action_mainTabFragment_to_favoriteNav)

        }
        return super.onOptionsItemSelected(item)
    }

    private fun installFavoriteModule() {
        val splitInstallManager = SplitInstallManagerFactory.create(parentFragment?.requireContext())
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
            i.setClassName(BuildConfig.APPLICATION_ID, QuadrantConstants.MAIN_FAVORITE_ACTIVITY)
            i.putExtra("ExtraInt", 3) // Test intent for Dynamic feature
            startActivity(i)
        } else {
            Log.e("intal", "Registration feature is not installed")
        }
    }
}
