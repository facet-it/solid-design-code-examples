package be.course.design.encapsulation.benefits.clients;

import java.nio.file.Paths;

import be.course.design.encapsulation.benefits.DataFileComponent;

public class NoDataHidingApp {

    public static void main(String[] args) {
        DataFileComponent component = new DataFileComponent(Paths.get("/Users/workspace/Sales-2018.csv"), ",");

        NoDataHidingClient clientOne = new NoDataHidingClient(component);
        NoDataHidingClient2 clientTwo = new NoDataHidingClient2(component);

        clientOne.validateDateFile();
        clientTwo.validateDateFile();
    }
}
