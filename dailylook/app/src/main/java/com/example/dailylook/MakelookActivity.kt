package com.example.dailylook

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dailylook.databinding.ActivityMakelookBinding

class MakelookActivity : AppCompatActivity() {

    lateinit var binding : ActivityMakelookBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMakelookBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}