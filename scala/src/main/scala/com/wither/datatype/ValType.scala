package com.wither.datatype

object ValType {
  def main(args: Array[String]): Unit = {
    //Int
    //    val a:Int = 11
    //    var b:Int = 12
    //    b = a
    //    println(a, b)
    //
    //    //Byte
    //    val byte: Byte = a.toByte
    //    println(byte)
    //
    //    //Short
    //    println(a.toShort)
    //
    //    //Char
    //    val c = 'a'
    //    println(c.toChar)
    //
    //    val toInt = c.toInt
    //    println(toInt)
    //
    //    println(a.toChar)

    //   val lt = 1 to 5    // [1,2,3,4,5]
    //    lt.foreach(println(_))
    //
    //    val rt = 1 until 5  //[1,2,3,4)
    //    for (elem <- rt) {
    //      println(elem)
    //    }
//    val range = Range(1, 5, 1)
//    for (elem <- range) {
//      println(elem)
//    }

    def getName = {
      ("hello", "wither", "as")
    }

    def use = {
      val (name, say, flag) = getName
      println(name, say, flag)
    }

    use
  }

}
