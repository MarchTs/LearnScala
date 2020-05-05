package exercies.the99

object P07 {
  // Flatten a nested list structure.
  def main(args: Array[String]): Unit = {
    val complexList = List(List(1, 1), 2, List(3, List(5, 8)))


    val flatmap = flatten(complexList)
    println(flatmap)
    val flatted = anotherFlatten(complexList)
    println(flatted)
  }

  def flatten (list: List[Any]): List[Any] = list flatMap {
    case stillList: List[any] => flatten(stillList)
    case element => List(element)
  }

  def anotherFlatten (list: List[Any]): List[Any] = list flatten {
    case stillList: List[any] => anotherFlatten(stillList)
    case element => List(element)
  }

//  def flatten(ls: List[Any]): List[Any] = ls flatMap {
//    case ms: List[_] => flatten(ms)
//    case e => List(e)
//  }

}

