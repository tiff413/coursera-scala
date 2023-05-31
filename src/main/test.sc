val test: Set[Long] = Set(1, 2, 3)

case class Name(name: String)

//test.toList.map(long => Name(long.toString))

for {
  test2 <- test.map(long => Name(long.toString))
  test3 = test2.name
} yield test3