package com.example.workouttrainingconstruction

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener

class MainActivity : AppCompatActivity() {
    var tabLayout: TabLayout? = null
    var pager2: ViewPager2? = null
    var adapter: FragmentAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tabLayout = findViewById(R.id.tab_layout)
        pager2 = findViewById(R.id.view_pager2)
        val fm = supportFragmentManager
        adapter = FragmentAdapter(fm, lifecycle)
        pager2!!.setAdapter(adapter)
        tabLayout!!.addTab(tabLayout!!.newTab().setText("Trainings"))
        tabLayout!!.addTab(tabLayout!!.newTab().setText("Exercises"))
        tabLayout!!.addOnTabSelectedListener(object : OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                pager2!!.setCurrentItem(tab.position)
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {}
            override fun onTabReselected(tab: TabLayout.Tab) {}
        })
        pager2!!.registerOnPageChangeCallback(object : OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                tabLayout!!.selectTab(tabLayout!!.getTabAt(position))
            }
        })
    }
}