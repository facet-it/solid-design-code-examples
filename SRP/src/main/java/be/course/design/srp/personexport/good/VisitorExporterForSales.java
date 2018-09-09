package be.course.design.srp.personexport.good;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;

/**
 * This is the sales version of the PersonExporter class. 
 */
public class VisitorExporterForSales {
    private final String DELIMITER = ",";

    public String firstName;
    public String lastName;
    public int age;
    public String gender;
    public boolean wouldWorkHere;
    public String reasonForVisit;
    public String emailAddress;

    public void export(String location) {
        File export = Paths.get(location).toFile();
        String csvLine = firstName + DELIMITER + lastName + DELIMITER + 
                age + DELIMITER + DELIMITER + gender + DELIMITER+ 
                reasonForVisit + DELIMITER + emailAddress;
        
        try (FileWriter writer = new FileWriter(export)) {
            writer.append(csvLine);
        } catch (IOException ioe) {
            System.out.println("Problem writing cvs file: " + ioe.getMessage());
        }
    }
}
