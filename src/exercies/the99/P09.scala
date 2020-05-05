package exercies.the99

object P09 {
  //  Pack consecutive duplicates of list elements into sublists.
  def main(args: Array[String]): Unit = {
    val somelist = List("a", "a", "a", "a", "b", "c", "c", "a", "a", "d", "e", "e", "e", "e")
    val packResult = pack(somelist)
    println(packResult)

  }

  def pack(list: List[Any]): List[Any] = {
    list.foldLeft(List[List[Any]]()) { (a, b) => {
      if (a.length == 0) List(List(b))
      else if (!a.exists(list => list(0) == b))
        a.appended(List(b))
      else
        a.map(listInA => {
          if (listInA.last == b) listInA.appended(b)
          else listInA
        })
    }
    }
  }
}
