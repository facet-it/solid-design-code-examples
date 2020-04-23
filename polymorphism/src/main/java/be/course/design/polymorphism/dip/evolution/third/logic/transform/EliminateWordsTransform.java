package be.course.design.polymorphism.dip.evolution.third.logic.transform;

import java.util.LinkedList;
import java.util.List;

public class EliminateWordsTransform implements Transform {

    private List<String> wordsToEliminate = new LinkedList<>();
    private char mask;
    private int minimumWordLength;

    public EliminateWordsTransform(List<String> words, char mask) {
        this.mask = mask;
        this.wordsToEliminate.addAll(words);
    }

    @Override
    public String transform(String input) {
        String transformation = input;

        for(String censored : wordsToEliminate) {
            String replacement = new String(new char[censored.length()]).replace('\0', mask);
            transformation = transformation.replace(censored, replacement);
        }

        return transformation;
    }
}
