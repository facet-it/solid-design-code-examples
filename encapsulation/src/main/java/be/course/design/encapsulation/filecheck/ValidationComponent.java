package be.course.design.encapsulation.filecheck;

import java.nio.file.Path;
import java.util.List;

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
 * the behaviour.
 */
public class ValidationComponent implements FileValidation {

    private Path processDirectory;
    private Path headerFiles;
    private Path translationFiles;
    private String delimiter;

    @Override
    public List<String> validateFile(DataFileType type, Path dataFileToValidate) {
        return null;
    }
}
