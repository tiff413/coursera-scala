package week1

// Exercise 1: Pascal's Triangle
//
// The following pattern of numbers is called Pascal's triangle.
//
//    1
//   1 1
//  1 2 1
// 1 3 3 1
//1 4 6 4 1
//   ...
// Write a function that computes the elements of Pascal's triangle by
// means of a recursive process.
//
// The fn should take in a column c and a row r, counting from 0 and 
// return the number at that spot in the triangle.
// For example, pascal(0,2)=1, pascal(1,2)=2 and pascal(1,3)=3.

def pascal(c: Int, r:Int): Option[Int] = {
  def pascalIter(c: Int, r:Int): Int = {
    if c == 0 || c == r then 1
    else pascalIter(c-1, r-1) + pascalIter(c, r-1)
  }

  if c > r then None
  else Some(pascalIter(c, r))
}

@main def week1_pascal(): Unit = {
  println("pascal(0, 2) = " + pascal(0, 2))
  println("pascal(1, 2) = " + pascal(1, 2))
  println("pascal(1, 3) = " + pascal(1, 3))
}