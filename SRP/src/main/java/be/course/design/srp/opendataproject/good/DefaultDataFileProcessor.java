package be.course.design.srp.opendataproject.good;

import java.util.List;

public class DefaultDataFileProcessor extends StatisticsDataFileProcessor {
    
    private final DefaultDataFileParser parser = new DefaultDataFileParser();

    @Override
    public PopulationStatisticsLine parseLine(String line, List<LineError> errors) {
        return parser.parseLine(line, errors);
    }

}
