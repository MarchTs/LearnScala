package exercies.the99

import java.util.NoSuchElementException

import scala.annotation.tailrec

object P03 {
  def main(args: Array[String]): Unit = {
    val theList = List(1, 2, 2, 4, 1, 2, 3, 5)
    val findAtLocation = 5
    println(s"Find at index by build-in ${theList(findAtLocation)}")
    println(s"Find at index by recursive ${traverse(theList, findAtLocation)}")
    println(s"Find at index by without any build-in ${withoutAnyBuildIn(theList, findAtLocation)}")

  }

  @tailrec
  def traverse[Something](list: List[Something], index: Int): Something = {
    if (list.length < index + 1) throw new IndexOutOfBoundsException
    else if (list.length == index + 1) list.last
    else traverse(list.init, index)
  }

  /**
   * reduce head of list to specific index then take head of list as result
   *
   * @param list  list
   * @param index index at specific location on list
   * @tparam Any generic type
   * @return generic type
   */
  @tailrec
  def withoutAnyBuildIn[Any](list: List[Any], index: Int): Any = (list, index) match {

    case (head :: _, 0) => head
    case (_ :: tail, index) => withoutAnyBuildIn(tail, index - 1)
    case (nil, _) => throw new NoSuchElementException
  }
}
