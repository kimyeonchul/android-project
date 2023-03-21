package com.example.yeonchulapp

//object class
// Singleton Parttern
// 딱 한 번만 객체 생성, 다시는 객체 생성 하지 않음

object CarFactory{
    val cars = mutableListOf<Car>()
    fun makeCar(horsePower: Int) : Car{
        val car = Car(horsePower)
        cars.add(car)
        return car
    }
}

data class Car(val horsePower : Int)


fun main(){
    val car = CarFactory.makeCar(10)
    val car2 = CarFactory.makeCar(200)

    println(CarFactory.cars.size.toString())

    println(car)
    println(car2)

}