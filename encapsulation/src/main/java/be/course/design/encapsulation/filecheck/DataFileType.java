package be.course.design.encapsulation.filecheck;

public enum DataFileType {
    SALES("sales.txt"),
    CUSTOMERS("customers.txt"),
    PRODUCTS("products.txt");

    private String headerFileName;

    private DataFileType(String headerfileName) {
        this.headerFileName = headerfileName;
    }

    public String getHeaderFileName() {
        return this.headerFileName;
    }
}
