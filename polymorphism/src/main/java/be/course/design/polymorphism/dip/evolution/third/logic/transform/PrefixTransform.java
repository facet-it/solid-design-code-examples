package be.course.design.polymorphism.dip.evolution.third.logic.transform;

/**
 * I could have passed the prefix as a parameter in the transform method. But I didn't. Why?
 */
public class PrefixTransform implements Transform {

    private String prefix;

    public PrefixTransform(String prefix) {
        this.prefix = prefix;
    }

    @Override
    public String transform(String input) {
        return prefix + "-" + input;
    }
}
