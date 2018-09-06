package be.course.design.srp.opendataproject.person;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;

public class ManuelPersonInput {

    private final String DONE = "done";
    private final String QUIT = "quit";
    private final String REDO = "redo";

    public void startInput() {
        try (BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in))) {
            Person person = null;
            person = new Person();
            System.out.println("Please fill in person data");
            System.out.println("ENTER FIRSTNAME: ");
            person.firstName = inputReader.readLine();

            System.out.println("ENTER LASTNAME: ");
            person.lastName = inputReader.readLine();

            System.out.println("ENTER DATE OF BIRTH (yyyy-mm-dd): ");
            String[] birthday = inputReader.readLine().split("-");
            LocalDate dob = LocalDate.of(Integer.parseInt(birthday[0]),
                    Integer.parseInt(birthday[1]),
                    Integer.parseInt(birthday[2]));
            person.dateOfBirth = dob;

            System.out.println("ENTER GENDER (m OR v)");
            person.gender = inputReader.readLine();

            person.export("normal", person.firstName + ".txt");
        } catch (IOException ioe) {
            System.out.println("Something went wrong during input: " + ioe.getMessage());
        }
    }
}
