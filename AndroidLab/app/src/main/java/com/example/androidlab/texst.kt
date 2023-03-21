package com.example.androidlab

val data: Int by lazy{
    println("in lazy")
    10
}

var result = when(data) {
    in 1..10 -> 10
    else -> 20
}
fun main(){
    print("dfdfd")
    println(data)
    val sum = { num1 : Int, num2: Int -> num1+num2}
    println(sum(10,20))

}

fun someFun(){
    var data1: Int ?= null


}