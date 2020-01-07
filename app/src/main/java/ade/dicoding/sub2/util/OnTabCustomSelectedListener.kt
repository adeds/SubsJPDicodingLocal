package ade.dicoding.sub2.util

import ade.dicoding.sub2.R
import android.widget.TextView
import androidx.core.widget.TextViewCompat
import com.google.android.material.tabs.TabLayout

class OnTabCustomSelectedListener(val mTabLayout: TabLayout) :
    TabLayout.OnTabSelectedListener {

    override fun onTabReselected(tab: TabLayout.Tab?) {
    }

    override fun onTabUnselected(tab: TabLayout.Tab?) {
    }

    override fun onTabSelected(selectedTab: TabLayout.Tab?) {
        val tabCount = mTabLayout.tabCount
        for (i in 0 until tabCount) {
            val tab = mTabLayout.getTabAt(i)
            val tabView = if (tab != null) tab.customView else null
            if (tabView is TextView) {
                TextViewCompat.setTextAppearance(
                    tabView,
                    if (selectedTab!!.equals(tab)) {
                        R.style.TextAppearance_Tabs_Selected
                    } else {
                        R.style.TextAppearance_Tabs
                    }
                )
            }
        }
    }

}