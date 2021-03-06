package be.course.design.srp.personexport;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.Period;
import org.json.JSONObject;

public class PersonForSales {

    private final String DELIMITER = ",";

    public String firstName;
    public String lastName;
    public LocalDate dateOfBirth;
    public String gender;
    public boolean wouldWorkHere;
    public String reasonForVisit;
    public String emailAddress;

    public void export(String format, String location, boolean forSales) {
        File export = Paths.get(location).toFile();
        switch (format) {
            case "json":
                JSONObject toJson = new JSONObject();
                toJson.append("firstname", firstName);
                toJson.append("lastname", lastName);
                toJson.append("dateOfBirth", dateOfBirth.toString());
                toJson.append("gender", gender);
                toJson.append("would work here", wouldWorkHere);

                try (FileWriter writer = new FileWriter(export)) {
                    writer.append(toJson.toString());
                } catch (IOException ioe) {
                    System.out.println("Problem writing json file: " + ioe.getMessage());
                }
                break;

            default:
                String csvLine = firstName + DELIMITER + lastName + DELIMITER;
                if (forSales) {
                    LocalDate now = LocalDate.now();
                    int age = Period.between(dateOfBirth, now).getYears();
                    csvLine = csvLine + age + DELIMITER;
                }
                csvLine = csvLine + DELIMITER + gender + DELIMITER; 
                if(forSales) {
                    csvLine = csvLine + reasonForVisit + DELIMITER + emailAddress;
                }
                else {
                    csvLine = csvLine + wouldWorkHere + DELIMITER;
                }
                try (FileWriter writer = new FileWriter(export)) {
                    writer.append(csvLine);
                } catch (IOException ioe) {
                    System.out.println("Problem writing cvs file: " + ioe.getMessage());
                }
        }
    }
}
