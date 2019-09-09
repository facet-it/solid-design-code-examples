package be.course.design.encapsulation.benefits;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class DataFileComponent {

    public Path processDirectory = Paths.get("/filevalidation/processing");
    public Path headerFiles = Paths.get("/filevalidation/headerfiles");
    public Path translationFilesPath = Paths.get("/filevalidation/translationfiles");
    public Path fileToProcess;
    public String delimiter;
    public List<String> errors;
    public int currentLineNumber;
    public DataFileType type;


    public String[] currentHeaders;
    public Map<String, Map<String, String>> currentTranslations;

    public DataFileComponent(Path dataFileToValidate, String delimiter) {
        this.delimiter = delimiter;
        this.fileToProcess = dataFileToValidate;
    }

    public void determineType() {
        if (fileToProcess.toString().contains("-Sales")) {
            this.type = DataFileType.SALES;
        } else if (fileToProcess.toString().contains("-Customers")) {
            this.type = DataFileType.CUSTOMERS;
        } else if (fileToProcess.toString().contains("-Products")) {
            this.type = DataFileType.PRODUCTS;
        }
    }

    public void copyDataFileToProcessDirectory() {
        File fileToCopy = fileToProcess.toFile();
        File copyTarget = Paths.get(processDirectory.toString(), fileToCopy.getName()).toFile();

        try (FileInputStream fis = new FileInputStream(fileToCopy);
             FileOutputStream fos = new FileOutputStream(copyTarget)) {

            int read;
            byte[] buffer = new byte[512];

            while ((read = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, read);
            }
            String pathString = copyTarget.toString();
            this.fileToProcess = Paths.get(pathString);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void readDataHeaders() {
        Path headerFile = Paths.get(headerFiles.toString(), type.getHeaderFileName());
        try (BufferedReader r = new BufferedReader(new FileReader(headerFile.toString()))) {
            String line = r.readLine();
            currentHeaders =  line.split(delimiter);
        } catch (IOException e) {
            throw new RuntimeException("Unexpected problem occurred while reading the headers");
        }
    }

    public void readDataTranslationFiles() {
        Path translationDirectory = Paths.get(translationFilesPath.toString(), type.getTranslationDirectoryName());
        File currentTranslation = translationDirectory.toFile();
        File[] translationFiles = currentTranslation.listFiles();

        for (File translationFile : translationFiles) {
            Map<String, String> translation = new HashMap<>();
            String[] filenameParts = translationFile.getName().split("\\.");
            String translationName = filenameParts[0];
            currentTranslations.put(translationName, translation);

            try (BufferedReader reader = new BufferedReader(new FileReader(translationFile.getAbsolutePath()))) {
                String translationLine = reader.readLine();
                while (translationLine != null) {
                    String[] splitTranslation = translationLine.split(":");
                    translation.put(splitTranslation[0], splitTranslation[1]);
                    translationLine = reader.readLine();
                }
            } catch (IOException exception) {
                System.out.println("Error occurred while reading in translation file");
                exception.printStackTrace();
            }
        }
    }

    public void addExtraTranslations(String key, Map<String, String> values) {
        Map<String, String> currentValues = currentTranslations.get(key);

        if(currentValues == null) {
            currentTranslations.put(key, values);
        }
        else {
            for(String translationKey: values.keySet()) {
                currentValues.put(translationKey, values.get(translationKey));
            }
        }
    }

    public int amountOfDataLines(Path fileToCount) {
        File toProcess = fileToCount.toFile();
        try (BufferedReader reader = new BufferedReader(new FileReader(toProcess.getAbsolutePath()))) {
            String dataLine = reader.readLine();
            int amountOfLines = 1;
            while (dataLine != null) {
                dataLine = reader.readLine();
                amountOfLines++;
            }
            return amountOfLines;
        } catch (IOException exception) {
            System.out.println("Error occurred while processing the data file");
            exception.printStackTrace();
            return 0;
        }
    }

    public List<String> processFile() {
        errors = new LinkedList<>();
        File toProcess = this.fileToProcess.toFile();
        try (BufferedReader reader = new BufferedReader(new FileReader(toProcess.getAbsolutePath()))) {
            String dataLine = reader.readLine();
            currentLineNumber = 1;
            while (dataLine != null) {
                String[] splitDataLine = dataLine.split(delimiter);

                validateLength(splitDataLine);
                validateTranslations(splitDataLine);

                dataLine = reader.readLine();
                currentLineNumber++;

            }

            return errors;
        } catch (IOException exception) {
            System.out.println("Error occurred while processing the data file");
            exception.printStackTrace();
            return new LinkedList<>();
        }
    }

    public void validateLength(String[] splitLine) {
        if (splitLine.length < currentHeaders.length) {
            errors.add(String.format("Error on line %s: this line does not contain enough fields", currentLineNumber));
        } else if (splitLine.length > currentHeaders.length) {
            errors.add(String.format("Error on line %s: this line contains more fields than the header", currentLineNumber));
        }
    }

    public void validateTranslations(String[] splitLine) {
        for (int i = 0; i < splitLine.length; i++) {
            String currentHeader = currentHeaders[i];
            Map<String, String> translations = currentTranslations.get(currentHeader);

            if (translations.get(splitLine[i]) == null) {
                errors.add(String.format("Error on line %s : no translation found for field %s", currentLineNumber, splitLine[i]));
            }
        }
    }
}
