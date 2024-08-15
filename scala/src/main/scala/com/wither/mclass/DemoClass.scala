package com.wither.mclass



class DemoClass(var name:String, var age:Int) {  //var自动生成getter和setter,val自动生成getter
  override def toString: String = "名字：" + name + ", 年龄：" + age

  def foo = name
  def foo_ = name + " good"
}


