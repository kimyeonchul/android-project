package com.example.yeonchulapp

data class Ticket(val companyName : String, val name: String, var data: String, var sitNumer: Int)
// toString(), hashCode(), equals(), copy() 가 자동으로 만들어짐 ==pojoclass

class TicketNormal(val companyName : String, val name: String, var data: String, var sitNumer: Int)

fun main(){
    val ticketA = Ticket("koreanAir","kim","20200216",14)
    val ticketB = TicketNormal("koreanAir","kim","20200216",14)

    println(ticketA)
    println(ticketB)
}