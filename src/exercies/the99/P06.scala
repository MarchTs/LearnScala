package exercies.the99

object P06 {
  // Find out whether a list is a palindrome.
  def main(args: Array[String]): Unit = {
    val palindromeList = List(4,5,8,7,8,5,4)
    val anotherPalindromeList = List(4,5,8,8,5,4)

    val notPalindromeList = List(4,8,9,9,55,6,4,78,5)
    println(s"palindrome by tail recursive ${palindrome(palindromeList)}")
    println(s"palindrome by tail recursive ${palindrome(anotherPalindromeList)}")
    println(s"palindrome by tail recursive ${palindrome(notPalindromeList)}")


  }

  def palindrome[any](list: List[any]): Boolean = {
    def _palindrome[any](list: List[any], stillPalindrome: Boolean = true): Boolean ={
      if(!stillPalindrome) stillPalindrome
      else {
        list match {
          case _ :: Nil => stillPalindrome
          case head :: tail   => _palindrome(tail.init, stillPalindrome && (head == tail.last))
          case Nil => stillPalindrome
        }
      }
    }
    _palindrome(list)
  }
}
