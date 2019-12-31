package ade.dicoding.sub2.ui

import ade.dicoding.sub2.R
import ade.dicoding.sub2.ui.movies.MovieFragment
import ade.dicoding.sub2.ui.tvshow.TvFragment
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private val SELECTED_MENU = "selected_menu"
    lateinit var navView: BottomNavigationView
    private val mOnNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item: MenuItem ->
            var fragment: Fragment? = null
            if (item.itemId == R.id.action_movie) {
                fragment = MovieFragment.newInstance()
            } else if (item.itemId == R.id.action_tv) {
                fragment = TvFragment.newInstance()
            }
            if (fragment != null) {
                supportFragmentManager
                    .beginTransaction()
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .replace(R.id.container, fragment)
                    .commit()
            }
            true
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navView = findViewById(R.id.nav_view)
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        savedInstanceState?.getInt(SELECTED_MENU) ?: navView.setSelectedItemId(R.id.action_movie)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(SELECTED_MENU, navView.selectedItemId)
    }
}
