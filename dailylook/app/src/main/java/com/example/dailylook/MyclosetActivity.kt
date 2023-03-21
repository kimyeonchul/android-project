package com.example.dailylook

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dailylook.databinding.ActivityMyclosetBinding

class MyclosetActivity : AppCompatActivity() {

    lateinit var binding: ActivityMyclosetBinding
    lateinit var profileAdapter: ProfileAdapter
    val datas = mutableListOf<DataVo>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMyclosetBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecycler()
       /* binding.ibMenu.setOnClickListener{
            val items = arrayOf("룩 조회", "룩 추가", "로그아웃", "회원탈퇴")

            val builder = AlertDialog.Builder(this)
                .setTitle("Select Item")
                .setItems(items) { dialog, which ->
                    if(which == 0) {
                        val intent = Intent(this, CombinationListActivity::class.java)
                        startActivity(intent)
                    }
                    //eles if 로 각 which마다 전환 구현
                }
                .show()
        }*/

    }

    private fun initRecycler() {
        profileAdapter = ProfileAdapter(this)
        binding.rvProfile.adapter = profileAdapter


        datas.apply {
            add(DataVo(img = R.drawable.blackneat, name = "mary", age = 24))
            add(DataVo(img = R.drawable.converse, name = "jenny", age = 26))
            add(DataVo(img = R.drawable.jean1, name = "jhon", age = 27))
            add(DataVo(img = R.drawable.levis, name = "ruby", age = 21))
            add(DataVo(img = R.drawable.slacks, name = "yuna", age = 23))

            profileAdapter.datas = datas
            profileAdapter.notifyDataSetChanged()

        }
    }

    private fun toast(s: String) {
        Toast.makeText(this,s,Toast.LENGTH_SHORT).show()

    }
}