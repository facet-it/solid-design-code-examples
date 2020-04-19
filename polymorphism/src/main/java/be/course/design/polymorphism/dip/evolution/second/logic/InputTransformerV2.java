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

    public void start(String linePrefix) {

        Scanner consoleInput = new Scanner(System.in);
        String input = consoleInput.nextLine();

        while(! StandardCommand.STOP.equals(input)) {
            System.out.println(linePrefix + "-" + input);

            input = consoleInput.nextLine();
        }

    }

}
