package com.example.xdapp.ui.notes

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.viewpager.widget.ViewPager
import com.example.xdapp.R
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.fragment_notes.*


class NotesFragment : Fragment() {

    private lateinit var notesViewModel: NotesViewModel
    private lateinit var viewPager:ViewPager
    private lateinit var tableLayout :TabLayout
    private lateinit var viewDivider:View



    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
            notesViewModel = ViewModelProviders.of(this).get(NotesViewModel::class.java)
         val root = inflater.inflate(com.example.xdapp.R.layout.fragment_notes, container, false)
        viewPager = root.findViewById(R.id.pager)
        tableLayout = root.findViewById(R.id.tab)
        viewDivider = root.findViewById(R.id.view_divider)

        val notespagerAdapter = NotespagerAdapter(childFragmentManager)
        viewPager.adapter =notespagerAdapter
        tableLayout.setupWithViewPager(viewPager)

        updateTabTextColors()
        tableLayout.addOnTabSelectedListener(object:TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                if (tab != null){
                    when (tab.position) {
                        0 -> viewDivider.setBackgroundColor(Color.BLUE)
                        1 -> viewDivider.setBackgroundColor(Color.CYAN)
                        2 -> viewDivider.setBackgroundColor(Color.RED)
                        3 -> viewDivider.setBackgroundColor(Color.YELLOW)
                        4 -> viewDivider.setBackgroundColor(Color.GREEN)
                    }
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }
        })
        return root
    }

    private fun updateTabTextColors() {
        val tabsContainer = tableLayout.getChildAt(0) as LinearLayout
        for (i in 0 until tableLayout.tabCount) {
            val item = tabsContainer.getChildAt(i) as LinearLayout
            when (i) {
                0 -> item.setBackgroundColor(Color.BLUE)
                1 -> item.setBackgroundColor(Color.CYAN)
                2 -> item.setBackgroundColor(Color.RED)
                3 -> item.setBackgroundColor(Color.YELLOW)
                4 -> item.setBackgroundColor(Color.GREEN)
            }
        }
    }



}
