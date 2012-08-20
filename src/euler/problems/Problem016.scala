package euler.problems

/**
 * Created with IntelliJ IDEA.
 * User: ceyhun
 * Date: 8/20/12
 * Time: 9:08 PM
 */
class Problem016 extends BaseProblem {

  def solve():String = {
    import Implicits._
    val n:Int = ( BigInt(2) ^^ 1000 toString ) map { _ asDigit } sum

    s"Sum of digits are $n"
  }

}

