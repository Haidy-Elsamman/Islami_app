package com.example.islami.ui.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.islami.R
import com.example.islami.databinding.ActivityHomeBinding
import com.example.islami.ui.home.hadeth.HadethFragment
import com.example.islami.ui.home.quran.QuranFragment
import com.example.islami.ui.home.radio.RadioFragment
import com.example.islami.ui.home.tasbeh.TasbehFragment
import com.google.android.material.navigation.NavigationBarView

class HomeActivity : AppCompatActivity() {

    lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()
    }

    private fun initViews() {
        binding.bottomNavigationBar.setOnItemSelectedListener(
            NavigationBarView.OnItemSelectedListener { menuItem ->
                if (menuItem.itemId == R.id.navigation_quran) {
                    pushFragment(QuranFragment())
                } else if (menuItem.itemId == R.id.navigation_hadeth) {
                    pushFragment(HadethFragment())
                } else if (menuItem.itemId == R.id.navigation_sebha) {
                    pushFragment(TasbehFragment())
                } else if (menuItem.itemId == R.id.navigation_radio) {
                    pushFragment(RadioFragment())
                }
                return@OnItemSelectedListener true
            })
        binding.bottomNavigationBar.selectedItemId = R.id.navigation_quran
    }

    private fun pushFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .addToBackStack(null)
            .commit()
    }
}