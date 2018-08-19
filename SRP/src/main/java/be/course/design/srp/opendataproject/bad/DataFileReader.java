package be.course.design.srp.opendataproject.bad;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class DataFileReader {

    private DataFileParser fileParser = new DataFileParser();
    private Consumer<String> lineConsumer = line -> fileParser.parseLine(line);
    
    public void readFile(String fileName) {
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

            stream.forEach(lineConsumer);

        } catch (IOException e) {
            System.out.println("Error occured: " + e.getMessage());
        }
    }

}
