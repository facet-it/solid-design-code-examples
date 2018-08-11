package be.course.design.polymorphism.goodexample;

import java.util.List;

public class BelgianVatCalculator implements VatCalculator{
    
    private final int normalVat = 21;
    private final int foreignProductVat = 12;

    @Override
    public double calculate(List<Product> products) {
        double endResult = 0;
        
        for(Product product : products) {
            switch(product.getType()) {
                case "domestic": 
                    endResult += calculateVat(product, normalVat);
                    break;
                case "foreign": 
                    endResult += calculateVat(product, foreignProductVat);
                    break;
                case "foreign service": 
                    endResult += calculateVat(product, 0);
                    break;
                default:
                    endResult += calculateVat(product, normalVat);
            }
        }
        
        return endResult;
    }
   
    private double calculateVat(Product product, int rate) {
        return (product.getPrice() / 100) * rate;
    } 
}
