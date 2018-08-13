package be.course.design.inheritance.bad;

import java.util.List;

class Checkout {
    
    void doCheckout(List<Product> products, NormalDiscount discount) {
        double afterDiscount = discount.calculatePriceWithDiscount(products);
        System.out.println("The total amount to pay: " + afterDiscount);
    }
}
