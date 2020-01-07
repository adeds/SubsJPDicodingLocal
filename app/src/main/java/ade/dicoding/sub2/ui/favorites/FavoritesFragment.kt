package ade.dicoding.sub2.ui.favorites


import ade.dicoding.sub2.R
import ade.dicoding.sub2.util.OnTabCustomSelectedListener
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.widget.TextViewCompat
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_tab.*

class FavoritesFragment : Fragment() {
    private lateinit var pagerAdapter: FragmentFavAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tab, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        pagerAdapter = FragmentFavAdapter(childFragmentManager, context)
        pager_Order.adapter = pagerAdapter
        pager_Order.offscreenPageLimit = pagerAdapter.count
        tab_Order2.setupWithViewPager(pager_Order)
        tab_Order2.addOnTabSelectedListener(OnTabCustomSelectedListener(tab_Order2))
        val tabCount = tab_Order2.tabCount
        for (i in 0 until tabCount) {
            val tab = tab_Order2.getTabAt(i)
            if (tab != null) {
                val tabTextView =
                    LayoutInflater.from(tab_Order2.context).inflate(
                        R.layout.item_tab_text,
                        tab_Order2,
                        false
                    ) as TextView
                tabTextView.text = tab.text
                TextViewCompat.setTextAppearance(
                    tabTextView,
                    if (i == 0) {
                        R.style.TextAppearance_Tabs_Selected
                    } else {
                        R.style.TextAppearance_Tabs
                    }
                )
                tab.customView = tabTextView
            }
        }

    }

    companion object {
        fun newInstance(): Fragment {
            return FavoritesFragment()
        }
    }

}
