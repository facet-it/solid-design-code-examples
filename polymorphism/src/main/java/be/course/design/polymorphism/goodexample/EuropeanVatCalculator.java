package be.course.design.polymorphism.goodexample;

import java.util.List;

/**
 * In this imaginary example the rules for vat calculation are as following: 
 * evertything is 21% vat, except for non-european services, those are 12%. If
 * all of the products are foreign services, then the vat is 5% for the entire
 * product list
 */
public class EuropeanVatCalculator implements VatCalculator {
    
    private final int normalVat = 21;
    private final int foreignServices = 12;
    private final int allForeignServices = 5;

    @Override
    public double calculate(List<Product> products) {
        double endResult = 0;
        int foreignServicesCount = 0;
        double totalPrice = 0;
        
        for(Product product : products) {
            switch(product.getType()) {
                case "foreign service": 
                    endResult += calculateVat(product, foreignServices);
                    totalPrice += product.getPrice();
                    foreignServicesCount ++;
                    break;
                default:
                    endResult += calculateVat(product, normalVat);
                    totalPrice += product.getPrice();
            }
        }
        
        if(foreignServicesCount == products.size()) {
            return (totalPrice / 100) * allForeignServices;
        }
        else {
            return endResult;
        }
    }
    
    private double calculateVat(Product product, int rate) {
        return (product.getPrice() / 100) * rate;
    }
}
