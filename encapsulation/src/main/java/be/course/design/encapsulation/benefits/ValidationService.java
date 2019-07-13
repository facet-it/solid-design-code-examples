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


/**
 * The clou of this example:
 *
 * Suppose that that situation has changed: we no longer use header files and translation files, because we can get
 * all of that information one go by using a webservice. If that would be so, we would need to change the validation service,
 * the filevalidationservice (change of signature and maybe let it make the call) and the client, which in this case needs to
 * know the paths of the header and translation files.
 */
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
