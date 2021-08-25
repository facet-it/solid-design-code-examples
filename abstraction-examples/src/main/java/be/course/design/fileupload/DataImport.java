package main.java.be.course.design.fileupload;

import java.time.LocalDateTime;

public class DataImport {

  private String company;
  private String fileType;
  private ImportStatus status;
  private LocalDateTime importTime;

  public DataImport(String company, String fileType) {
    this.fileType = fileType;
    this.company = company;
  }

  public String getCompany() {
    return company;
  }

  public String getFileType() {
    return fileType;
  }

  public ImportStatus getStatus() {
    return status;
  }

  public LocalDateTime getImportTime() {
    return importTime;
  }

  public void setStatus(ImportStatus status) {
    this.status = status;
  }

  public void setImportTime(LocalDateTime importTime) {
    this.importTime = importTime;
  }
}
