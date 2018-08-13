package be.course.design.inheritance.bad;

import java.util.List;

class NVisitorDiscount extends NormalDiscount {
    private static final int WINNER = 100;
    private final int visitorNumber;

    public NVisitorDiscount(int discountPercentage, int visitorNumber) {
        super(discountPercentage);
        this.visitorNumber = visitorNumber;
    }

    @Override
    double calculatePriceWithDiscount(List<Product> products) {
        if(visitorNumber == WINNER) {
            return super.calculatePriceWithDiscount(products);
        }
        else {
            double totalPrice = 0;
            for(Product product : products) {
                totalPrice += product.getPrice();
            }
            
            return totalPrice;
        }
    } 
}
