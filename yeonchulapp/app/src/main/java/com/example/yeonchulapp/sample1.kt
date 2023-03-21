package com.example.yeonchulapp

fun main(){
    helloworld()
    println(add(4,5))
    checkNum(1)
    //3. String Template

    val name ="Kim"
    val last_name = "YeonChul"
    println("my name is ${name+ last_name} I'm 24")
    // 띄어쓰기 주의해야 되므로 ("my name is ${name}I'm 25") 이렇게 하는 게 나아요
    forAndWhile()
    nullcheck()
    ignreNulls("kim")

}
//1. function

fun helloworld() {
    println("hello world")
}

fun add (a:Int, b:Int) : Int{
    return a+b
}

//2. val vs var
// val  =value

fun hi(){
    val a : Int = 10

    var b : Int = 0
    // var b = 0 이렇게써도 된다
    // var a = 10 이렇게써도 된다
    // 바로 초기화 안할거면 자료형을 정의해줘야 해
    var e :String
    var name = "Kim"

    b=100
    println(b)
}

//4. 조건식

fun maxBy(a : Int, b: Int) : Int{
    if(a>b){
        return a
    }else{
        return b
    }
}

fun maxBy2(a : Int , b: Int): Int = if(a>b) a else b

fun checkNum( score : Int){
    when(score){
        0 -> println("this is zero")
        1 -> println("this is one")
        2,3 -> println("this is two or three")
        else -> println("i don't know")
    }

    var b : Int = when(score){
        1 -> 1
        2 -> 2
        else -> 3

    }
    println("b : ${b}")
    when(score){
        in 90..100 -> println("you are Genius")
        in 10..80 -> println(" not bad")
        else -> println("okay")

    }
}

// Expression vs Statement
// Expression : 값을 만들어 낸다, 코틀린의 모든 함수는 Expression : 왜냐면 리턴값이 없어보여도 Unit라는 리턴값이 있다
// Statement : 문장을 나타낸다

// 5. Array & List
// Array
// List 1. List 2. MutableList
// List는 읽기 전용 , 변경이 불가능
// MutableList는 읽고 쓰기 가능 대표적인게 바로 ArrayList
fun Array(){
    val array : Array<Int>  = arrayOf(1,2,3)
    val list : List<Int> = listOf(1,2,3)

    val array2 : Array<String> = arrayOf("Kim","yeon","chul")
    val list2 : List<Any> = listOf(1,2,"3",3.5)

    array[0]=3
    var result = list.get(0)

    val arrayList : ArrayList<Int> = arrayListOf<Int>()
    arrayList.add(10)
    arrayList[0]=10
}
//6. for / while

fun forAndWhile(){
    val students : ArrayList<String> = arrayListOf("kim","yeon","chul")
    for(name:String in students){
        println("${name}")
    }
    var sum1 : Int = 0
    var sum2 : Int = 0
    for( i: Int in 1..10 step 2){
        sum1+=i
    }
    for( i: Int in 10 downTo 1){
        sum2+=i
    }
    // in 1 until 100 : 1~99
    println(sum1)
    println(sum2)

    var index =0
    while(index <10){
        println("current index = ${index}")
        index++
    }

    for((index,name) in students.withIndex()){
        println("${index+1}번쨰 학생: ${name}")
    }

}

// 7. Nullable / NonNull

fun nullcheck(){
    //NPE : Null pointer Exception
    //자바는 null pointer exception이 run time 즉 터미널에서 실행시켜야만 알 수 있었다
    //하지만 코틀린은 컴파일 시점에서 잡아줄게 하고 나온게 물음표

    var name = "kim"
    var nullName : String? = null    //nullable type이 된거임
    var nameInUpperCase : String = name.toUpperCase()
    var nullNameInUpperCase : String? =nullName?.toUpperCase()

    // ?:

    val lastName : String? =null
    val fullName: String = name+" "+(lastName?:"No lastName")
    println(fullName)

    //!!
    //null 타입이 아니라고 컴파일러에게 알려줌
    // 확실하게 null이 아닐떄만 사용해야 한다
    // ? 나 ?: 연산자를 많이 사용해라라
}
fun ignreNulls(str : String?){
    val mNoNull : String = str!!
    val upper = mNoNull.toUpperCase()

    val email : String? = "yeonchul0807@nate.com"
    email?.let {
        println("my email is ${email}")
    }
}