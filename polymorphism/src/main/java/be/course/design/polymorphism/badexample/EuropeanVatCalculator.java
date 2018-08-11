package be.course.design.polymorphism.badexample;

import java.util.List;

/**
 * In this imaginary example the rules for vat calculation are as following: 
 * evertything is 21% vat, except for non-european services, those are 12%. If
 * all of the products are foreign services, then the vat is 5% for the entire
 * product list
 */
public class EuropeanVatCalculator {
    
    private final int normalVat = 21;
    private final int foreignServices = 12;
    private final int allForeignServices = 5;

    public double doCalculations(List<Product> products, boolean isAllForeignServices) {
        double endResult = 0;
        
        if(isAllForeignServices) {
            double totalPrice = 0;
            for(Product product : products) {
                totalPrice += product.getPrice();
            }
            
            endResult = (totalPrice / 100) * allForeignServices;
        }
        else {
            for (Product product : products) {
                switch (product.getType()) {
                    case "foreign service":
                        endResult += calculateVat(product, foreignServices);
                        break;
                    default:
                        endResult += calculateVat(product, normalVat);
                }
            }
        }
        return endResult;
    }
    
    private double calculateVat(Product product, int rate) {
        return (product.getPrice() / 100) * rate;
    }
}
