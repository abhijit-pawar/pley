package com.pley.utils

import org.slf4j.LoggerFactory

trait Logging {

  lazy val log = LoggerFactory.getLogger(this.getClass.getName)

  def debug(msg: => Any) {
    if(log.isDebugEnabled())
      log.info(s" ${msg}")
  }

  def debug(msg: => Any, throwable: => Throwable) {
    if (log.isDebugEnabled) log.info(s"${msg}", throwable)
  }

  def info(msg: => Any): Unit = {
    log.info(s"${msg}")
  }
}
