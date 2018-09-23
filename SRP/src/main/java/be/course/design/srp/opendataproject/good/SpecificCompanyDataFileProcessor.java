package be.course.design.srp.opendataproject.good;

import java.util.List;

public class SpecificCompanyDataFileProcessor extends StatisticsDataFileProcessor {
    
    private final SpecificCompanyFileParser parser = new SpecificCompanyFileParser();

    @Override
    public PopulationStatisticsLine parseLine(String line, List<LineError> errors) {
        return parser.parseLine(line, errors);
    }
}
