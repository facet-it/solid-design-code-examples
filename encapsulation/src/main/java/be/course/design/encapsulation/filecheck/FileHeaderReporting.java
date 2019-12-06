package be.course.design.encapsulation.filecheck;

import java.nio.file.Paths;

import be.course.design.encapsulation.benefits.DataFileType;

public class FileHeaderReporting {

    public static void main(String[] args) {

        DataHeaderComponent headerComponent = new DataHeaderComponent();
        StringBuilder report = new StringBuilder("Headers report");

        for(be.course.design.encapsulation.benefits.DataFileType type : DataFileType.values()) {
            report.append("\n");
            String[] headers = headerComponent.readHeaders(Paths.get("/headers/"), type, ";");
            report.append(headers);
        }
    }

}
