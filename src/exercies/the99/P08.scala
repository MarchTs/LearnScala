package exercies.the99

object P08 {
  // Eliminate consecutive duplicates of list elements.
  def main(args: Array[String]): Unit = {
    val unCompress = List("a", "a", "a", "a", "b", "c", "c", "a", "a", "d", "e", "e", "e", "e")

    val someResult = compress(unCompress)
    println(someResult)

  }

  // without peek solution
  def compress(list: List[Any]): List[Any] = {
    def _compress(list: List[Any], compressed: List[Any] = List()): List[Any] = list match {
      case Nil => compressed
      case head :: tail => {
        if (compressed.length <= 0) _compress(tail, compressed :+ head)
        else if (compressed.last != head) _compress(tail, compressed :+ head)
        else _compress(tail, compressed)
      }
    }
    _compress(list)
  }
}
