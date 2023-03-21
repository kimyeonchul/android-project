package com.example.yeonchulapp

// 자바의 static 대신 사용
// 정적


class Book private constructor(val id : Int, val name: String){
    //다른 곳에서는 객체 생성이 불가능
    companion object BookFactory : IdProvider{
        val myBook = "new Book"
        fun create() = Book(getId(),myBook)
        override fun getId() : Int{
            return 444
        }

    }
}

interface IdProvider{
    fun getId() : Int
}
// companion 생략가능 밑에 저거 회색
// companion object : private 필드(property)나 메소드를 읽어올 수 있게끔 해줌
fun main(){
    val book = Book.create()
    val bookId = Book.BookFactory.getId()
    println("${book.id} ${book.name}")
    println("${bookId}")
}