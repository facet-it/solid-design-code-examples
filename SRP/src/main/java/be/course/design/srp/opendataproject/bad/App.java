package be.course.design.srp.opendataproject.bad;

public class App {

    public static void main(String[] args) {
        DataFileReader reader = new DataFileReader();
        
        reader.readFile("C:\\workspace\\datasets\\pop-residence-nationality\\TEST.csv");
        reader.simpleReport();
    }
    
}
