package be.course.design.encapsulation.benefits;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ValidationService {

    private FileValidatorService fileValidator;

    public void setFileValidator(FileValidatorService fileValidator) {
        this.fileValidator = fileValidator;
    }

    public String[] readHeaders(Path headerFiles, DataFileType type, String headerDelimiter) {
        Path headerFile = Paths.get(headerFiles.toString(), type.getHeaderFileName());
        try (BufferedReader lineReader = new BufferedReader(new FileReader(headerFile.toString()))) {
            String line = lineReader.readLine();
            return line.split(headerDelimiter);
        } catch (IOException exception) {
            exception.printStackTrace();
            return new String[]{};
        }
    }

    public Map<String, Map<String, String>> readTranslationFiles(Path translationFilesPath, DataFileType type, String delimiter) {
        Map<String, Map<String, String>> allTranslations = new HashMap<>();
        Path translationDirectory = Paths.get(translationFilesPath.toString(), type.getTranslationDirectoryName());
        File[] translationFiles = translationDirectory.toFile().listFiles();

        for (File translationFile : translationFiles) {
            Map<String, String> translation = new HashMap<>();
            String translationName = translationFile.getName().split("\\.")[0];
            allTranslations.put(translationName, translation);

            try (BufferedReader reader = new BufferedReader(new FileReader(translationFile.getAbsolutePath()))) {
                String translationLine = reader.readLine();
                while (translationLine != null) {
                    String[] splitTranslation = translationLine.split(delimiter);
                    translation.put(splitTranslation[0], splitTranslation[1]);
                    translationLine = reader.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return allTranslations;
    }

    public List<String> checkDataFile(Path dataFileInProcessing, Path headerFiles,
                                      Path translationFiles, String delimiter,
                                      DataFileType type) {
        String[] headers = readHeaders(headerFiles, type, delimiter);
        Map<String, Map<String, String>> translations = readTranslationFiles(translationFiles, type, delimiter);

        List<String> errors = fileValidator.processFile(dataFileInProcessing, headers, translations, delimiter);
        return errors;
    }

}
