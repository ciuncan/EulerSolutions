package euler.problems

/**
 * Created with IntelliJ IDEA.
 * User: ceyhun
 * Date: 8/19/12
 * Time: 11:12 PM
 * To change this template use File | Settings | File Templates.
 */
class Problem017 extends BaseProblem {

  def num2word(n:Int):String = n match {
    case 1000 => "onethousand"
    case _ if n >= 100 => {
      val hundreds = n / 100
      val rest = n - 100 * hundreds
      num2word(hundreds) + "hundred" + (if (rest > 0) "and" + num2word(rest)
                                           else "")
    }
    case _ if n >= 10 => {
      val tens = n / 10
      val tensStr = tens match {
        case 1 => n match {
          case 10 => "ten"
          case 11 => "eleven"
          case 12 => "twelve"
          case 13 => "thirteen"
          case 15 => "fifteen"
          case  _ => num2word(n % 10) + "teen"
        }
        case 2 => "twenty"
        case 3 => "thirty"
        case 4 => "forty"
        case 5 => "fifty"
        case _ => num2word(tens) + "ty"
      }
      val rest = n - 10 * tens
      tensStr + (if (rest > 0 && tens != 1) "" + num2word(rest) else "")
    }
    case 0 => "zero"
    case 1 => "one"
    case 2 => "two"
    case 3 => "three"
    case 4 => "four"
    case 5 => "five"
    case 6 => "six"
    case 7 => "seven"
    case 8 => "eight"
    case 9 => "nine"
  }

  def solve = {
    val m = 1 to 1000 map { num2word(_) replaceAllLiterally (" ", ""
      ) length } sum

    s"Total number of charaters of $m."
  }

}
