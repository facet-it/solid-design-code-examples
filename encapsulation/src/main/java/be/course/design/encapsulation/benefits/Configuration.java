package be.course.design.encapsulation.benefits;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Configuration {

    private static final String PROCESS_DIRECTORY = "/file/processing";

    public static Path getProcessingDirectory() {
        return Paths.get(PROCESS_DIRECTORY);
    }

}
