package be.course.design.polymorphism.dip.evolution.third.logic;

import java.util.LinkedList;
import java.util.List;

import be.course.design.polymorphism.dip.evolution.third.logic.transform.EliminateWordsTransform;

public class Application {

    public static void main(String[] args) {

        List<String> wordsToCensor = new LinkedList<>();
        wordsToCensor.add("fuck");
        wordsToCensor.add("shit");
        wordsToCensor.add("dammit");
        wordsToCensor.add("ass");
        wordsToCensor.add("asshole");

        EliminateWordsTransform transformer = new EliminateWordsTransform(wordsToCensor, '*');
        InputTransformerV3 inputTransformer = new InputTransformerV3(transformer);
        inputTransformer.start();
    }

}
