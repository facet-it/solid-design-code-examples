package be.course.design.srp.opendataproject.bad;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class DataFileReader {
    private static String UNKNOWN_CODE_ON_FIELD = "Onbekende veld - code combinatie: ";
    private static String UNKNOW_SEX_CODE = "Onbekende geslachts code. Moet 'm' of 'f' zijn";
    private static String NO_NATIONALITY_CODE = "Geen nationaliteitscode";
    private static String NO_MARITAL_STATUS_CODE = "Geen code voor burgelijke staat";
    private static String ILLEGAL_AGE = "Ongeldige leeftijd";
    private static String ILLEGAL_AMOUNT = "ongeldig aantal";
    
    private DataFileParser fileParser = new DataFileParser();
    private Function<String, PopulationStatisticsLine> lineConsumer = line -> this.parseLine(line);
    private List<LineError> errorLines = new ArrayList<>();

    public void readFile(String fileName) {
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            errorLines.clear(); // we need to clear this every time we do a readfile otherwise results will mix.
            List<PopulationStatisticsLine> lines = stream.map(lineConsumer).collect(Collectors.toList());
            
        } catch (IOException e) {
            System.out.println("Error occured: " + e.getMessage());
        }
    }

    private PopulationStatisticsLine parseLine(String dataLine) {
        String[] tokens = dataLine.split(",");
        PopulationStatisticsLine line = new PopulationStatisticsLine();

        try{
            line.setRefnisCodeGemeente(Integer.parseInt(tokens[0]));
            if(line.getRefnisCodeGemeente() > 100000) {
                errorLines.add(new LineError(UNKNOWN_CODE_ON_FIELD + "gemeente - " + line.getRefnisCodeGemeente(), line));
            }
        }
        catch(NumberFormatException nfe) {
            errorLines.add(new LineError(nfe.getMessage(), line));
        }
        
        line.setNaamGemeenteNl(tokens[1]);
        line.setNaamGemeenteFr(tokens[2]);
   
        try{
            line.setRefnisCodeArrondissement(Integer.parseInt(tokens[3]));
            if(line.getRefnisCodeArrondissement()> 100000) {
                errorLines.add(new LineError(UNKNOWN_CODE_ON_FIELD + "arrondissement - " + line.getRefnisCodeArrondissement(), line));
            }
        }
        catch(NumberFormatException nfe) {
            errorLines.add(new LineError(nfe.getMessage(), line));
        }
        
        line.setNaamArrondissementNl(tokens[4]);
        line.setNaamArrondissementNl(tokens[5]);
        
        try{
            line.setRefnisCodeProvincie(Integer.parseInt(tokens[6]));
            if(line.getRefnisCodeArrondissement()> 100000) {
                errorLines.add(new LineError(UNKNOWN_CODE_ON_FIELD + "provincie - " + line.getRefnisCodeProvincie(), line));
            }
        }
        catch(NumberFormatException nfe) {
            errorLines.add(new LineError(nfe.getMessage(), line));
        }
        
        line.setNaamProvincieNl(tokens[7]);
        line.setNaamProvincieFr(tokens[8]);

        try{
            line.setRefnisCodeGewest(Integer.parseInt(tokens[9]));
            if(line.getRefnisCodeArrondissement()> 100000) {
                errorLines.add(new LineError(UNKNOWN_CODE_ON_FIELD + "gewest - " + line.getRefnisCodeGewest(), line));
            }
        }
        catch(NumberFormatException nfe) {
            errorLines.add(new LineError(nfe.getMessage(), line));
        }
        
        line.setNaamGewestNl(tokens[10]);
        line.setNaamGewestFr(tokens[11]);
        line.setGeslacht(tokens[12]);
        if(! line.getGeslacht().toLowerCase().equals("m") || !line.getGeslacht().toLowerCase().equals("f")) {
            errorLines.add(new LineError(UNKNOW_SEX_CODE, line));
        }
        
        line.setNationaliteitsCode(tokens[13]);
        if(line.getNationaliteitsCode()== null || line.getNationaliteitsCode().equals("")) {
            errorLines.add(new LineError(NO_NATIONALITY_CODE, line));
        } 
        
        line.setNationaliteitFr(tokens[14]);
        line.setNationaliteitNl(tokens[15]);
        line.setCodeBurgerlijkeStaat(tokens[16]);
        if(line.getCodeBurgerlijkeStaat()== null || line.getCodeBurgerlijkeStaat().equals("")) {
            errorLines.add(new LineError(NO_MARITAL_STATUS_CODE, line));
        } 
        
        line.setBurgerlijkeStaatFr(tokens[17]);
        line.setBurgerlijkeStaatNl(tokens[18]);
        line.setLeeftijd(Integer.parseInt(tokens[19]));
        if(line.getLeeftijd() < 1 || line.getLeeftijd() > 150) {
            errorLines.add(new LineError(ILLEGAL_AGE, line));
        }
        
        line.setAantal(Integer.parseInt(tokens[20]));
        if(line.getAantal() < 1) {
            errorLines.add(new LineError(ILLEGAL_AMOUNT, line));
        }
        line.setJaartal(tokens[21]);

        return line;
    }

    private void createXmlFile(XmlDataFile file) {
        try {
            File targetFile = Paths.get("C:\\workspace\\datasets\\pop-residence-nationality", "datafile.xml").toFile();
            JAXBContext jaxbContext = JAXBContext.newInstance(XmlDataFile.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            // output pretty printed
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.setProperty(Marshaller.JAXB_ENCODING, "ISO-8859-1");
            jaxbMarshaller.marshal(file, targetFile);

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
