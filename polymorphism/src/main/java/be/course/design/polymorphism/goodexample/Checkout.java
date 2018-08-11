package be.course.design.polymorphism.goodexample;

import java.util.List;

/**
 * This is the client, the user of the VAT calculations. As you can see, in the 
 * signature of the method, we expect an object of the type VatCalculator. This client
 * is confident that there will be a method calculate() which needs a List of
 * products on the VatCalculator object, because it is so defined by contract, 
 * which is represented by the interface 'VatCalculator'. 
 * 
 * This is great, because this Checkout class is only interested in result. It
 * does not want to know about the different ways of doing VAT calculations. More
 * so, if there all of a sudden is a new market with its own rules, this class or 
 * client does not even have to change in order to use new functionality.
 */
class Checkout {
    
    void doCheckout(List<Product> products, VatCalculator vatCalculator) {
        double totalPrice = 0;
        
        for(Product product : products) {
            totalPrice += product.getPrice();
        }
        
        double totalVat = vatCalculator.calculate(products);
        
        System.out.println("Total price: " + totalPrice);
        System.out.println("Total VAT: " + totalVat);
    }
}
