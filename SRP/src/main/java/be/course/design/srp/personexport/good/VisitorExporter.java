package be.course.design.srp.personexport.good;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.time.LocalDate;
import org.json.JSONObject;

public class VisitorExporter {

    private final String DELIMITER = ",";

    public String firstName;
    public String lastName;
    public LocalDate dateOfBirth;
    public String gender;
    public boolean wouldWorkHere;

    public void export(String format, String location) {
        File export = Paths.get(location).toFile();
        switch (format) {
            case "json":
                JSONObject toJson = new JSONObject();
                toJson.append("firstname", firstName);
                toJson.append("lastname", lastName);
                toJson.append("dateOfBirth", dateOfBirth.toString());
                toJson.append("gender", gender);
                toJson.append("would work here", wouldWorkHere);

                try (BufferedWriter writer = new BufferedWriter(new FileWriter(export.getName()))) {
                    writer.append(toJson.toString());
                } catch (IOException ioe) {
                    System.out.println("Problem writing json file: " + ioe.getMessage());
                }
                break;

            default:
                String csvLine = firstName + DELIMITER + lastName + DELIMITER
                        + dateOfBirth.toString() + DELIMITER + gender + DELIMITER + wouldWorkHere;
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(export.getName()))) {
                    writer.append(csvLine);
                } catch (IOException ioe) {
                    System.out.println("Problem writing cvs file: " + ioe.getMessage());
                }
        }
    }
}
