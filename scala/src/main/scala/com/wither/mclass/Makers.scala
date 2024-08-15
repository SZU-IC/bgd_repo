package com.wither.mclass

class Makers(color:String) {
  override def toString: String = "color is: " + color
}

object MarkerFactory{
  private val makers = Map(
    "red" -> new Makers("red"),
    "black" -> new Makers("black"),
    "green" -> new Makers("green")
  )

  def getMarker(color:String): Makers = {
    if (makers.contains(color)) makers(color) else null
  }

  def main(args: Array[String]): Unit = {
    println(MarkerFactory getMarker "red")
    println(MarkerFactory getMarker "black")
    println(MarkerFactory getMarker "ff")
  }
}
