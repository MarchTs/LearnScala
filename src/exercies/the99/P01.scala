package exercies.the99

object P01 {
  def main(args: Array[String]): Unit = {
    val theList = List(1, 1, 2, 3, 5, 8)

    // the easiest way
    println(s"Last element from the easiest way is ${theList.last}")

    val lastElement = lastRecursive(theList)
    println(s"The hard way for what ever reason is ${lastElement}")

//    playground()

  }
  // What is A in 'lastRecursive[A](ls: List[A])'?
  // What is the meaning of "A @uncheckedVariance" in :: function?
  // Is List.match equal switch(list)?
  // What is symbol :: in list mean?
  // What is _ ? Is it mean "nothing" or "no need to care about it" or "null"
  // When to enter 'case _         => throw new NoSuchElementException'

  def lastRecursive[A](ls: List[A]): A = ls match {
        case head :: Nil  => head
        case _ :: tail => lastRecursive(tail)
        case _         => throw new NoSuchElementException
  }


  def playground() = {
    println("----------------------------------------------------------")
    val someList = List(3,2,5,1)
    someList match {
      case _ :: tail => println(s"Tail '${tail}'")
      case head :: tail => println(s"head '${head}' tail '${tail}'")
      case ::(head, next) => println(s"head '${head}' tail '${next}'")
      case _         => println(s"something wrong??")
    }

    println("----------------------------------------------------------")
    val anotherList = 6 :: someList
    println(s"list before :: is ${someList}")
    println(s"'a :: list' mean 'a append b' right?" + anotherList)
  }
}
