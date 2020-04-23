package be.course.design.polymorphism.dip.evolution.third.logic;

import java.util.Scanner;

import be.course.design.polymorphism.dip.evolution.third.logic.transform.Transform;

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
public class InputTransformerV3 {

    public static final int PREFIX_ONLY = 1;
    public static final int SUFFIX_ONLY = 2;
    public static final int BOTH = 3;

    private Transform transformer;

    public InputTransformerV3(Transform transformer) {
        this.transformer = transformer;
    }

    public void start() {

        Scanner consoleInput = new Scanner(System.in);
        String input = consoleInput.nextLine();

        while (!StandardCommand.STOP.equals(input)) {
            System.out.println(transformer.transform(input));
            input = consoleInput.nextLine();
        }

    }

}
