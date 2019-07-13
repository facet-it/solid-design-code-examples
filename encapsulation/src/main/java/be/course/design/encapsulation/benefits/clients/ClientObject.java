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
     * In this client class, I want to do validate datafiles.
     * @param args
     */
    public static void main(String[] args) {

        //checking a datafile for errors
        ValidationService validatorService = new ValidationService();
        FileValidatorService fileValidatorService = new FileValidatorService();

        validatorService.setFileValidator(fileValidatorService);

        FileOperations fileOperations = new FileOperations();

        //Since this process is not longer encapsulated, a client also needs to know the steps of the process.
        DataFileType type = fileValidatorService.determineType(Paths.get("/processqueue/datafiles/"));

        Path dataFileInProcessing =
            fileOperations.copyFile(Paths.get(args[1]), Configuration.getProcessingDirectory());

        List<String> errors = validatorService.checkDataFile(dataFileInProcessing, Paths.get("/headers/"),
                                                             Paths.get("/translations"),
                                                             ";",
                                                             type);

        errors.forEach(System.out::println);
    }
}
