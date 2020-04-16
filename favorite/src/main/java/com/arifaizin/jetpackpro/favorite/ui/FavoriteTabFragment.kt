package com.arifaizin.jetpackpro.favorite.ui


import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.arifaizin.jetpackpro.favorite.R
import kotlinx.android.synthetic.main.fragment_favorite_tab.*

class FavoriteTabFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val inflate = inflater.inflate(R.layout.fragment_favorite_tab, container, false)
        return inflate
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

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



    class SectionsPagerAdapter(private val context: Context, fm: FragmentManager) : androidx.fragment.app.FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

        val TAB_TITLES = arrayOf(
            R.string.tab_text_1,
            R.string.tab_text_2
        )

        override fun getItem(position: Int): Fragment {
            return FavoriteFragment.newInstance(
                position + 1
            )
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return context.resources.getString(TAB_TITLES[position])
        }

        override fun getCount(): Int {
            return 2
        }
    }
}
