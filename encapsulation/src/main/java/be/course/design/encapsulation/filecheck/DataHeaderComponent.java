package be.course.design.encapsulation.filecheck;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import be.course.design.encapsulation.benefits.DataFileType;

public class DataHeaderComponent {

    public String[] readHeaders(Path headerFiles, DataFileType type, String headerDelimiter) {
        Path headerFile = Paths.get(headerFiles.toString(), type.getHeaderFileName());
        try (BufferedReader lineReader = new BufferedReader(new FileReader(headerFile.toString()))) {
            String line = lineReader.readLine();
            return line.split(headerDelimiter);
        } catch (IOException exception) {
            exception.printStackTrace();
            return new String[]{};
        }
    }

}
