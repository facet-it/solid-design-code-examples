package be.course.design.encapsulation.filecheck;

import java.nio.file.Path;
import java.util.LinkedList;
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
 * the behaviour, what do i expect this component to do?
 * This component should read the file to validate line by line and then validate each line. If an
 * error is found, it should log that error. So basically this component should store errors
 * as well. We would also want to know on what line that error occurred. Because this component,
 * at the moment anyway, is reading the file, it should be responsible for the line number as well.
 *
 * To me, this looks like this component will be doing a lot of stuff... a lot of tasks tackling
 * different concerns.... maybe we should start to point out these concerns..
 *
 * THOUGHTS ON THE CURRENT DESIGN
 * --  (i have written down the data and the validateFile method with 2
 * params: the datafile type and the file to validate) ---
 * At this time in the process it dawns to me that I have no idea yet how
 * we will know the datafile type... this is a moment where a wrong impacting design
 * decision can be made. especially if you want to go fast.
 *
 * Also, the validation component needs to know what headerfile and what translation file to use
 * per type of file. There is a directory with a filename for every type. It dawns to me that I
 * have no way of letting the validation component know. Here we are at another important design
 * decision. THe easiest way would be to stuff it in the constructor... big nono!
 *
 *
 * The encapsulation mindset: what do I want this component to do? How can I make sure that interacting
 * with this component is easy? How can I make the API easy to use?
 *
 * So I have written out what I want this component to do, and by that, i have noted down the fields in
 * this component.
 */
public class ValidationComponent implements FileValidation {

    private Path processDirectory;
    private Path headerFiles;
    private Path translationFiles;
    private String delimiter;
    private List<String> errors = new LinkedList<>();

    @Override
    public List<String> validateFile(DataFileType type, Path dataFileToValidate) {
        return null;
    }
}
