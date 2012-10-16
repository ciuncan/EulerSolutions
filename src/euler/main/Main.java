package euler.main;

import euler.problems.BaseProblem;
import euler.problems.Problem014;

import static java.lang.String.format;

/**
 * Created with IntelliJ IDEA.
 * User: ceyhun
 * Date: 8/17/12
 * Time: 2:52 PM
 */
public class Main {
  public static void main(String... args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
    int num;
    if (args.length > 0) {
      num = Integer.parseInt(args[0]);
    } else {
      num = 20;
    }
    String className = format("euler.problems.Problem%03d", num);
    BaseProblem problem = (BaseProblem) Class.forName(className).newInstance();
    problem.run();
  }

}
