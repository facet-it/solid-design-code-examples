package be.course.design.srp.personexport;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.Period;
import org.json.JSONObject;

/**
 * Even though we have separated this 'responsibility' of exporting from the 
 * person info, we still do no solve the problem at hand of code that serves 
 * multiple interests! 
 */
public class ExporterForSales { 
    private final String DELIMITER = ",";
    
    public void export(PersonSeparated person, String format, String location, boolean forSales) {
        File export = Paths.get(location).toFile();
        switch (format) {
            case "json":
                JSONObject toJson = new JSONObject();
                toJson.append("firstname", person.getFirstName());
                toJson.append("lastname", person.getLastName());
                toJson.append("dateOfBirth", person.getDateOfBirth().toString());
                toJson.append("gender", person.getGender());
                toJson.append("would work here", person.isWouldWorkHere());

                try (FileWriter writer = new FileWriter(export)) {
                    writer.append(toJson.toString());
                } catch (IOException ioe) {
                    System.out.println("Problem writing json file: " + ioe.getMessage());
                }
                break;

            default:
                String csvLine = person.getFirstName() + DELIMITER + 
                                 person.getLastName() + DELIMITER;
                if (forSales) {
                    LocalDate now = LocalDate.now();
                    int age = Period.between(person.getDateOfBirth(), now).getYears();
                    csvLine = csvLine + age + DELIMITER;
                }
                csvLine = csvLine + DELIMITER + person.getGender() + DELIMITER; 
                if(forSales) {
                    csvLine = csvLine + person.getReasonForVisit() +
                              DELIMITER + person.getEmailAddress();
                }
                else {
                    csvLine = csvLine + person.isWouldWorkHere() + DELIMITER;
                }
                try (FileWriter writer = new FileWriter(export)) {
                    writer.append(csvLine);
                } catch (IOException ioe) {
                    System.out.println("Problem writing cvs file: " + ioe.getMessage());
                }
        }
    }
}
