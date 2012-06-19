package com.github.zhongl.yascli

/**
 * @author <a href="mailto:zhong.lunfu@gmail.com">zhongl<a>
 */

trait Loggable {self: {def out: PrintOut} =>
  private val CR = System.getProperty("line.separator")

  def info(s: Any) { println("INFO : " + s) }

  def warn(s: Any) { println("WARN : " + s) }

  def error(s: Any) { println("ERROR: " + s) }

  def print(a: Any) { out.print(a.toString) }

  def println() { print(CR) }

  def println(a: Any) { print(a.toString + CR) }

}
