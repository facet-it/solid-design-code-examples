package be.course.design.srp.opendataproject.good;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Representing the 'algoritmn' for processing a statistics data file. This class
 * contains the stuff that does not or has not changed yet.
 */
public abstract class StatisticsDataFileProcessor {

    private static String UNKNOWN_CODE_ON_FIELD = "Onbekende veld - code combinatie: ";
    private static String UNKNOW_SEX_CODE = "Onbekende geslachts code. Moet 'm' of 'f' zijn";
    private static String NO_NATIONALITY_CODE = "Geen nationaliteitscode";
    private static String NO_MARITAL_STATUS_CODE = "Geen code voor burgelijke staat";
    private static String ILLEGAL_AGE = "Ongeldige leeftijd";
    private static String ILLEGAL_AMOUNT = "ongeldig aantal";

    
    private List<LineError> errorLines = new ArrayList<>();

    public void processFile(String fileName) {
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            stream.map(line -> {PopulationStatisticsLine parsed = parseLine(line, errorLines); 
                                checkForErrors(parsed);
                                return parsed;
                               }).collect(Collectors.toList());
            simpleReport();

        } catch (IOException e) {
            System.out.println("Error occured: " + e.getMessage());
        }
    }
    

    public abstract PopulationStatisticsLine parseLine(String line, List<LineError> errors);

    private void checkForErrors(PopulationStatisticsLine line) {
        if (line.getRefnisCodeGemeente() > 100000) {
            errorLines.add(new LineError(UNKNOWN_CODE_ON_FIELD + "gemeente - "
                    + line.getRefnisCodeGemeente(), line));
        }

        if (line.getRefnisCodeArrondissement() > 100000) {
            errorLines.add(new LineError(UNKNOWN_CODE_ON_FIELD + "arrondissement - "
                    + line.getRefnisCodeArrondissement(), line));
        }

        if (line.getRefnisCodeArrondissement() > 100000) {
            errorLines.add(new LineError(UNKNOWN_CODE_ON_FIELD + "provincie - "
                    + line.getRefnisCodeProvincie(), line));
        }

        if (line.getRefnisCodeArrondissement() > 100000) {
            errorLines.add(new LineError(UNKNOWN_CODE_ON_FIELD + "gewest - "
                    + line.getRefnisCodeGewest(), line));
        }

        if (!line.getGeslacht().toLowerCase().equals("m")
                || !line.getGeslacht().toLowerCase().equals("f")) {
            errorLines.add(new LineError(UNKNOW_SEX_CODE, line));
        }

        if (line.getNationaliteitsCode() == null || line.getNationaliteitsCode()
                .equals("")) {
            errorLines.add(new LineError(NO_NATIONALITY_CODE, line));
        }

        if (line.getCodeBurgerlijkeStaat() == null || line.getCodeBurgerlijkeStaat()
                .equals("")) {
            errorLines.add(new LineError(NO_MARITAL_STATUS_CODE, line));
        }

        if (line.getLeeftijd() < 1 || line.getLeeftijd() > 150) {
            errorLines.add(new LineError(ILLEGAL_AGE, line));
        }

        if (line.getAantal() < 1) {
            errorLines.add(new LineError(ILLEGAL_AMOUNT, line));
        }

    }

    private void simpleReport() {
        System.out.println("The amount of errors in this file: "
                + this.errorLines.size());
        System.out.println("----------------------------------------------");

        errorLines.stream().forEach(line -> {
            System.out.println(line.getError());
            System.out.println("-----------");
        });
    }
}
