package com.example.yeonchulapp


// file 이름과 class 이름이 달라도 되고
// 여러 class도 한 파일 안에 넣을 수 있다.
// 하지만 난 맞춰서 사용

open class Human (val name : String = "Annoys"){

    constructor(name : String , age: Int) : this(name){
        println("my name is ${name}, ${age} years olds")
    }   // 부 생성자 이기 때문에 얘가 다음 실행
    init{
        println("new Human has been born!!")
    }   // 주 생성자 이기 때문에 얘먼저 실행
    fun eating(){
        println("this is so yummy")
    }
    open fun singAsong(){
        println("lala")
    }
}

class Korean : Human(){
    override fun singAsong(){
        super.singAsong()
        println("라라ㅏ라")
        println("my name is :${name}")
    }
}



fun main(){
//    val human = Human("kim")
//
//    val stranger  = Human()
//    human.eating()

    val mom = Human("guri",52)
//    println("this human name is ${human.name} ")
//    println("this human name is ${stranger.name} ")
    val korean = Korean()
    korean.singAsong()
}