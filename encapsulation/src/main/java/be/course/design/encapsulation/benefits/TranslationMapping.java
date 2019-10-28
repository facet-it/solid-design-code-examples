package be.course.design.encapsulation.benefits;

import java.util.HashMap;
import java.util.Map;

public class TranslationMapping {

    private String column;
    private Map<String, String> translations = new HashMap<>();

    public String getColumn() {
        return column;
    }

    public Map<String, String> getTranslations() {
        return translations;
    }
}
