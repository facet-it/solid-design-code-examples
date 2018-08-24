package be.course.design.srp.opendataproject.bad;

public class DataFileParser {

    public PopulationStatisticsLine parseLine(String dataLine) {
        String[] tokens = dataLine.split(",");
        PopulationStatisticsLine line = new PopulationStatisticsLine();
        
        line.setRefnisCodeGemeente(Integer.parseInt(tokens[0]));
        line.setNaamGemeenteNl(tokens[1]);
        line.setNaamGemeenteFr(tokens[2]);
        line.setRefnisCodeArrondissement(Integer.parseInt(tokens[3]));
        line.setNaamArrondissementNl(tokens[4]);
        line.setNaamArrondissementNl(tokens[5]);
        line.setRefnisCodeProvincie(Integer.parseInt(tokens[6]));
        line.setNaamProvincieNl(tokens[7]);
        line.setNaamProvincieFr(tokens[8]);
        line.setRefnisCodeGewest(Integer.parseInt(tokens[9]));
        line.setNaamGewestNl(tokens[10]);
        line.setNaamGewestFr(tokens[11]);
        line.setGeslacht(tokens[12]);
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