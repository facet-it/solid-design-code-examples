package be.course.design.srp.personexport;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;

public class PersonInput {

    private final String NEW_PERSON = "new";
    private final String DONE = "done";
    private final String QUIT = "quit";
    private final String REDO = "redo";

    public Person startInput() {
        try (BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in))) {
            Person person = null;
            String input = inputReader.readLine();
            while (!input.equals(QUIT)) {
                if (input.equals(NEW_PERSON)) {
                    person = new Person();
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
                    
                    System.out.println("DONE OR REDO?");
                    input = inputReader.readLine();
                    while(!input.equals(REDO) || !input.equals(DONE)) {
                        System.out.println("UNKNONWN COMMAND. PLEASE ENTER REDO OR DONE");
                        input = inputReader.readLine();
                    }
                    while(input.equals(REDO)) {
                        System.out.println("ENTER FIRSTNAME: ");
                        person.firstName = inputReader.readLine();

                        System.out.println("ENTER LASTNAME: ");
                        person.lastName = inputReader.readLine();

                        System.out.println("ENTER DATE OF BIRTH (yyyy-mm-dd): ");
                        birthday = inputReader.readLine().split("-");
                        dob = LocalDate.of(Integer.parseInt(birthday[0]),
                                Integer.parseInt(birthday[1]),
                                Integer.parseInt(birthday[2]));
                        person.dateOfBirth = dob;

                        System.out.println("ENTER GENDER (m OR v)");
                        person.gender = inputReader.readLine();

                        System.out.println("DONE OR REDO?");
                        input = inputReader.readLine();
                    }
                    if(input.equals(DONE)) {
                        person.export("csv", person.firstName + "-" + person.lastName + ".csv");
                    }
                } 
                if(input.equals(QUIT)) {
                    break;
                }
                else{
                    input = inputReader.readLine();
                }
            }
            return person;
        } catch (IOException ioe) {
            System.out.println("Something went wrong during input: " + ioe.getMessage());
            return null;
        }
    }

}
