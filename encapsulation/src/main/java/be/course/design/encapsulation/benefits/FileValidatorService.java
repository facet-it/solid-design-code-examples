package be.course.design.encapsulation.benefits;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class FileValidatorService {

    public DataFileType determineType(Path fileToProcess) {
        if (fileToProcess.toString().contains("-Sales")) {
            return DataFileType.SALES;
        } else if (fileToProcess.toString().contains("-Customers")) {
            return DataFileType.CUSTOMERS;
        } else if (fileToProcess.toString().contains("-Products")) {
            return DataFileType.PRODUCTS;
        } else {
            throw new RuntimeException("Can't determine type of this file" + fileToProcess.toString());
        }
    }

    public List<String> processFile(Path dataFileInProcessing,
                                    String[] currentHeaders,
                                    Map<String, Map<String, String>> currentTranslations, String delimiter) {
        List<String> errors = new LinkedList<>();
        File toProcess = dataFileInProcessing.toFile();
        try (BufferedReader reader = new BufferedReader(new FileReader(toProcess.getAbsolutePath()))) {
            String dataLine = reader.readLine();
            int currentLineNumber = 1;
            while (dataLine != null) {
                String[] splitDataLine = dataLine.split(delimiter);

                ValidationUtils.checkLineLength(splitDataLine, currentHeaders, errors, currentLineNumber);
                ValidationUtils.checkTranslationsForLine(splitDataLine, currentHeaders, currentTranslations,
                                                         errors, currentLineNumber);

                dataLine = reader.readLine();
                currentLineNumber++;

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return errors;
    }
}
