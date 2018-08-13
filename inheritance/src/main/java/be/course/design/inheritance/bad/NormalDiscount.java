package be.course.design.inheritance.bad;

import java.util.List;

class NormalDiscount {

    private final int discountPercentage;
    
    NormalDiscount(int percentage) {
        this.discountPercentage = percentage;
    }
    
    double calculatePriceWithDiscount(List<Product> products) {
        double totalPrice = 0;
        
        for(Product product : products) {
            totalPrice += product.getPrice();
        }
        
        double discountTotal = (totalPrice / 100) * discountPercentage;
        return totalPrice - discountTotal;
    }
}
