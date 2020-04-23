package be.course.design.polymorphism.dip.evolution.third.logic.transform;

public class PrefixSuffixTransform implements Transform {

    private final String prefix;
    private final String suffix;

    public PrefixSuffixTransform(String prefix, String suffix) {
        this.prefix = prefix;
        this.suffix = suffix;
    }

    @Override
    public String transform(String input) {
        return prefix + "-" + input + "-" + suffix;
    }
}
