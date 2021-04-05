package com.example.coroutines

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.coroutines.databinding.FragmentPage2Binding

class Page2 : Fragment() {
    private val args: Page2Args by navArgs()
    private var count = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentPage2Binding.inflate(inflater, container, false)
        count = args.count
        binding.textView.text = count.toString()


        binding.button1.setOnClickListener {

        }
        binding.button2.setOnClickListener {

        }
        binding.button3.setOnClickListener {

        }


        return binding.root
    }
}