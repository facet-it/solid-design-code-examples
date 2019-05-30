package be.course.design.encapsulation.filecheck;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * This is the component that will validate the data files line by line.
 *
 * Process of deciding what this component needs to do:
 * Thinking about the flow and its functionality.
 * So it will read in delimited files line by line,
 * read in the correct header file so that we know the column names, and it will read in all
 * of the known translation files for the columns that need 'translation'.
 *
 * for every line it will check a series of things.
 *
 * So what data does this class need?
 * the directory  where the files are put for processing
 * the directory with the header files
 * the directory with the translation files
 * the delimiter.
 *
 * the behaviour, what do i expect this component to do?
 * This component should read the file to validate line by line and then validate each line. If an
 * error is found, it should log that error. So basically this component should store errors
 * as well. We would also want to know on what line that error occurred. Because this component,
 * at the moment anyway, is reading the file, it should be responsible for the line number as well.
 *
 * To me, this looks like this component will be doing a lot of stuff... a lot of tasks tackling
 * different concerns.... maybe we should start to point out these concerns.. but leave it there
 * for now. it will be hard to test this class, since it does so many things.
 *
 * THOUGHTS ON THE CURRENT DESIGN
 * --  (i have written down the data and the validateFile method with 2
 * params: the datafile type and the file to validate) ---
 *
 * At this time in the process it dawns to me that I have no idea yet how
 * we will know the datafile type... this is a moment where a wrong impacting design
 * decision can be made. especially if you want to go fast.
 *
 * Also, the validation component needs to know what headerfile and what translation file to use
 * per type of file. There is a directory with a filename for every type. It dawns to me that I
 * have no way of letting the validation component know. Here we are at another important design
 * decision. THe easiest way would be to stuff it in the constructor... big no no!
 *
 *
 * The encapsulation mindset: what do I want this component to do? How can I make sure that interacting
 * with this component is easy? How can I make the API easy to use?
 *
 * So I have written out what I want this component to do, and by that, i have noted down the fields in
 * this component. It is time to flesh out the behaviour and interactions.
 *
 * So write down the algorithm: the sequence of actions that will happen:
 * 1 - move the datafile to the processing directory
 * 2 - read in the header
 * 3 - read in the translations
 * 4 - start reading the actual data file
 * 5 - loop until end of file:
 * - read line
 * - check on errors
 * - log errors if any
 *
 * When fleshing out, there might be more field necessary in your class.
 *
 * ---- implemented the behaviour.-- -----
 *
 * Now all is implemented. In some cases, you start testing now. I am a big fan of TDD. I did not do it now,
 * just to prove a point.
 *
 * But this thing is hard to test. How do you know that the translations are correctly read in? What about
 * the header file? All of these methods are private. It seems like encapsulation can make your class hard
 * to test!!
 */
public class ValidationComponent {

    private Path processDirectory = Paths.get("/filevalidation/processing");
    private Path headerFiles = Paths.get("/filevalidation/headerfiles");
    private Path translationFiles = Paths.get("/filevalidation/translationfiles");
    private Path fileToProcess;
    private String delimiter;
    private List<String> errors = new LinkedList<>();
    private int currentLineNumber;
    private DataFileType type;


    private String[] currentHeaders;
    private Map<String, Map<String, String>> currentTranslations;

    public ValidationComponent(Path dataFileToValidate, String delimiter) {
        this.delimiter = delimiter;
        this.fileToProcess = dataFileToValidate;
    }

    public List<String> checkFile() {
        determineType();
        Path dataFileInProcessing = copyDataFileToProcessDirectory();
        this.currentHeaders = readHeaders();
        this.currentTranslations = readTranslationFiles();
        processFile(dataFileInProcessing);
        return this.errors;
    }

    private void determineType() {
        if (fileToProcess.toString().contains("-Sales")) {
            this.type = DataFileType.SALES;
        } else if (fileToProcess.toString().contains("-Customers")) {
            this.type = DataFileType.CUSTOMERS;
        } else if (fileToProcess.toString().contains("-Products")) {
            this.type = DataFileType.PRODUCTS;
        }
    }

    private Path copyDataFileToProcessDirectory() {
        File fileToCopy = fileToProcess.toFile();
        File copiedFile = Paths.get(processDirectory.toString(), fileToCopy.getName()).toFile();

        try (FileInputStream fis = new FileInputStream(fileToCopy);
             FileOutputStream fos = new FileOutputStream(copiedFile)) {

            int read;
            byte[] buffer = new byte[512];

            while ((read = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, read);
            }

            return Paths.get(copiedFile.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private String[] readHeaders() {
        Path headerFile = Paths.get(headerFiles.toString(), type.getHeaderFileName());
        try (BufferedReader reader = new BufferedReader(new FileReader(headerFile.toString()))) {
            String line = reader.readLine();
            return line.split(delimiter);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private Map<String, Map<String, String>> readTranslationFiles() {
        Map<String, Map<String, String>> allTranslations = new HashMap<>();
        Path translationDirectory = Paths.get(translationFiles.toString(), type.getTranslationDirectoryName());
        File[] translationFiles = translationDirectory.toFile().listFiles();

        for (File translationFile : translationFiles) {
            Map<String, String> translation = new HashMap<>();
            //a translation file is xxx.txt. We only want the name, not the txt, so we split on the dot
            //and take the first part
            String translationName = translationFile.getName().split("\\.")[0];
            allTranslations.put(translationName, translation);

            try (BufferedReader reader = new BufferedReader(new FileReader(translationFile.getAbsolutePath()))) {
                String translationLine = reader.readLine();
                while (translationLine != null) {
                    //translation files are structured like this: value:translation
                    //hence the split on a colon
                    String[] splitTranslation = translationLine.split(":");
                    translation.put(splitTranslation[0], splitTranslation[1]);
                    translationLine = reader.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return allTranslations;
    }

    private void processFile(Path dataFileInProcessing) {
        File toProcess = dataFileInProcessing.toFile();
        try (BufferedReader reader = new BufferedReader(new FileReader(toProcess.getAbsolutePath()))) {
            String dataLine = reader.readLine();
            currentLineNumber = 1;
            while (dataLine != null) {
                String[] splitDataLine = dataLine.split(delimiter);

                checkLineLength(splitDataLine);
                checkTranslationsForLine(splitDataLine);

                dataLine = reader.readLine();
                currentLineNumber++;

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void checkLineLength(String[] splitLine) {
        if (splitLine.length < currentHeaders.length) {
            errors.add(String.format("Error on line %s: this line does not contain enough fields", currentLineNumber));
        } else if (splitLine.length > currentHeaders.length) {
            errors.add(String.format("Error on line %s: this line contains more fields than the header", currentLineNumber));
        }
    }

    private void checkTranslationsForLine(String[] splitLine) {
        //Split lines are a representation of a row from the csv data file. In order to know which translations are
        // available for a particular field, we need to know the column header, so we can do a lookup of the
        //translations for that header. There is only one way to do this and it is by position/ index.

        for (int i = 0; i < splitLine.length; i++) {
            String currentHeader = currentHeaders[i];
            Map<String, String> translations = currentTranslations.get(currentHeader);

            String fieldTranslation = translations.get(splitLine[i]);
            if (fieldTranslation == null) {
                errors.add(String.format("Error on line %s : no translation found for field %s", currentLineNumber, splitLine[i]));
            }
        }
    }
}
