package main.java.be.course.design.fileupload;

class ColumnHeader {

  private String columnName;
  private boolean required;

  public String getColumnName() {
    return columnName;
  }

  public void setColumnName(String columnName) {
    this.columnName = columnName;
  }

  public boolean isRequired() {
    return required;
  }

  public void setRequired(boolean required) {
    this.required = required;
  }
}
