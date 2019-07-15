package example

import scala.annotation.tailrec


object Lists {

  /**
    * This method computes the sum of all elements in the list xs. There are
    * multiple techniques that can be used for implementing this method, and
    * you will learn during the class.
    *
    * For this example assignment you can use the following methods in class
    * `List`:
    *
    *  - `xs.isEmpty: Boolean` returns `true` if the list `xs` is empty
    *  - `xs.head: Int` returns the head element of the list `xs`. If the list
    * is empty an exception is thrown
    *  - `xs.tail: List[Int]` returns the tail of the list `xs`, i.e. the the
    * list `xs` without its `head` element
    *
    * ''Hint:'' instead of writing a `for` or `while` loop, think of a recursive
    * solution.
    *
    * @param xs A list of natural numbers
    * @return The sum of all elements in `xs`
    */
  def sum(xs: List[Int]): Int = {
    xs match {
      case Nil => 0 //return 0 if at end of recursion and unroll the stack
      case head :: tail => head + sum(tail) //we are matching xs with head :: tail head is first ele in list, tail is remaining
      // You should read about pattern matching. Here, if list xs has at least one element,
      // then that element (the head of the list) gets bound to x and the rest (the tail of the list) gets bound to tail.

      //example
      //sum(List(1,5,6)) -> head = 1, tail = List(5,6) -> 1 + sum(List(5,6))
      //1 + 5 + sum(6) -> 1 + 5 + 6 + sum(List()) -> 1 + 5 + 6 + 0 -> 12
      // => 12
    }

  }

  /**
    * This method returns the largest element in a list of integers. If the
    * list `xs` is empty it throws a `java.util.NoSuchElementException`.
    *
    * You can use the same methods of the class `List` as mentioned above.
    *
    * ''Hint:'' Again, think of a recursive solution instead of using looping
    * constructs. You might need to define an auxiliary method.
    *
    * @param xs A list of natural numbers
    * @return The largest element in `xs`
    * @throws java.util.NoSuchElementException if `xs` is an empty list
    */
  def max(xs: List[Int]): Int = {
    //referred to code online for syntax
    //works with and without @tailrec
    def maxAccum(ints: List[Int], curMax: Int): Int = {
      ints match {
        case Nil => curMax //default to 0
        case head :: tail =>
          val newMax = if (head > curMax) head else curMax //if the head element is max, update, else keep old max
          return maxAccum(tail, newMax) //return the tail (rest of the List), with the updated max.
      }
    }

    return maxAccum(xs, 0)

  }



}
