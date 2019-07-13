package be.course.design.encapsulation.benefits;

public enum DataFileType {
    SALES("sales.txt", "sales"),
    CUSTOMERS("customers.txt", "customers"),
    PRODUCTS("products.txt", "products");

    private String headerFileName;
    private String translationDirectoryName;

    DataFileType(String headerfileName, String translationDirectoryName) {
        this.headerFileName = headerfileName;
        this.translationDirectoryName = translationDirectoryName;
    }

    public String getHeaderFileName() {
        return this.headerFileName;
    }

    public String getTranslationDirectoryName() {
        return this.translationDirectoryName;
    }
}
