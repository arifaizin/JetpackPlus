package com.arif.jetpackpro.activity

import androidx.fragment.app.FragmentManager
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.nhaarman.mockitokotlin2.any
import org.mockito.Mockito.doAnswer
import org.mockito.Mockito.spy
import org.mockito.internal.util.reflection.Fields
import org.robolectric.annotation.Implementation
import org.robolectric.annotation.Implements
import org.robolectric.annotation.RealObject
import org.robolectric.shadow.api.Shadow.directlyOn
import org.robolectric.shadows.ShadowViewGroup


@Implements(ViewPager::class)
class ShadowViewPager : ShadowViewGroup() {

    @RealObject
    internal var realViewPager: ViewPager? = null

    @Implementation
    fun setAdapter(adapter: PagerAdapter) {
        directlyOn(realViewPager, ViewPager::class.java).setAdapter(addWorkaround(adapter))
    }

    private fun addWorkaround(adapter: PagerAdapter): PagerAdapter? {
        val spied = spy(adapter)
        val fragmentManager = getFragmentManagerFromAdapter(spied)
        doAnswer { invocation ->
            if (fragmentManager!!.getFragments().isEmpty())
                invocation.callRealMethod()
            null
        }.`when`<PagerAdapter>(spied).finishUpdate(any())
        return spied
    }

    private fun getFragmentManagerFromAdapter(adapter: PagerAdapter): FragmentManager? {
        for (instanceField in Fields.allDeclaredFieldsOf(adapter).instanceFields()) {
            val obj = instanceField.read()
            if (obj is FragmentManager) {
                return obj
            }
        }
        return null
    }


}