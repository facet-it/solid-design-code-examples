package be.course.design.encapsulation.benefits;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MetaData {

    private String[] headers = new String[]{};
    private List<TranslationMapping> allTranslations = new ArrayList<>();

    public String[] getHeaders() {
        return headers;
    }

    public List<TranslationMapping> getAllTranslations() {
        return allTranslations;
    }

    public Map<String, Map<String,String>> getTranslationsMapped() {
        return new HashMap<>();
    }
}
