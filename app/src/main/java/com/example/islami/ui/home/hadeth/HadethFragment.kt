package com.example.islami.ui.home.hadeth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.islami.databinding.FragmentHadethBinding

class HadethFragment : Fragment() {
    lateinit var binding: FragmentHadethBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHadethBinding.inflate(inflater, container, false)
        return binding.root
    }

    lateinit var adapter: HadethTitlesAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        readHadethFile();
        adapter = HadethTitlesAdapter(allAhadeth)
        binding.recyclerViewHadeth.adapter = adapter
    }

    //
//    val allHadeth = mutableListOf<Hadeth>()
//
//    fun readHadethFile() {
//
//        val fileContent =
//            activity?.assets?.open("ahadeth.txt")?.bufferedReader().use { it?.readText() }
//        if (fileContent==null) return
//
//        val hadethContents = fileContent.trim().split("#")
//        hadethContents.forEach { singleHadethContent ->
//            val title = singleHadethContent.trim().substringBefore('\n')
//            val content = singleHadethContent.trim().substringAfter('\n')
//            val hadeth = Hadeth(title,content)
//            allHadeth.add(hadeth)
//
//        }
//
//    }
    val allAhadeth = mutableListOf<Hadeth>()
    fun readHadethFile() {
        val fileContent = activity?.assets?.open("ahadeth.txt")?.bufferedReader().use {
            it?.readText()
        }
        if (fileContent == null) return;
        val ahadethContents = fileContent.trim().split("#")
//        for(String singleHadethContent : ahadethContents){
//
//        }
        ahadethContents.forEach { singleHadethContent ->
//            val indexOfFirstLine = singleHadethContent.indexOf('\n')
            //          val title = singleHadethContent.substring(0,indexOfFirstLine)
            val title = singleHadethContent.trim().substringBefore('\n');
            val content = singleHadethContent.trim().substringAfter('\n')
            val hadeth = Hadeth(title, content)
            allAhadeth.add(hadeth)
        }
    }
}
