package com.pley.utils

import com.fasterxml.jackson.databind.{DeserializationFeature, ObjectMapper}
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import scala.reflect.ClassTag
import scala.reflect._


object JsonUtil {

  val mapper = new ObjectMapper()
  mapper.registerModule(DefaultScalaModule)

  def toJson(value: Map[Symbol,Any]): String = {
    toJson(value map { case (k,v) => k.name -> v})
  }

  def toJson(value: Any): String = {
    mapper.writeValueAsString(value)
  }

  def fromJson[T: ClassTag](json: String): T = {
    mapper.readValue[T](json, classTag[T].runtimeClass.asInstanceOf[Class[T]])
  }

  def toMap[V](json:String)(implicit m: Manifest[V]) = fromJson[Map[String,V]](json)

}
