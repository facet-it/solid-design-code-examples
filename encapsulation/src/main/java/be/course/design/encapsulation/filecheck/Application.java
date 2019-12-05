package be.course.design.encapsulation.filecheck;

import java.nio.file.Paths;

public class Application {


    public static void main(String[] args) {
        DirectoryPollingComponent polling = new DirectoryPollingComponent("workspace/test");
        polling.start();

        ValidationComponent component = new ValidationComponent(Paths.get("somepath"), ",");

        component.checkFile();
    }
}
