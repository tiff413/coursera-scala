package week2

import scala.annotation.tailrec

// A number x is called a fixed point of a function f if f maps x to itself
// i.e. f(x) = x

// For some functions f we can locate the fixed points by starting with an
// initial estimate and then by applying f in a repetitive way until value
// does not vary anymore (or the change is sufficiently small).
// x, f(x), f(f(x)), f(f(f(x))), ...

// Doesn’t work for all functions, but works for quite a few such as sqrt.

val tolerance = 0.0001

// We used this for sqrts
// This is robust for very small and very large numbers
def isCloseEnough(x: Double, y: Double): Boolean =
  math.abs((x - y) / x) < tolerance

def fixedPoint(f: Double => Double)(firstGuess: Double): Double =
  @tailrec
  def iterate(guess: Double): Double =
    val next = f(guess)
    if isCloseEnough(guess, next) then next
    else iterate(next)
  iterate(firstGuess)

//def sqrtFirstTry(x: Double): Double = fixedPoint(y => x / y)(1.0)
// sqrtFirstTry(2) does not converge. Instead it oscillates between 1.0 and 2.0 :(

// One way to control such oscillations is to prevent the estimation
// from varying too much. This is done by average successive values
// of the original sequence.

// For sqrt, it is the avg of previous value y and the new value x / y
def sqrtAvgDamp(x: Double): Double = fixedPoint(y => (y + x / y) / 2)(1.0)
// sqrtAvgDamp(2) now works!

// This technique of stabilising by averaging is general enough to merit
// being abstracted into its own function
def averageDamp(f: Double => Double)(x: Double): Double =
  (x + f(x)) / 2

// Let's rewrite sqrt using fixedPoint and averageDamp
def sqrt(x: Double): Double = fixedPoint(averageDamp(y => x / y))(1.0)

@main def testSqrtFixedPoint(): Unit =
  println(sqrtAvgDamp(2))
  println(sqrt(2))