package com.example.yeonchulapp

// 1. Lamda
// 람다식은 우리가 마치 value 처럼 다룰 수 있는 익명함수이다.
// 1) 메소드의 파라미터로 넘겨줄수가 있다.
// fun maxBy( a: Int)
// 2) return 값으로 사용할 수 있다.

// 람다의 기본정의
// val( or var)  lamdaName : Type ={argumentList -> codeBody}

val square : (Int) ->(Int) = { number: Int-> number*number}

val nameAge : (String, Int) -> (String) = {name: String, age : Int -> "my name is ${name} I'm ${age} years old"}
fun main(){
    println(square(12))
    println(nameAge("kimyeonchul",24))
    val a = "kim said "
    val b = "yeon said "
    println(a.pizzaisGreat())
    println(b.pizzaisGreat())
    println(extendString("kim",24))
    println(calculateGrade(97))

    val lamda : (Double) -> Boolean = {number : Double ->
        number ==4.3213
    }

    println(invokeLamda(lamda))
    println(invokeLamda({true}))
    println(invokeLamda({it>3.2}))
    // println( invokeLamda { it >3.22 }) 위랑 같은 식임
    // 마지막 파라미터가 lamda 식일 때 가능
    // it은 하나 들어가는 parameter를 가르킴

}

// 확장함수
val pizzaisGreat : String.() -> String = { this + "pizza is the best!"}

fun extendString(name: String , age: Int): String{
    val introduceMyself : String.(Int) -> String = {"I am ${this} and ${it} years old"}
    return name.introduceMyself(age)
}
// 람다의 return
// 람다는 마지막 한줄이 return 값

val calculateGrade : (Int) -> String ={
    when(it){
        in 0..40 -> "fail"
        in 41..70 -> "pass"
        in 71..100 -> "perfect"
        else -> "Error"
        // else를 안쓰며 안된다. lamda는 무조건 return 타입에 맞게 return을 해야하기 때문에
    }
}

// 람다를 표현하는 2가지 방법 (4가지 중에 2가지)

fun invokeLamda(lamda : (Double) -> Boolean) : Boolean{
    return lamda(5.234)
}

// pojoclass:  틀 역할을 하는 클래스
//