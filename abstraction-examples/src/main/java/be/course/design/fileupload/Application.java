package main.java.be.course.design.fileupload;

public class Application {

  public static void main(String[] args) {
    FileValidationProcess process = new FileValidationProcess();
    process.validateFile("somefile");
  }

}
