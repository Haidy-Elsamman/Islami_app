package com.example.islami.ui.home.tasbeh

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.islami.databinding.FragmentTasbehBinding
import com.example.islami.ui.Constants

class TasbehFragment : Fragment() {
    lateinit var binding: FragmentTasbehBinding
    var counter: Int = 0
    lateinit var counterTextView: String

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTasbehBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.countTasbeeh.text = "$counter"
        binding.bodyOfSebha.setOnClickListener {
            onSebhaClicked()
        }
    }

    private fun onSebhaClicked() {
        binding.bodyOfSebha.rotation += 5
        counter += 1
        binding.countTasbeeh.text = "$counter"

        if (binding.phases.text == Constants.KHATMEA) {
            binding.phases.text = Constants.SUBHAN_ALLAH
            counter = 0
            binding.countTasbeeh.text = "$counter"
        }
        if (counter == 33) {
            if (binding.phases.text == Constants.SUBHAN_ALLAH) {
                binding.phases.text = Constants.ELHAMDU_ALLAH
                counter = 0
                binding.countTasbeeh.text = "$counter"
            } else if (binding.phases.text == Constants.ELHAMDU_ALLAH) {
                counter = 0
                binding.phases.text = Constants.ALLAH_AKBAR
                binding.countTasbeeh.text = "$counter"
            } else if (binding.phases.text == Constants.ALLAH_AKBAR) {
                counter = 0
                binding.phases.text = Constants.KHATMEA
                binding.countTasbeeh.text = "$counter"
            }
        }
    }
}