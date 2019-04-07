package be.course.design.encapsulation.filecheck;

public class App {


    public static void main(String[] args) {
        DirectoryPollingComponent polling = new DirectoryPollingComponent("/Users/nicholasocket/Documents/workspace/test");
        polling.start();
    }
}
