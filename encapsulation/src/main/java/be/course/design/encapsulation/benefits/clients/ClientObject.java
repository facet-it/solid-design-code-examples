package be.course.design.encapsulation.benefits.clients;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import be.course.design.encapsulation.benefits.Configuration;
import be.course.design.encapsulation.benefits.DataFileType;
import be.course.design.encapsulation.benefits.FileOperations;
import be.course.design.encapsulation.benefits.FileValidatorService;
import be.course.design.encapsulation.benefits.ValidationService;

public class ClientObject {

    /**
     * In this client class, I want to do validation of datafiles. Remember the different steps in this proces:
     *
     * determine the type of the data file (is it products, sales history, customers, ...)
     * copy DataFile To Process Directory (the special directory used for processing the files after validation)
     * read Headers (data files used to be csv files without column names)
     * read Translations (unknown system values were put in a translation file)
     * read through file and validate
     * return errors
     */
    public static void main(String[] args) {

        //Instantiating all needed classes. For such a simple task, quite a lot of dependencies.
        ValidationService validatorService = new ValidationService();
        FileValidatorService fileValidatorService = new FileValidatorService();
        validatorService.setFileValidator(fileValidatorService);
        FileOperations fileOperations = new FileOperations();

        //Actually starting the process of validation a datafile
        DataFileType type = fileValidatorService.determineType(Paths.get("/processqueue/datafiles/2019-Sales.csv"));

        Path dataFileInProcessing =
            fileOperations.copyFile(Paths.get(args[1]), Configuration.getProcessingDirectory());

        List<String> errors = validatorService.checkDataFile(dataFileInProcessing, Paths.get("/headers/"),
                                                             Paths.get("/translations"),
                                                             ";",
                                                             type);

        errors.forEach(System.out::println);
    }
}
