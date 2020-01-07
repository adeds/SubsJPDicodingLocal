package ade.dicoding.sub2.ui.favorites

import ade.dicoding.sub2.R
import ade.dicoding.sub2.ui.favorites.movie.MovieFavFragment
import ade.dicoding.sub2.ui.favorites.tivshow.TVFavFragment
import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.PagerAdapter

class FragmentFavAdapter(fm: FragmentManager, private val context: Context?) :
    FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        var fragment: Fragment = when (position) {
            1 -> TVFavFragment()
            else -> MovieFavFragment()
        }

        return fragment
    }

    override fun getItemPosition(`object`: Any): Int {
        return PagerAdapter.POSITION_NONE
    }

    override fun getCount(): Int {
        return 2
    }

    override fun getPageTitle(position: Int): CharSequence? {
        var title: String?

        if (position == 1) {
            title = context?.getString(R.string.tv_title)
        } else {
            title = context?.getString(R.string.movie_title)
        }
        return title

    }
}