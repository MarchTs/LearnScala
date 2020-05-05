package exercies.the99

object P09 {
  //  Pack consecutive duplicates of list elements into sublists.
  def main(args: Array[String]): Unit = {
    val somelist = List("a", "a", "a", "a", "b", "c", "c", "a", "a", "d", "e", "e", "e", "e")
    val packResult = pack(somelist)
    println(packResult)
    val packResult2= recursiveSpan(somelist)
    println(packResult2)


  }

  def pack(list: List[Any]): List[Any] = {
    list.foldLeft(List[List[Any]]()) { (a, b) =>
      if (a.isEmpty) List(List(b))
      else if (!a.exists(list => list.head == b))
        a.appended(List(b))
      else
        a.map(listInA => {
          if (listInA.head == b) listInA.appended(b)
          else listInA
        })
    }
  }

  def recursiveSpan(list: List[Any]): List[List[Any]] = {
    def _tailRecur(list: List[Any], acc: List[List[Any]] = List[List[Any]]()): List[List[Any]] = list match {
      case Nil => acc
      case head :: _ => {
        val something = list.span(_ == head)
        _tailRecur(something._2, acc.appended(something._1))
      }
    }

    _tailRecur(list)
  }


}
