package exercies.the99

object P02 {
  def main(args: Array[String]): Unit = {
    val theList = List(1, 2, 2, 3, 8)
    println(s"just build in function ${theList.init.last}")
    println(s"the second last with length ${useLength(theList)}")
    println(s"the second last with reverse ${useReverse(theList)}")
  }

  def useLength[A](list: List[A]): A = {
    val length = list.length
    if (length <= 1) throw new NoSuchElementException
    list(length - 2)
  }

  def useReverse[A](list: List[A]): A = {
    val reverseArray = list.reverse
    reverseArray(1)
  }
}
