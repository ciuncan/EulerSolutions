/**
 * Created with IntelliJ IDEA.
 * User: ceyhun
 * Date: 8/18/12
 * Time: 8:47 AM
 * To change this template use File | Settings | File Templates.
 */
package euler.problems

class Problem015 extends BaseProblem {

  val size = 20

  val arr = Array.fill(size + 1, size + 1)(NONE);

  def calc(r:Int, c:Int):Long = arr(r)(c) match {
    case NONE => {
      var n:Long = 1
      if (r != size && c != size) {
        n = calc(r, c + 1) + calc(r + 1, c)
      }
      arr(r)(c) = n
      n
    }
    case v    => v
  }

  def solve() = {
    import Implicits._
    val n = calc(0, 0);
    println(arr rectString)
    s"$size x $size grid, there are $n possible ways."
  }



}

