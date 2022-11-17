package singleresponsibility

/**
 * Created by abdhesh on 7/5/15.
 */

/**
 * To enable the behaviour of an operations to be extended rather than replaced.
 */

abstract class IntQueue {
  def get(): Int

  def put(x: Int)
}

import scala.collection.mutable.ArrayBuffer

class BasicIntQueue extends IntQueue {
  private val buff = new ArrayBuffer[Int]()

  override def get(): Int = buff.remove(0)

  override def put(x: Int) = buff += x
}

/**
 * When you call a method on a class with mixins, the method in
 * the trait furthest to the right is called first. If that method
 * calls super,it invokes the method in the next trait to its left, and so on.
 */
trait Doubling extends IntQueue {
  //Since super calls in a trait are dynamically bound, the super call in trait Doubling will work so long as the trait is mixed in after another trait or class that gives a concrete definition to the method.
  abstract override def put(x: Int) = super.put(x * 2)
}

trait Incrementing extends IntQueue {
  abstract override def put(x: Int) = super.put(x + 1)
}

trait Filtering extends IntQueue {
  abstract override def put(x: Int) =
    if (x >= 0) super.put(x)


}

object SingleResponsibility extends App {

  class MyQueue extends BasicIntQueue with Doubling

  val myQueue = new MyQueue
  myQueue.put(10)
  println(myQueue.get())

}


object StackableTraitsTest extends App {
  val queue = new BasicIntQueue with Incrementing with Doubling //Functions are stacked so it will double and increment
  queue.put(10)
  println(queue.get)
}