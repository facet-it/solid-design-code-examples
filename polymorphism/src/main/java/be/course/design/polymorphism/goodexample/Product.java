package be.course.design.polymorphism.goodexample;

public class Product {
    private final String name;
    private final String type;
    private final double price;
    
    public Product(String name, String type, double price) {
        this.name = name;
        this.type = type;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }
    
    
}
