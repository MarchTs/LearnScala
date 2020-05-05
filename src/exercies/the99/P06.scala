package exercies.the99

object P06 {
  // Find out whether a list is a palindrome.
  def main(args: Array[String]): Unit = {
    val palindromeList = List(4,5,8,7,8,5,4)
    val anotherPalindromeList = List(4,5,8,8,5,4)

    val notPalindromeList = List(4,8,9,9,55,6,4,78,5)
    println(s"palindrome by tail recursive ${isPalindromeRecursive(palindromeList)}")
    println(s"palindrome by tail recursive ${isPalindromeRecursive(anotherPalindromeList)}")
    println(s"palindrome by tail recursive ${isPalindromeRecursive(notPalindromeList)}")

    println(s"palindrome by reverse ${isPalindromeReverse(palindromeList)}")
    println(s"palindrome by reverse ${isPalindromeReverse(anotherPalindromeList)}")
    println(s"palindrome by reverse ${isPalindromeReverse(notPalindromeList)}")
  }

  def isPalindromeRecursive[any](list: List[any]): Boolean = {
    def _isPalindrome[any](list: List[any], stillPalindrome: Boolean = true): Boolean ={
      if(!stillPalindrome) stillPalindrome
      else {
        list match {
          case _ :: Nil => stillPalindrome
          case head :: tail   => _isPalindrome(tail.init, stillPalindrome && (head == tail.last))
          case Nil => stillPalindrome
        }
      }
    }
    _isPalindrome(list)
  }

  def isPalindromeReverse[any](list: List[any]): Boolean = {
  list == list.reverse
  }
}
