package main.java.be.course.design.fileupload;

import java.io.File;
import java.util.List;
import java.util.Map;

public class FileValidation {

  private HeaderInformation headerInformation;
  private ValueInformation valueInformation;
  private LineValidation lineValidation;

  public List<ValidationError> validateFile(File fileToValidate,
                                            String company,
                                            String datatype) {

    //Step 1: Fetch the header information
    List<ColumnHeader> header = headerInformation
        .getHeaderInformation(company, datatype);

    //Step 2: Fetch the value information
    Map<String, List<String>> values = valueInformation
        .getValueInformation(company, datatype);

    //Step 3: Start validating a file line by line
    List<ValidationError> validationErrors = lineValidation
        .validate(fileToValidate, header, values);

    return validationErrors;
  }

}
