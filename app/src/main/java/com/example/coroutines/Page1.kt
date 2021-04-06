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
        val fragment = this
        return FragmentPage1Binding.inflate(inflater, container, false).apply {
            btn.setOnClickListener {
                if(!editText.text.isNullOrEmpty() && !editText2.text.isNullOrEmpty()) {
                    val count = editText.text.toString().toInt()
                    val max = editText2.text.toString().toInt()
                    if (max > 0 && count in 0..max) {
                        NavHostFragment.findNavController(fragment).navigate(Page1Directions.actionPage1ToPage2(count,max))
                    }
                }
            }
        }.root
    }


}