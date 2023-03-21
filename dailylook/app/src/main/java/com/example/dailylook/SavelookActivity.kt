package com.example.dailylook

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dailylook.databinding.ActivitySavelookBinding

class SavelookActivity : AppCompatActivity() {
    lateinit var binding : ActivitySavelookBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySavelookBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}