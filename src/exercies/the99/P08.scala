package exercies.the99

object P08 {
  // Eliminate consecutive duplicates of list elements.
  def main(args: Array[String]): Unit = {
    val unCompress = List("a", "a", "a", "a", "b", "c", "c", "a", "a", "d", "e", "e", "e", "e")

    val recursiveResult = compress(unCompress)
    println(s"Compress with recursive ${recursiveResult}")

    val compressUsingReduceResult = compressUsingReduce(unCompress)
    println(s"Compress with Reduce ${compressUsingReduceResult}")

    val compressUsingfoldLeftResult = compressUsingfoldLeft(unCompress)
    println(s"Compress with foldLeft ${compressUsingfoldLeftResult}")

    val compressUsingfoldLeft2Result = compressUsingfoldLeft2(unCompress)
    println(s"Compress with foldLeft2 ${compressUsingfoldLeft2Result}")
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

  def compressUsingReduce(list: List[String]): String = {
    list.reduce((a, b) => {
      if (a.isEmpty) b
      else if (a.last.toString == b) a else a + b
    })
  }

  def compressUsingfoldLeft(list: List[Any]): List[Any] = {
    list.foldLeft(List[Any]()) { (a, b) =>
      if (a.isEmpty) List(b)
      else if (a.last == b) a
      else a :+ b
    }
  }

  def compressUsingfoldLeft2(list: List[Any]): List[Any] = {
    list.foldLeft(List[Any]()) { (a, b) =>
      if (a.isEmpty || a.last != b) a :+ b
      else a
    }
  }
}
