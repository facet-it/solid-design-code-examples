package be.course.design.encapsulation.benefits.clients;

import java.nio.file.Paths;

import be.course.design.encapsulation.benefits.DataFileType;
import be.course.design.encapsulation.benefits.ValidationService;

/**
 * This class is some sort of a client. it only uses one method of the process. At a certain point in time, someone
 * wanted to have an overview of all the headers per type. And guess what? Because all of the methods in the classes
 * that represent the data validation process are public, the developer of this client thought it was ok to use
 * one of those methods. They are public after all, its like an open invitation!
 */
public class FileHeaderReporting {

    public static void main(String[] args) {
        ValidationService service = new ValidationService();

        StringBuilder report = new StringBuilder("Headers report");

        for(DataFileType type : DataFileType.values()) {
            report.append("\n");
            String[] headers = service.readHeaders(Paths.get("/headers/"), type, ";");
            report.append(headers);
        }
    }

}
