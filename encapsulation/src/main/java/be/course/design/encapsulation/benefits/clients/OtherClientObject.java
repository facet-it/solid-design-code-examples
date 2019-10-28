package be.course.design.encapsulation.benefits.clients;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import be.course.design.encapsulation.benefits.Configuration;
import be.course.design.encapsulation.benefits.DataFileType;
import be.course.design.encapsulation.benefits.FileOperations;
import be.course.design.encapsulation.benefits.FileValidatorService;
import be.course.design.encapsulation.benefits.ValidationService;

public class OtherClientObject {

    /**
     * This is just another client object. Hey, nobody said there is only one client...
     */
    public static void main(String[] args) {

        //Instantiating all needed classes
        ValidationService validatorService = new ValidationService();
        FileValidatorService fileValidatorService = new FileValidatorService();
        validatorService.setFileValidator(fileValidatorService);
        FileOperations fileOperations = new FileOperations();

        //Actually starting the process of validation a datafile
        DataFileType type = fileValidatorService.determineType(Paths.get("/processqueue/datafiles/2019-Customers.csv"));

        Path dataFileInProcessing =
            fileOperations.copyFile(Paths.get(args[1]), Configuration.getProcessingDirectory());

        List<String> errors = validatorService.checkDataFile(dataFileInProcessing, Paths.get("/headers/"),
                                                             Paths.get("/translations"),
                                                             ";",
                                                             type);

        errors.forEach(System.out::println);
    }
}
