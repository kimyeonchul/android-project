package com.example.dailylook

import ViewPagerAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.example.dailylook.databinding.ActivityCombinationListBinding


class CombinationListActivity : AppCompatActivity() {
    lateinit var binding: ActivityCombinationListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCombinationListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //viewpager1
        binding.viewPagerIdol.adapter = ViewPagerAdapter(getIdolList())
        binding.viewPagerIdol.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        //viewpager2
        binding.viewPagerIdol2.adapter = ViewPagerAdapter(getIdolList())
        binding.viewPagerIdol2.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        //viewpager3
        binding.viewPagerIdol3.adapter = ViewPagerAdapter(getIdolList())
        binding.viewPagerIdol3.orientation = ViewPager2.ORIENTATION_HORIZONTAL
    }
        private fun getIdolList(): ArrayList<Int> {
            return arrayListOf<Int>(R.drawable.jean1, R.drawable.shoes1, R.drawable.levis)
        }

}
