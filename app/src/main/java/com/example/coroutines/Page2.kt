package com.example.coroutines

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import com.example.coroutines.databinding.FragmentPage2Binding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class Page2 : Fragment() {
    private var binding:FragmentPage2Binding? = null
    private val args: Page2Args by navArgs()
    private var count:Int = 0
    set(value) {
        lifecycleScope.launch(Dispatchers.Default) {
            if (value >= 0 && value <= args.max) {
                field = value
                withContext(Dispatchers.Main) {
                    binding?.run {
                        button3.visibility = if (field == 0 || field == args.max) View.VISIBLE else View.INVISIBLE
                        textView.text = field.toString()
                    }
                }
            }
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return FragmentPage2Binding.inflate(inflater, container, false).apply {
            binding = this
            button1.setOnClickListener {
                count++
            }
            button2.setOnClickListener {
                count--
            }
            button3.setOnClickListener {
                count = args.count
            }
            count = args.count
        }.root
    }
}