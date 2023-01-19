package week1

import scala.annotation.tailrec
import scala.math.abs

/* TASK: square root function using Newton's method */

def sqrt(x: Double): Double = {
  @tailrec
  def sqrtIter(guess: Double): Double =
    if isGoodEnough(guess) then guess
    else sqrtIter(improve(guess))
  // sqrtIter is recursive, its RHS calls itself
  // Recursive fns need an explicit return type in Scala
  // For non-recursive fns, the return type is optional

  def improve(guess: Double): Double =
    (guess + x / guess) / 2

  def isGoodEnough(guess: Double): Boolean =
    abs(guess * guess - x) < 0.001
  // Q: isGoodEnough test is not very precise for small numbers
  //    and can lead to non-termination for large numbers. Why?
  // A: Currently takes an absolute difference of 0.001, which
  //    is not very precise for small numbers and too small for
  //    very large numbers

  sqrtIter(1.0)
}


@main def week1_sqrt(): Unit = println(sqrt(2))

// Exercise
// Design an improved isGoodEnough function that is
// * precise for small numbers
// * will terminate for large numbers
// Test version with very very small and large numbers e.g.
// * 0.001
// * 0.1e-20
// * 1.0e20
// * 1.0e50

def isGoodEnough(guess: Double, x: Double): Boolean =
  abs(guess * guess - x)/x < 0.001

// Explanation: by dividing by x regardless of the scale of x,
//   the difference should maintain a constant percentage via
//   its fractional value
