package be.course.design.srp.opendataproject.bad;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "datafile")
public class XmlDataFile {
    private List<PopulationStatisticsLineToXml> lines;

    public List<PopulationStatisticsLineToXml> getLines() {
        return lines;
    }

    @XmlElement(name = "line")
    public void setLines(List<PopulationStatisticsLineToXml> lines) {
        this.lines = lines;
    }
}
