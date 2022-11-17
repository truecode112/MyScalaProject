object Triangle extends App {

  // 93%
  def solution(A: Array[Int]): Int = {
    val sa = A.toList.sorted.toArray
    for (p <- 0 to sa.length - 3) if (sa(p) + sa(p + 1) > sa(p + 2)) return 1
    0
  }

  //100%
  def solution1(A: Array[Int]): Int = {
    scala.util.Sorting.quickSort(A)
    @scala.annotation.tailrec
    def loop(idx: Int): Int = {
      if (idx >= A.length - 2) 0
      else if (A(idx) <= 0) loop(idx + 1)
      else {
        val currentTrio = (A(idx) + A(idx + 1)) - A(idx + 2)
        if (currentTrio > 0) 1
        else loop(idx + 1)
      }
    }
    loop(0)
  }

  val ar1 = Array(10, 2, 5, 1, 8, 20)
  val ar2 = Array(10, 50, 5, 1)
  val ar3 = Array[Int]()
  val ar4 = Array(1, 1, 1)
  val ar5 = Array(2, 3)

  println(solution(ar1))
  println(solution(ar2))
  println(solution(ar3))
  println(solution(ar4))
  println(solution(ar5))

  println("*****")

  println(solution1(ar1))
  println(solution1(ar2))
  println(solution1(ar3))
  println(solution1(ar4))
  println(solution1(ar5))

  /*

  A zero-indexed array A consisting of N integers is given. A triplet (P, Q, R) is triangular if 0 ≤ P < Q < R < N and:

  A[P] + A[Q] > A[R],
  A[Q] + A[R] > A[P],
  A[R] + A[P] > A[Q].
  For example, consider array A such that:

    A[0] = 10    A[1] = 2    A[2] = 5
    A[3] = 1     A[4] = 8    A[5] = 20
  Triplet (0, 2, 4) is triangular.

  Write a function:

  object Solution { def solution(A: Array[Int]): Int }

  that, given a zero-indexed array A consisting of N integers, returns 1 if there exists a triangular triplet for this array and returns 0 otherwise.

  For example, given array A such that:

    A[0] = 10    A[1] = 2    A[2] = 5
    A[3] = 1     A[4] = 8    A[5] = 20
  the function should return 1, as explained above. Given array A such that:

    A[0] = 10    A[1] = 50    A[2] = 5
    A[3] = 1
  the function should return 0.

  Assume that:

  N is an integer within the range [0..100,000];
  each element of array A is an integer within the range [−2,147,483,648..2,147,483,647].
  Complexity:

  expected worst-case time complexity is O(N*log(N));
  expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).
  Elements of input arrays can be modified.
 */
}
