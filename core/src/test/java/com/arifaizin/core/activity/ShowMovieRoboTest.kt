package com.arifaizin.core.activity

import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config



@RunWith(RobolectricTestRunner::class)
@Config(sdk = [28], shadows = [ShadowViewPager::class])
class ShowMovieRoboTest {

    @Test
    fun showFavoriteMovie() {
//        val controller = Robolectric.buildActivity(MainTabActivity::class.java)
//        val activity = controller.create().start().resume().visible().get()
//
//        activity.onOptionsItemSelected(RoboMenuItem(R.id.action_favorite))
//
//        val shadowActivity = shadowOf(activity)
//        val startedIntent = shadowActivity.nextStartedActivity
//        val shadowIntent = shadowOf(startedIntent)
//        assertThat(
//            shadowIntent.intentClass.name,
//            equalTo(FavoriteActivity::class.java.name)
//        )
//
//        val sectionsPagerAdapter = FavoriteActivity.SectionsPagerAdapter(activity, activity.supportFragmentManager)
//        activity.findViewById<ViewPager>(R.id.view_pager).adapter = sectionsPagerAdapter
//        assertNotNull(sectionsPagerAdapter)
//        assertEquals(2, sectionsPagerAdapter.count)
//
//        val fragment = sectionsPagerAdapter.getItem(0)
//        assertNotNull(fragment)

//        val recyclerView = fragment.view?.findViewById<RecyclerView>(R.id.recycleMovie)
//        assertNotNull(recyclerView)
//        recyclerView?.measure(0, 0)
//        recyclerView?.layout(0, 0, 100, 10000)
//        recyclerView?.getChildAt(0)?.performClick()
//
//        assertThat(
//            shadowOf(shadowOf(activity).nextStartedActivity).intentClass.name,
//            equalTo(DetailActivity::class.java.name)
//        )
    }
}
