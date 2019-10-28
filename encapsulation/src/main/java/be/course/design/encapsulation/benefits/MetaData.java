package be.course.design.encapsulation.benefits;

import java.util.ArrayList;
import java.util.List;

public class MetaData {

    private String[] headers = new String[]{};
    private List<TranslationMapping> allTranslations = new ArrayList<>();

    public String[] getHeaders() {
        return headers;
    }

    public List<TranslationMapping> getAllTranslations() {
        return allTranslations;
    }
}
