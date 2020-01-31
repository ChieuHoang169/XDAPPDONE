package com.example.xdapp
import android.app.SearchManager
import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.xdapp.ui.calendar.CalendarFragment
import com.example.xdapp.ui.calendar.PageTileFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.nightonke.boommenu.BoomButtons.TextOutsideCircleButton
import com.nightonke.boommenu.BoomMenuButton
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),PageTileFragment.FragmentChangeListener {

    private lateinit var navView: BottomNavigationView
    private lateinit var navController1: NavController
    private lateinit var brm :BoomMenuButton
    private var imageResources = intArrayOf(R.drawable.folder,R.drawable.checklist,R.drawable.note,R.drawable.remember)

    private var imageResourceIndex = 0
    fun getImageResource():Int {
        if (imageResourceIndex >= imageResources.size) imageResourceIndex = 0
        return imageResources[imageResourceIndex++]
    }
    override fun onShowBottomNavigation() {
        navView.visibility = View.VISIBLE
    }

    override fun onHideBottomNavigation() {
        navView.visibility = View.GONE
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navView = findViewById(R.id.nav_view)

        val navController = findNavController(R.id.nav_host_fragment)

        val appBarConfiguration = AppBarConfiguration(setOf(
                R.id.navigation_folder,R.id.navigation_notes, R.id.navigation_add, R.id.navigation_todo,R.id.navigation_calendar))
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
         navController1 = Navigation.findNavController(this,R.id.nav_host_fragment)

        NavigationUI.setupActionBarWithNavController(this , navController1)

        brm = findViewById(R.id.boom_menu)
       for (i in 0 until brm.getPiecePlaceEnum().pieceNumber()){
           var builder = TextOutsideCircleButton.Builder().normalImageRes(getImageResource())
           brm.addBuilder(builder)
       }


    }

    override fun onCreateOptionsMenu(menu: Menu):Boolean {
        menuInflater.inflate(R.menu.search, menu)
        val manager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        val searchItem = menu.findItem(R.id.search)
        val searchView = searchItem.actionView as SearchView
        searchView.queryHint = "Search View Hint"
        searchView.setOnQueryTextListener(object :  SearchView.OnQueryTextListener {

            override fun onQueryTextChange(newText: String): Boolean {
                return false
            }

            override fun onQueryTextSubmit(query: String): Boolean {
                searchView.clearFocus()
                searchView.setQuery("",false)
                searchItem.collapseActionView()
                Toast.makeText(this@MainActivity,"Looking $query", Toast.LENGTH_LONG ).show()
                return true
            }

        })

        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(navController1,null)
    }


}
