package be.course.design.polymorphism.badexample;

import java.util.List;

/**
 * In this imaginary example, the rules for vat calculation are as following: 
 * everything is 21% vat rated, except foreign products, those are only 12% vat. 
 * Foreign services are free from vat.
 */
public class BelgianVatCalculator {
    
    private final int normalVat = 21;
    private final int foreignProductVat = 12;
    
    public double doBelgianVatCalculationsOnList(List<Product> products) {
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
