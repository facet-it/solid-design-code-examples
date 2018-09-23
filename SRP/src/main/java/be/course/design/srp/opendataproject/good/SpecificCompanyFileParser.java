package be.course.design.srp.opendataproject.good;

import java.util.List;

public class SpecificCompanyFileParser {
    
    public PopulationStatisticsLine parseLine(String dataLine, List<LineError> errorLines) {
        String[] tokens = dataLine.split(",");
        PopulationStatisticsLine line = new PopulationStatisticsLine();

        try {
            line.setRefnisCodeGemeente(Integer.parseInt(tokens[0]));
        } catch (NumberFormatException nfe) {
            errorLines.add(new LineError(nfe.getMessage(), line));
        }

        line.setNaamGemeenteNl(tokens[1]);
        line.setNaamGemeenteFr(tokens[2]);

        try {
            line.setRefnisCodeArrondissement(Integer.parseInt(tokens[3]));
        } catch (NumberFormatException nfe) {
            errorLines.add(new LineError(nfe.getMessage(), line));
        }
 
        line.setNaamArrondissementFr(tokens[4]);
        line.setNaamArrondissementNl(tokens[5]);

        try {
            line.setRefnisCodeProvincie(Integer.parseInt(tokens[6]));
        } catch (NumberFormatException nfe) {
            errorLines.add(new LineError(nfe.getMessage(), line));
        }

        line.setNaamProvincieFr(tokens[7]);
        line.setNaamProvincieNl(tokens[8]);

        try {
            line.setRefnisCodeGewest(Integer.parseInt(tokens[9]));
        } catch (NumberFormatException nfe) {
            errorLines.add(new LineError(nfe.getMessage(), line));
        }

        line.setGeslacht(tokens[10]);
        line.setNaamGewestNl(tokens[11]);
        line.setNaamGewestFr(tokens[12]);

        line.setNationaliteitsCode(tokens[13]);

        line.setNationaliteitFr(tokens[14]);
        line.setNationaliteitNl(tokens[15]);
        line.setCodeBurgerlijkeStaat(tokens[16]);

        line.setBurgerlijkeStaatFr(tokens[17]);
        line.setBurgerlijkeStaatNl(tokens[18]);
        line.setLeeftijd(Integer.parseInt(tokens[19]));

        line.setAantal(Integer.parseInt(tokens[20]));
        line.setJaartal(tokens[21]);

        return line;
    }
}
