package week1

// Exercise 3: Counting Change
//
// Write a recursive function that counts how many different ways you
// can make change for an amount, given a list of coin denominations.
// For example, there are 3 ways to give change for 4 if you have coins
// with denomination 1 and 2: 1+1+1+1, 1+1+2, 2+2.

def countChange(money: Int, coins: List[Int]): Int = {
  if (money == 0) 1
  else if(money > 0 && coins.nonEmpty)
    countChange(money - coins.head, coins) + countChange(money, coins.tail)
  else 0
}

@main def week1_countChange(): Unit = {
  val money1: Int = 5
  val coins1: List[Int] = List(1)
  println(s"money: $money1, coins: $coins1, result: ${countChange(money1, coins1)}")

  val money2: Int = 5
  val coins2: List[Int] = List(2, 3)
  println(s"money: $money2, coins: $coins2, result: ${countChange(money2, coins2)}")

  val money3: Int = 4
  val coins3: List[Int] = List(2, 1)
  println(s"money: $money3, coins: $coins3, result: ${countChange(money3, coins3)}")

  // countChange(0, _) is always 1 as there is 1 way to represent 0 money - by showing 0 coins
  val money4: Int = 0
  val coins4: List[Int] = List(2, 1)
  println(s"money: $money4, coins: $coins4, result: ${countChange(money4, coins4)}")
}
