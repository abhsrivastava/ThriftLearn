package com.abhi

/**
  * Created by ASrivastava on 8/6/17.
  */

import com.twitter.app.{App, Flaggable}

object FinagleTest extends App {
   val port = flag[Int]("port", 8080, "this is the port of the server. default 8080")

   implicit val flaggableEnv = new Flaggable[Env] {
      override def parse(s: String): Env = s.toLowerCase match{
         case "prod" => Prod
         case "qa" => QA
         case "dev" => Dev
         case _ => Dev
      }
   }

   val env = flag[Env]("env", Dev, "the environment for the service")
   override def failfastOnFlagsNotParsed: Boolean = true

   def main() = {
      println(s"Hello World ${port()} ${env()}")
   }
}

sealed trait Env
case object Prod extends Env
case object QA extends Env
case object Dev extends Env
