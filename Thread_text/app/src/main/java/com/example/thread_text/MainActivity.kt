package com.example.thread_text

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.thread_text.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val handler = Handler(Looper.getMainLooper())

        val imagelist = arrayListOf<Int>()
        imagelist.add(R.drawable.mv_celebrity)
        imagelist.add(R.drawable.mv_coin_tizer)
        imagelist.add(R.drawable.mv_epilogue)
        imagelist.add(R.drawable.mv_celebrity)
        imagelist.add(R.drawable.mv_coin_tizer)
        imagelist.add(R.drawable.mv_epilogue)
        imagelist.add(R.drawable.mv_celebrity)
        imagelist.add(R.drawable.mv_coin_tizer)
        imagelist.add(R.drawable.mv_epilogue)

        Thread{
            for(image in imagelist){
                runOnUiThread {
                    binding.iv.setImageResource(image)
                }
                Thread.sleep(2000)

            }
        }.start()
    }


}