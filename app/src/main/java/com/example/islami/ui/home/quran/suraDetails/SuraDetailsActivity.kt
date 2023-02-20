package com.example.islami.ui.home.quran.suraDetails

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.islami.R
import com.example.islami.databinding.ActivitySuraDetailsBinding
import com.example.islami.ui.Constants


class SuraDetailsActivity : AppCompatActivity() {

    lateinit var binding: ActivitySuraDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySuraDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        actionBar?.setDisplayHomeAsUpEnabled(true)
        setSupportActionBar(findViewById(R.id.toolbar))
        val suraName: String = intent.getStringExtra(Constants.EXTRA_SURA_NAME) as String
        val suraPosition: Int = intent.getIntExtra(Constants.EXTRA_SURA_POSITION, -1)
        binding.titleTextView.text = suraName
    }
}


