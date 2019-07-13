package be.course.design.encapsulation.benefits;

import java.util.List;
import java.util.Map;

public class ValidationUtils {

    public static void checkLineLength(String[] splitLine, String[] currentHeaders, List<String> errors, int currentLineNumber) {
        if (splitLine.length < currentHeaders.length) {
            errors.add(String.format("Error on line %s: this line does not contain enough fields", currentLineNumber));
        } else if (splitLine.length > currentHeaders.length) {
            errors.add(String.format("Error on line %s: this line contains more fields than the header", currentLineNumber));
        }
    }

    public static void checkTranslationsForLine(String[] splitLine,
                                         String[] currentHeaders,
                                         Map<String, Map<String, String>> currentTranslations,
                                         List<String> errors,
                                         int currentLineNumber) {
        for (int i = 0; i < splitLine.length; i++) {
            String currentHeader = currentHeaders[i];
            Map<String, String> translations = currentTranslations.get(currentHeader);

            String fieldTranslation = translations.get(splitLine[i]);
            if (fieldTranslation == null) {
                errors.add(String.format("There is no translation found for field %s on line %s", splitLine[i], currentLineNumber));
            }
        }
    }

}
