package be.course.design.srp.personexport;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import org.json.JSONObject;

public class PersonExporter {
    private final String DELIMITER = ",";

    public void export(PersonSeparated person, String format, String location) {
        File export = Paths.get(location).toFile();
        switch (format) {
            case "json":
                JSONObject toJson = new JSONObject();
                toJson.append("firstname", person.getFirstName());
                toJson.append("lastname", person.getLastName());
                toJson.append("dateOfBirth", person.getDateOfBirth().toString());
                toJson.append("gender", person.getGender());

                try (FileWriter writer = new FileWriter(export)) {
                    writer.append(toJson.toString());
                } catch (IOException ioe) {
                    System.out.println("Problem writing cvs file: " + ioe.getMessage());
                }
                break;

            default:
                String csvLine = person.getFirstName() + DELIMITER + person.getLastName() + DELIMITER
                        + person.getDateOfBirth().toString() + DELIMITER + person.getGender();
                try (FileWriter writer = new FileWriter(export)) {
                    writer.append(csvLine);
                } catch (IOException ioe) {
                    System.out.println("Problem writing cvs file: " + ioe.getMessage());
                }
        }
    }
}
