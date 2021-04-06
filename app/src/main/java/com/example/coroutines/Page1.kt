package com.example.coroutines

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.NavHostFragment
import com.example.coroutines.databinding.FragmentPage1Binding

class Page1 : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentPage1Binding.inflate(inflater, container, false)

        binding.btn.setOnClickListener {

            if(!binding.editText.text.isNullOrEmpty() && !binding.editText2.text.isNullOrEmpty()) {
                val count = binding.editText.text.toString().toInt()
                val max = binding.editText2.text.toString().toInt()
                if (max > 0 && count in 0..max) {
                    val action = Page1Directions.actionPage1ToPage2()
                    action.count = count
                    action.max = max
                    NavHostFragment.findNavController(this).navigate(action)
                }
            }
        }

        return binding.root
    }


}