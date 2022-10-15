package com.example.coruotineexercise

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.coruotineexercise.databinding.FragmentFirstBinding
import kotlinx.coroutines.*

class FirstFragment : Fragment() {
    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!
    private val TAG = "FirstFragment"
    private var count = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btn.setOnClickListener {

            runBlocking {
                delaySum()
                incrementNumber()
            }

        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
    }

    suspend fun delaySum() {
        delay(2000)
    }

    fun incrementNumber (){
        val value = binding.etNumber.text.toString()
        val value2 = value.toInt()
        val tvValue = value2 + 1 + count
        count++
        Log.v(TAG, "$tvValue")
        binding.tvNumber.text = tvValue.toString()
    }

}