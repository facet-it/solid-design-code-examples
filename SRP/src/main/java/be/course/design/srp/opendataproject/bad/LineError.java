package be.course.design.srp.opendataproject.bad;

public class LineError {
    
    private final String error;
    private final PopulationStatisticsLine targetLine;
    
    public LineError(String error, PopulationStatisticsLine targetLine) {
        this.error = error;
        this.targetLine = targetLine;
    }

    public String getError() {
        return error;
    }

    public PopulationStatisticsLine getTargetLine() {
        return targetLine;
    }
}
