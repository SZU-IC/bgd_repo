package com.wither.mclass

import scala.beans.BeanProperty

class ConstructorPerson(name:String, age:Int) {
  @BeanProperty   //需要类似Java的getter和setter方法可以在属性加上注解@BeanProperty
  var sex:String = _

  //辅助构造器
  def this(name:String, age:Int,sex:String) = {
    this(name, age)   //第一行需要使用父构造器
    this.sex = sex
  }

  override def toString: String = name + " 年龄："  + age + " 性别： " + getSex

}
