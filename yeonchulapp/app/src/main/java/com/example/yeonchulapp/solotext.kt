package com.example.yeonchulapp

// 혼자하는 테스트라 같은 패키지 안에 있는 파일들의 메소드들과 겹치지 않게 다른 함수명 사용

fun maxBy3 (a: Int, b: Int) :Int = if(a>b) a else b

fun checkNum2(score: Int){
    when(score){
        in 0.. 10 -> println("umm..")
        in 11..60 -> println("soso..")
        in 60..80 -> println("good")
        in 80.. 100 -> println("perfect")
        else -> println("Error")
    }
    var a : Int = when(score){
        in 0..100 -> 0
        else -> 1
    }
    println("var a is ${a}")
}
// Expression vs Statement
// Expression : 값을 만들어 냄. 코틀린의 모든 함수는 Expression 왜냐면 Unit 형도 리턴값이 있는 거니깐
// Statement : 문장을 나타냄

//Array
fun Array2(){
    val array : Array <Int> = Array(10,{0})
    val array2 : Array <String> = arrayOf("1","2","3")
    val array3 = arrayOf(1,2,3)
    val array4 = Array(10,{0})
    //arrayOf는 Array 타입의 객체를 반환
    //Array는 Array 클래스를 사용해서 생성
    val array5 = arrayOf <Int> (1,2,3)  //제네릭
    val array6 = intArrayOf(1,2,3) // 코틀린에서 제공하는 기본 함수

    // 값 넣기
    array.set(0,100)
    array[0] =100
    // 값 참조
    array.get(0)
    array[0]
}
//list
fun list2() {
    // list는 불변형, 읽기 전용, 변경이 불가능
    val list: List<Int> = List<Int>(10, { 0 })
    val list2: List<Int> = listOf(1, 2, 3)
    val list3: List<Any> = listOf(1, 2, "3", 4, 5)

    //mutableList는 읽고 쓰기 가능 대표적인게 바로 ArrayList
    val arrayList: ArrayList<Int> = arrayListOf<Int>()
    arrayList.add(10)
    arrayList[0] = 10

    var arrayList2 = arrayListOf<Int>()
    arrayList2.add(10)
    arrayList2.add(10)
    arrayList2.add(10)
    for (i in 0..arrayList2.size-1 step (1)) {
        println(arrayList2.get(i))
    }
    println(arrayList2.toString())

}
// for /while
fun forAndWhile2(){
    val students : ArrayList <String> = arrayListOf<String>()
    students.add("kim")
    students.add("yeon")
    students.add("chul")

    for(name : String in students){
        println(name)
        println("${name}")
    }
    var sum1 = 0
    var sum2 : Int =0 //똑같애

    for(i : Int in 1.. 10 step 1){
        println("${i}")
    }
    for(i : Int in 10 downTo 1){
        println("${i}")
    }
    var index = 0
    for((index,name) in students.withIndex()){

    }
}

// Nullable / NonNull

fun nullCheck2(){
    // NPE : Null Pointer Exception
    // 자바는 Null Pointer Exception이 Run Time 즉 터미널에서 실행시켜야만
    // 알 수 있다
    // 하지만 코틀린은 컴파일 시점에서 잡아줄게 하고 나온 것이 바로 ? (물음표)
    // NPE를 현저히 낮춘다

    var name = " Kim" // var name : String = "Kim"
    var nullName : String? = null  // nullable type , null값을 넣을 수 있음
    var nameinUpperCase : String = name.uppercase()
    var nullNameinUppercase : String? = nullName?.uppercase()
    println(nameinUpperCase)
    println(nullNameinUppercase)
    // null 이면 null 반환하고 null 아니면 ?. 이후의 동작 수행
    // 여기선ㄴ uppercase() 수행

    var lastName : String? = null
    val fullName : String = name + " "+ (lastName?:"No middle Name")
    println(fullName)
    // !!
    // null 타입이 확실히 아니다 라고 컴파일러에게 알려줌
    // 정말 확실히 null 이 아닐때만 사용

}

// class
// file 이름과 class 이름이 달라도 되고 여러 class도 한 파일안에 넣을 수 있다
// 하지만 맞춰서 사용하는 것을 권장
class Person(var name: String ="kimyeonchul", var age :Int = 20)
open class Human2 (val name: String = "Annoys"){
    constructor(name: String, age: Int): this(name){
        println("my name is ${name} I'm ${age} years old")
    }
    init{
        println("born!")
    }
    fun eating(){
        println("delicious")
    }
    open fun singing(){
        println("lalala")
    }
}
class Korean2 : Human2() {
    override fun singing(){
        println("라라라")
    }
}

