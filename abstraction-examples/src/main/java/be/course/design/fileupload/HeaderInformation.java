package main.java.be.course.design.fileupload;

import java.util.LinkedList;
import java.util.List;

public class HeaderInformation {

  private List<ColumnHeader> fileHeader = new LinkedList<>();

  public List<ColumnHeader> getHeaderInformation(String company, String dataType) {
    return fileHeader;
  }

}
