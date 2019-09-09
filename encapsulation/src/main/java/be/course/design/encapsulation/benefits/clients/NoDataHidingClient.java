package be.course.design.encapsulation.benefits.clients;

import java.nio.file.Paths;
import java.util.List;

import be.course.design.encapsulation.benefits.DataFileComponent;

public class NoDataHidingClient {

    private DataFileComponent component;

    public NoDataHidingClient(DataFileComponent component) {
        this.component = component;
    }

    /*
        Noticeable here is the fact that the developer of this client needs to know a lot about the process in order
        to use it. THis developer needs to know the steps of the process.
         */
    public void validateDateFile() {
        component.delimiter = "\t";
        component.fileToProcess = Paths.get("/Users/workspace/customers-2018.tsv");
        component.determineType();
        component.copyDataFileToProcessDirectory();
        component.readDataHeaders();
        component.readDataTranslationFiles();
        component.processFile();

        List<String> errors = component.errors;
    }
}
