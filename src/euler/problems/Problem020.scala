package euler.problems

/**
 * Created with IntelliJ IDEA.
 * User: ceyhun
 * Date: 10/16/12
 * Time: 4:50 AM
 */
class Problem020 extends BaseProblem {

  def solve = {
    import Implicits._
    100L.!.toString.map{_.toString.toLong}.sum.toString
  }

}
