package exercies.the99

object P05 {
  // Reverse a list
  def main(args: Array[String]): Unit = {
    val somelist = List(6, 58, 6, 6, 9, 2, 6, 456, 9)
    val reversedList = somelist.reverse
    println(s"reverse list using build-in function ${reversedList}")

    val someResult = reverseRecur(somelist)
    println(s"reverse list using pattern matching ${someResult}")
  }

  def reverseRecur[any](list: List[any], resultAcc: List[any] = List.empty): List[any] = list match {
    case Nil => resultAcc
    case head :: tail => reverseRecur(tail, head +: resultAcc)
  }
}
