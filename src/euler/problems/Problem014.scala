/**
 * Created with IntelliJ IDEA.
 * User: ceyhun
 * Date: 8/17/12
 * Time: 2:04 PM
 * To change this template use File | Settings | File Templates.
 */
package euler.problems

class Problem014 extends BaseProblem {

  val size = 1000000
  val memo = new collection.mutable.HashMap[Long, Long]

  def next(n: Long): Long = {
    import Implicits._
    if (n isOdd) 3 * n + 1
    else n / 2
  }

  def solve() = {
    memo(0) = 0
    memo(1) = 1
    size.to(900000, -1).foreach({ case i=>
      if (!exists(i)) memo(i) = runFor(i)
    })
    val bestN = memo.keySet.maxBy({case i => memo(i)})
    s"Best pair is ${(bestN, memo(bestN))}"
  }

  def exists(i:Long) = memo contains i
  def absent(i:Long) = !exists(i)

  def runFor(n: Long): Long =
    if (exists(n)) {
      memo(n)
    } else {
      val count = runFor(next(n)) + 1
      //(n -> count) printMe;
      memo(n) = count
      count
    }

  def nonMemoIterate(n:Long):Long =
    if (n != 1) {
      val nex = next(n)
      println(nex)
      nonMemoIterate(nex) + 1
    } else 1

}

