package main.java.be.course.design.fileupload;

import java.io.File;
import java.nio.file.Paths;
import java.time.LocalDateTime;

public class FileValidationProcess {

  private static final String DATA_DIRECTORY = "/imports/data";
  private DataImportRepository dataImportRepository;
  private ValidationProcess validationProcess;

  public void validateFile(String fileName) {

    // Step 1: Get the file
    File file = Paths.get(DATA_DIRECTORY, fileName).toFile();

    // Step 2: Create the status trace
    DataImport dataImport = createModel(fileName);
    dataImportRepository.save(dataImport);

    // Step 3: Validate the actual file
    String[] nameParts = fileName.split("_");
    validationProcess.validateFile(file, nameParts[0], nameParts[1]);

    // Step 4: Update status trace

    // Step 5a: In case there are errors, track the errors

    // Step 5b: In case there are no errors, start import of file
  }

  // filename =  CompanyName_DataType.csv
  private DataImport createModel(String fileName) {
    String[] nameParts = fileName.split("_"); //split at _
    DataImport dataImport = new DataImport(nameParts[0], nameParts[1]);
    dataImport.setImportTime(LocalDateTime.now());
    dataImport.setStatus(ImportStatus.VALIDATING);
    return dataImport;
  }

}
