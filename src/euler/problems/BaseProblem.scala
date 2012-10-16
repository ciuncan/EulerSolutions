/**
 * Created with IntelliJ IDEA.
 * User: ceyhun
 * Date: 8/17/12
 * Time: 2:05 PM
 * To change this template use File | Settings | File Templates.
 */
package euler.problems

trait BaseProblem {

  def solve(): String

  def run() {
    import Implicits._
    val start = System nanoTime()
    val s = solve
    val t = (System.nanoTime() - start) / (10 ** 9)
    s"Solution is :\n$s\nTime took: $t seconds" printMe
  }

  protected val NONE:Long = -1

  object Implicits {
    //@specialized(Long)

    implicit class IntegralOptions[I](n: I)(implicit int:Integral[I]) {
      import int._

      val two = one + one

      def isOdd  = n % two == 1
      def isEven = !isOdd

      def **(m: I) = Math.pow(n toDouble, m toDouble)

      //GRRRrrr!!! Couldn't make this one tailrecursive!  >:(
      def ^^(m: I) = {
        def iterate(exp:I):I = exp match {
          case _ if exp == zero => one
          case _ if exp isOdd   => iterate(exp - one) * n
          case _                => { val rec = iterate(exp / two); rec * rec }
        }
        iterate(m)
      }

      def ! : I = n * ((n - one) !)

    }

    /**
     * I don't like using parentheses or dots to call methods, especially 
     * for printing. Using this prefix method, without using dot, one can
     * call printMe. 
     * 
     * TODO: Maybe a symbol could be better for method name.
     * 
     */
    implicit class AnyOption(a: Any) {
      def printMe = println(a)
    }

    implicit class TwoDArrayOption[@specialized(Long) T](arr:Array[Array[T]])
            (implicit  num: Numeric[T]) {

      def rectString() = {
        val m = arr.map{_ map {num abs _} max}.max.toString.length + 1;
        arr map { case x => x map { s"%${m}d" format _ } mkString " "} mkString
          "\n"
      }

    }

  }
}


