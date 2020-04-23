package be.course.design.polymorphism.dip.evolution.second.logic;

import java.util.Scanner;

/**
 * This is the inputtransformer. It's job is to fetch the incoming line of text from console and print it back
 * to the console.
 *
 * For now, the point would be to transform that input string by adding something to it. But that will change in
 * the future. That something is now still a parameter which needs to be passed through the start method.
 *
 * When we analyse this class, you could say that this is how the algorithm goes:
 *
 * 1) fetch the incoming line
 * 2) transform it
 * 3) output it
 *
 * So the inputTransformer has 3 different concerns, but only 1 responsibility. At the moment it knows how to deal
 * with all of the concerns.
 */
public class InputTransformerV2 {

    public static final int PREFIX_ONLY = 1;
    public static final int SUFFIX_ONLY = 2;
    public static final int BOTH = 3;

    public void start(String linePrefix, String suffix, int action) {

        Scanner consoleInput = new Scanner(System.in);
        String input = consoleInput.nextLine();

        while (!StandardCommand.STOP.equals(input)) {

            if (action == PREFIX_ONLY) {
                if (linePrefix == null || linePrefix == "") {
                    System.out.println("There is no line prefix, cannot transform your input!");
                }
                else {
                    System.out.println(linePrefix + "-" + input);
                }
            }

            if (action == SUFFIX_ONLY) {
               if (suffix == null || suffix.equals("")) {
                   System.out.println("There is no suffix, cannot transform your input");
               }
               else {
                   System.out.println(input + "-" + suffix);
               }
            }

            if(action == BOTH) {
                if (linePrefix == null || linePrefix == "") {
                    System.out.println("There is no line prefix, cannot transform your input!");
                }
                else if (suffix == null || suffix.equals("")) {
                    System.out.println("There is no suffix, cannot transform your input");
                }
                else {
                    System.out.println(linePrefix + "-" + input + "-" + suffix);
                }
            }

            input = consoleInput.nextLine();
        }

    }

}
