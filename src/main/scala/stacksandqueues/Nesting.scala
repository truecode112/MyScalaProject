object Nesting extends App {

  //100%
  def solution2(S: String): Int = {
    val results = S.foldLeft(0) { (total, chr) =>
      if (total < 0) total
      else {
        chr match {
          case '(' => total + 1
          case ')' => total - 1
          case _   => total
        }
      }
    }

    if (results == 0) 1
    else 0
  }

  // 100%
  def solution1(S: String): Int = {
    @scala.annotation.tailrec
    def loop(idx: Int, numOpen: Int): Boolean = {
      if (idx >= S.size) numOpen == 0
      else {
        val c = S.charAt(idx)
        if (c == '(') {
          loop(idx + 1, numOpen + 1)
        } else if (c == ')') {
          if (numOpen == 0) false
          else loop(idx + 1, numOpen - 1)
        } else { loop(idx + 1, numOpen) }
      }
    }

    if (loop(0, 0)) 1 else 0
  }
  // 100%
  def solution(S: String): Int = {
    var list = List[Char]()
    for (i <- S.indices) {
      S(i) match {
        case '(' => list = S(i) :: list
        case ')' =>
          if (list.isEmpty) return 0
          if (list.head == '(') list = list.tail
          else return 0
      }
    }
    if (list.isEmpty) 1 else 0
  }

  val goodString = "(()(())())"
  val badString = "())"
  solution(goodString)
  solution(badString)

  /*
  A string S consisting of N characters is called properly nested if:

  S is empty;
  S has the form "(U)" where U is a properly nested string;
  S has the form "VW" where V and W are properly nested strings.
    For example, string "(()(())())" is properly nested but string "())" isn't.

  Write a function:

  object Solution { def solution(S: String): Int }

  that, given a string S consisting of N characters, returns 1 if string S is properly nested and 0 otherwise.

  For example, given S = "(()(())())", the function should return 1 and given S = "())", the function should return 0, as explained above.

    Assume that:

    N is an integer within the range [0..1,000,000];
  string S consists only of the characters "(" and/or ")".
  Complexity:

    expected worst-case time complexity is O(N);
  expected worst-case space complexity is O(1) (not counting the storage required for input arguments).
 */
}
