package com.example.software

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.software.databinding.ActivitySignupBinding

class SignUpActivity : AppCompatActivity(){

    val TAG: String = "Register"
    lateinit var binding : ActivitySignupBinding
    lateinit var db: ProfileDatabase
    lateinit var sex : String
    var isExistBlank = false
    var isPWSame = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = ProfileDatabase.getInstance(this)!!    // db를 받아온다
        binding.signupSignupBtn.setOnClickListener {
            var id = binding.signupIdEt.text.toString()
            var password = binding.signupPwEt.text.toString()
            var repassword = binding.signupRepwEt.text.toString()
            var name = binding.signupNameEt.text.toString()
            var birthdate = binding.signupYearSpinner.selectedItem.toString()+binding.signupMonthSpinner.selectedItem.toString()+binding.signupDateSpinner.selectedItem.toString()
            var sex = this.sex

            if(id.isEmpty()||password.isEmpty()||repassword.isEmpty()||name.isEmpty()||birthdate.isEmpty()||sex.isEmpty()){
                isExistBlank = true
            }
            else{
                if(password==repassword)
                    isPWSame= true
            }
            if(!isExistBlank && isPWSame) {
                Thread{
                    db.profileDao().insert(Profile(id,password,name,birthdate,sex))
                }.start()
                // 회원가입 성공 토스트 메세지 띄우기
                Toast.makeText(this, "회원가입 성공", Toast.LENGTH_SHORT).show()

                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
            else{
                if(isExistBlank){   // 작성 안한 항목이 있을 경우
                    dialog("blank")
                }
                else if(!isPWSame){ // 입력한 비밀번호가 다를 경우
                    dialog("not same")
                }
            }
        }


        binding.signupSexRg.setOnCheckedChangeListener{
            group,checkedId ->
            when(checkedId){
                /*binding.signupSexManBtn -> sex = "men"
                binding.signupSexWomanBtn -> sex = "woman"*/
            }
        }


        val yearlist = resources.getStringArray(R.array.year_spinner)
        val monthlist = resources.getStringArray(R.array.month_spinner)
        val datelist = resources.getStringArray(R.array.date_spinner)

        val yearadapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, yearlist)
        val monthadapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, monthlist)
        val dateadapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, datelist)

        binding.signupYearSpinner.adapter = yearadapter
        binding.signupMonthSpinner.adapter = monthadapter
        binding.signupDateSpinner.adapter = dateadapter
    }

    fun dialog(type: String){
        val dialog = AlertDialog.Builder(this)

        // 작성 안한 항목이 있을 경우
        if(type.equals("blank")){
            dialog.setTitle("회원가입 실패")
            dialog.setMessage("입력란을 모두 작성해주세요")
        }
        // 입력한 비밀번호가 다를 경우
        else if(type.equals("not same")){
            dialog.setTitle("회원가입 실패")
            dialog.setMessage("비밀번호가 다릅니다")
        }

        val dialog_listener = object: DialogInterface.OnClickListener{
            override fun onClick(dialog: DialogInterface?, which: Int) {
                when(which){
                    DialogInterface.BUTTON_POSITIVE ->
                        Log.d(TAG, "다이얼로그")
                }
            }
        }

        dialog.setPositiveButton("확인",dialog_listener)
        dialog.show()
    }





 }

