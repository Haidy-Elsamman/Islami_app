package com.example.islami.ui.home.quran.suraDetails

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.islami.R
import com.example.islami.databinding.ActivitySuraDetailsBinding
import com.example.islami.ui.Constants


class SuraDetailsActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: VersesAdapter
    lateinit var binding: ActivitySuraDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySuraDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        initRecyclerView()
        val suraName: String = intent.getStringExtra(Constants.EXTRA_SURA_NAME) as String
        val suraPosition: Int = intent.getIntExtra(Constants.EXTRA_SURA_POSITION, -1)
        binding.titleTextView.text = suraName
        readSuraFile(suraPosition)

    }

    private fun initRecyclerView() {
        recyclerView = findViewById(R.id.recycler_view)
        adapter = VersesAdapter()
        recyclerView.adapter = adapter

    }

    private fun readSuraFile(suraPosition: Int) {
        val fileName = "${suraPosition + 1}.txt"
        val fileContent = assets.open(fileName).bufferedReader().use { it.readText() }
        val verses: List<String> = fileContent.split("\n")
        adapter.changeData(verses)
    }
}


