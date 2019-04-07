package be.course.design.encapsulation.filecheck;

import java.nio.file.Path;
import java.util.List;

public interface FileValidation {

    List<String> validateFile(DataFileType type, Path dataFileToValidate);

}
