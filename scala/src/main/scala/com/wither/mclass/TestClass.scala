package com.wither.mclass

object TestClass {
  def main(args: Array[String]): Unit = {
    //    val clazz = new DemoClass("wither", 12)
    //    println(clazz)
    val person = new ConstructorPerson("wither", 18)
    person.setSex("男")
    println(person)
  }

}
