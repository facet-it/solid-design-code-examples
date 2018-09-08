package be.course.design.srp.personexport;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;

public class ManuelPersonInput {
    
    public void startInput() {
        try (BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in))) {
            Person person = new Person();
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
            
            System.out.println("CAN YOU SEE YOURSELF WORKING HERE? (Y/N)");
            String working = inputReader.readLine();
            if(working.toLowerCase().equals("y")) {
                person.wouldWorkHere = true;
            }
            else {
                person.wouldWorkHere = false;
            }

            person.export("json", person.firstName + ".json");
        } catch (IOException ioe) {
            System.out.println("Something went wrong during input: " + ioe.getMessage());
        }
    }
}
