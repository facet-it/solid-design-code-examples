package be.course.design.polymorphism.dip.evolution.second.logic;

public class Application {

    public static void main(String[] args) {

        InputTransformerV2 transformer = new InputTransformerV2();
        transformer.start("$$$$$", "-----", InputTransformerV2.SUFFIX_ONLY);
    }

}
