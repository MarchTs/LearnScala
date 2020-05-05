package exercies.the99

object P09 {
  //  Pack consecutive duplicates of list elements into sublists.
  def main(args: Array[String]): Unit = {
    val somelist = List("a", "a", "a", "a", "b", "c", "c", "a", "a", "d", "e", "e", "e", "e")
    val packResult = pack(somelist)
    println(packResult)



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

  def compressThenPack(list: List[Any]): List[List[Any]] = {
    def compress(list: List[Any]): List[Any] = {
      list.foldLeft(List[Any]()) { (a, b) =>
        if (a.isEmpty) List(b)
        else if (a.last == b) a
        else a :+ b
      }
    }
    val compressed = compress(list)
    compressed.map(something => {
      list.takeWhile(_ == something)
    })
  }


}
