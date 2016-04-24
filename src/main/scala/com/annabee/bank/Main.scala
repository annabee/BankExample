package com.annabee.bank

import com.typesafe.scalalogging.LazyLogging
import scala.io.Source

object Main extends LazyLogging {

  val welcomeScreen = Source.fromInputStream(this.getClass.getResourceAsStream("/welcome-banner.txt")).mkString

  def main(args: Array[String]) {

    logger.info(welcomeScreen)
  }
}
