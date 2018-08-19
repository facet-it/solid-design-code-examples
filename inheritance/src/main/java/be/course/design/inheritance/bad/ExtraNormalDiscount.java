package be.course.design.inheritance.bad;

import java.util.List;

public class ExtraNormalDiscount {
    private final int discountPercentage;
    
    ExtraNormalDiscount(int percentage) {
        this.discountPercentage = percentage;
    }
    
    double calculatePriceWithDiscount(List<Product> products) {
        double totalPrice = 0;
        int productCount = 0;
        
        for(Product product : products) {
            productCount ++;
            //on 5th product, don't add productprice as it is free
            if(productCount % 5 != 0) {
                totalPrice += product.getPrice();
            }
        }
        double discountTotal = (totalPrice / 100) * discountPercentage;
        return totalPrice - discountTotal;
    }
}
