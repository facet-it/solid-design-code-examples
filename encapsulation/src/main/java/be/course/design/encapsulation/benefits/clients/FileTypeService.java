package be.course.design.encapsulation.benefits.clients;

import java.nio.file.Path;
import java.nio.file.Paths;

import be.course.design.encapsulation.benefits.FileValidatorService;
import be.course.design.encapsulation.benefits.DataFileType;

/**
 * The problem with this class is the dependency on the FileValidatorService. The FileValidatorService has all of its
 * methods public. This is an open invitation to other developers to use these methods. The problem is that this class
 * uses a method from another class for a totally different purpose. The method used is actually build for the process
 * of validating a data file. So if anything changes to that process, chances are that this will have to change as well.
 *
 * This is what we mean with ripple effect of changes. You have a change in one place, and it ripples throughout other classes.
 */
public class FileTypeService {

    private static final String HEADER_BASE_PATH = "/headers";
    private FileValidatorService fileValidatorService;


    public FileTypeService(FileValidatorService fileValidatorService) {
        this.fileValidatorService = fileValidatorService;
    }

    public Path getFullHeaderPath(String dataFileName) {
        Path datafileAsPath = Paths.get(dataFileName);
        DataFileType type = fileValidatorService.determineType(datafileAsPath);

        return Paths.get(HEADER_BASE_PATH, type.getHeaderFileName());
    }

}
