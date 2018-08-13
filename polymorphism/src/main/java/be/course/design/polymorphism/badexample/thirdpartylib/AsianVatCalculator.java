package be.course.design.polymorphism.badexample.thirdpartylib;

import be.course.design.polymorphism.badexample.Product;
import java.util.List;

public class AsianVatCalculator {
    
    public double calculateTaxes(List<Product> products, String originCountry) {
        //some complex calculation logic based on the country of origin
        return 0;
    }
}
