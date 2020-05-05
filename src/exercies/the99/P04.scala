package exercies.the99

object P04 {
  def main(args: Array[String]): Unit = {
    val someList = List(4, 2, 5, 4, 6, 4, 5, 1, 2, 5)
    println(s"length with build-in ${someList.length}")

    val someListLength = length(someList)
    println(s"length with pattern matching ${someListLength}")

    println(s"length with foldleft ${useFoldLeft(someList)}")

    val something = someList.zipWithIndex.last._2 + 1
    println(s"length with zipWithIndex ${something}")

  }

  def length[any](list: List[any]): Int = {
    def _length(list: List[any], accumulator: Int = 0): Int = list match {
      case Nil => accumulator
      case _ :: tail => _length(tail, accumulator + 1)
    }

    _length(list)
  }

  def useFoldLeft[any](list: List[any]) = list.foldLeft(0) { (count, _) => count + 1 }
}
