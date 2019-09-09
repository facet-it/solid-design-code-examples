package be.course.design.encapsulation.benefits.clients;

import java.util.List;

import be.course.design.encapsulation.benefits.DataFileComponent;

public class NoDataHidingClient2 {

    private DataFileComponent component;

    public NoDataHidingClient2(DataFileComponent component) {
        this.component = component;
    }

    public void validateDateFile() {
        component.determineType();
        component.copyDataFileToProcessDirectory();
        component.readDataHeaders();
        component.readDataTranslationFiles();
        component.processFile();

        List<String> errors = component.errors;
    }
}
