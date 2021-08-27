package main.java.be.course.design.fileupload;

public class ValidationError {

  private String error;
  private long lineNumber;

  public String getError() {
    return error;
  }

  public void setError(String error) {
    this.error = error;
  }

  public long getLineNumber() {
    return lineNumber;
  }

  public void setLineNumber(long lineNumber) {
    this.lineNumber = lineNumber;
  }
}