// Lamda
// Lamda 식은 우리가 마치 value 처럼 다룰 수 있는 익명함수
// val greating: () -> Unit  = {println("Hello")}
// 원래 함수의 형식
// fun 함수이름 (매개변수) {함수내용}
// ex) fun test(){println("")}
// 람다는 fun과 함수이름을 명시하지 않고 축약형으로 선언
// {매개변수 -> 함수내용}
// 람다는 항상 {}로 감싸서 표현
// {} 안에 -> 표시가 있으며 왼쪽은 매개변수, 오른쪽은 함수 내용
// 매개변수 타입을 선언해야 하며 추론할 수 있을 때는 생략가능
// 함수의 반환값은 함수 내용의 마지막 표현식
// 람다는 변수에 함수를 람다함수를 대입가능하게 해준다.
// 람다 함수 바로 호출하는 방법
// {println("Hello")}()
// run{println("Hello")}
// 메소드의 파라미터로 넘겨줄 수도 있음
// ex) fun maxBy(x : Int, y: Int -> if x>y x else y}
// return 값으로 사용 가능
// 람다의 기본 정의 형식
// var( or val) LamdaFunName : Type = {매개변수 -> 함수내용}

val mul : (Int,Int)->(Int) = {x: Int, y: Int -> x*y}
val nameAndAge : (String, Int) -> String = {name:String, age: Int ->
    "Hellow My Name is ${name} I'm ${age} years old"}

// 확장함수
// 기존 클래스는 그대로 두고 클래스 주변에 새로운 함수나 프로퍼티를 추가해서
// 클래스의 크기를 확장
// 확장함수를 추가할 클래스에 .(점) 연산자를 통해 추가해주면 된다.
// this를 통해 추가하려는 클래스의 public 인스턴스에 접근이 가능
fun MutableList<Int>.swap(index1: Int, index2 : Int){
    val tmp = this[index1]
    this[index1] = this[index2]
    this[index2]=tmp
}
// 람다를 사용해서 확장함수 만들기
val kycJJang : String.() -> String = {this + " said kim yeon chul JJang"}

fun extendString2(name : String, age : Int) : String{
    val introduceMyself : String.(Int) -> String = {"I'm ${this} and ${it} years old"}
    return name.introduceMyself(age)
    // it은 하나 들어가는 파라미터를 가르킴
    // String.(Int) 형태로 받고 String 으로 return 하는 확장함수 (.(점)사용) 만듦
    // extendString2 라는 함수 자체도 String return 이니깐 return 값으로 name: String 에 age라는 int
    // 값 파라미터를 전달해서 inroduceMyself 람다 함수를 호출하고 리턴
}

val calculateGrade2 : (Int) -> String = {
    //람다식
    when(it){
        in 0..40 -> "no.."
        in 41..100->"good"
        else -> "Error"
    }
}
fun invokeLamda1(lamda:(Double) -> (Boolean)) : Boolean {
    return lamda(5.2354)
}
data class SMUperson(val name: String, val stunum: String, val timetable : String, val age: Int)
// data class
// 기본 생성자에는 한개 이상의 파라미터
// 기본 생성자의 파라미터의 타입은 val var  둘중 하나
// 데이터 클래스는 open, abstract, sealed. inner 일 수 없다
// Canonical Methods
// Any에 선언된 메소드
// Any는 자바의 object처럼 모든 객체의 조상이 되는 객체
// 코틀린의 모든 인스턴스가 갖고 있는 메소드
// 따라서 equals, toString, hashCode 메소드들을 갖고있다

//Companion Methods
// private constructor 는 다른 곳에서 생성을 못하게 만듦

class Book1 private constructor(val id: Int, val name : String){

    companion object{
        fun create()= Book1(0,"tree")
    }
}
fun main(){
    val name : String = "kim"
    val lastname: String = "yeonchul"
    val age : Int = 24
    println("My Name is ${name + lastname} I'm ${age} years old")

    println("maxby ${maxBy3(2,3)}")
    checkNum2(101)
    list2()
    forAndWhile2()
    nullCheck2()

    val mom = Korean2()
    mom.singing()

    val kimyeonchul = Human2("kimyeonchul",25)
    kimyeonchul.singing()
    var person = Person("kim")
    var person2 = Person("kim",24)
    var person3 = Person()

    println(person.name)
    println(person2.name)
    println(person3.name)

    println(mul(4,3))
    println(nameAndAge("kim",24))
    val a =" Kim"
    val b = "Yeon"
    println(a.kycJJang())
    println(b.kycJJang())
    println(extendString2("Kim",24))
    println(extendString2("yeon",26))

    println(calculateGrade2(101))

    val lamda : (Double) ->(Boolean) = { number: Double ->
        number == 4.3213
    }

    println(invokeLamda1(lamda))
    println(invokeLamda1 { true })
    println(invokeLamda { it>5.3 })
    // println(invokeLamda(){it>5.3}
    // println(invokeLamda({it>5.3})


}

