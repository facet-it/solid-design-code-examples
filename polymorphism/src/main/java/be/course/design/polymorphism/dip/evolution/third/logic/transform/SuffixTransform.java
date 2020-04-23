package be.course.design.polymorphism.dip.evolution.third.logic.transform;

public class SuffixTransform implements Transform {

    private final String suffix;

    public SuffixTransform(String suffix) {
        this.suffix = suffix;
    }

    @Override
    public String transform(String input) {
        return input + "-" + this.suffix;
    }
}
