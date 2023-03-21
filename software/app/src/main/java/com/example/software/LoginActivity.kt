package com.example.software

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.software.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity(){

    lateinit var binding : ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.loginBtn.setOnClickListener {
            //login 시 동작
        }
        binding.signupBtn.setOnClickListener {

        }
        binding.findidBtn.setOnClickListener {

        }
        binding.findpwBtn.setOnClickListener {

        }
    }
}