package be.course.design.encapsulation.benefits.clients;

import java.nio.file.Paths;
import java.util.Map;

import be.course.design.encapsulation.benefits.DataFileType;
import be.course.design.encapsulation.benefits.ValidationService;

public class TranslationsCheckup {

    public static void main(String[] args) {
        ValidationService service = new ValidationService();

        StringBuilder report = new StringBuilder("Headers report");

        for(DataFileType type : DataFileType.values()) {
            report.append("\n");
            Map<String, Map<String, String>> translations = service.readTranslationFiles(Paths.get("/translations/"), type, ";");
            for(String colomn : translations.keySet()) {
                Map<String, String> translationsForColumn = translations.get(colomn);

                for(String translationKey : translationsForColumn.keySet()) {
                    if(translationsForColumn.get(translationKey) == "") {
                        System.out.println("No translation for key " + translationKey + " in column " + colomn);
                    }
                }
            }
        }
    }

}
