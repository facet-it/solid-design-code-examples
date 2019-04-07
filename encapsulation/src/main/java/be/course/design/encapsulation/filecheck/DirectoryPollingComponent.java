package be.course.design.encapsulation.filecheck;


import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * This is the polling component. This polls the to process directory every 5 seconds to check
 * if there is a new file that needs to be validated.
 *
 * For this time being, if there is a file in the process of being validated, the polling component
 * does stops polling until the file is done.
 *
 * Process of deciding what needs to be in this polling component:
 * Question: what does it need to do? Find that out and make sure it only does that task
 *
 * Answer: this needs to poll a certain directory which we call the toProcess directory for
 * new files. If there is a file, stop polling, move file to processing directly and poke the
 * validation component.
 *
 * So what data do we need? And what behaviour do we need? Try to limit the public api as much as
 * possible and try to limit the amount of parameters given.
 *
 * Data:
 * the interval in seconds
 * the directory to check
 * the file checker to poke.
 *
 * The Encapsulation mindset: I want to be able to turn this component on and off and I know what it
 * is doing. So the best encapsulation would be to create a directorypolling component, and just have to
 * 'switch it on'.
 */
public class DirectoryPollingComponent {

    private int intervalInMillis = 3000;
    private Path toProcessDirectory;
    private FileValidation validationComponent;


    /**
     * The constructor should provide the parameters that we might want to change when we 'create a new instance'
     * of this class. I think of this class as a reusable component. Reusable in the context of this program, as in,
     * there might be other directories we want to poll.
     *
     * We have an immediate hard decision to make here: what if the directory does not exist? Are we really going to
     * throw exceptions in a constructor? We decide to validate this before it is passed to the constuctor.
     * @param toProcessDirectory
     */
    public DirectoryPollingComponent(String toProcessDirectory) {
        this.toProcessDirectory = Paths.get(toProcessDirectory);
    }

    public void start() {
        System.out.println("start polling on directory " + toProcessDirectory.toAbsolutePath().toString());
        while(true) {
            File[] filesInDirectory = toProcessDirectory.toFile().listFiles();
            if(filesInDirectory.length == 0) {
                try {
                    Thread.sleep(intervalInMillis);
                }
                catch(InterruptedException ie) {
                    System.out.println("Thread got interrupted.");
                }
            }
            else {
                int amountOfFiles = filesInDirectory.length;
                while(amountOfFiles != 0) {
                    System.out.println(filesInDirectory[0].getAbsolutePath());
                    validationComponent.validateFile(DataFileType.SALES, Paths.get(filesInDirectory[0].getAbsolutePath()));
                }
            }
        }
    }


}
