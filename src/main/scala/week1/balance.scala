package week1

import scala.annotation.tailrec

// Exercise 2: Parentheses Balancing
//
// Write a recursive function which verifies the balancing of parentheses
// in a string, which we represent as a List[Char] not a String.
//
// For example,
// the function should return true for the following strings:
// * (if (zero? x) max (/ 1 x))
// * I told him (that it's not (yet) done). (But he wasn't listening)
//
// The function should return false for the following strings:
// * :-)
// * ())(

def balance(chars: List[Char]): Boolean = {
  @tailrec
  def balanceRec2(charsLi: List[Char], numOpen:Int): Boolean =
    charsLi match {
      case Nil => numOpen == 0
      case x :: xs if x == '(' => balanceRec2(xs, numOpen + 1)
      case x :: _ if x == ')' && numOpen < 1 => false
      case x :: xs if x == ')' => balanceRec2(xs, numOpen-1)
      case _ :: xs => balanceRec2(xs, numOpen)
    }

  balanceRec2(chars, 0)
}

@main def week1_balance(): Unit = {
  val testLi1: List[Char] = List('(', 'b', 'a', ')')
  println(testLi1.toString() + ": " + balance(testLi1))

  val testLi2 = "(if (zero? x) max (/ 1 x))".toList
  println(s"$testLi2: ${balance(testLi2)}")

  val testLi3 = "())(".toList
  println(s"$testLi3: ${balance(testLi3)}")

  val testLi4 = "".toList
  println(s"$testLi4: ${balance(testLi4)}")
}
