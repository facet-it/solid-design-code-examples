package main.java.be.course.design.fileupload;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ValueInformation {

  private Map<String, List<String>> valueInformation = new HashMap<>();

  public Map<String, List<String>> getValueInformation(String company, String dataType) {
    return valueInformation;
  }

}
