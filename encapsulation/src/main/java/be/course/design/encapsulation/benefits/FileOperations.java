package be.course.design.encapsulation.benefits;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileOperations {

    public Path copyFile(Path source, Path destination) {
        File fileToCopy = source.toFile();
        File copiedFile = Paths.get(destination.toString(), fileToCopy.getName()).toFile();

        try (FileInputStream fis = new FileInputStream(fileToCopy);
             FileOutputStream fos = new FileOutputStream(copiedFile)) {

            int read;
            byte[] buffer = new byte[1024];

            while ((read = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, read);
            }
            return Paths.get(copiedFile.toString());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
