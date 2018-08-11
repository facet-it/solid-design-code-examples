/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.course.design.polymorphism.goodexample;

import java.util.List;

/**
 * This interface will act as the contract between implementations and clients. On 
 * the implementation side, the contract will be fullfilled by providing an 
 * implementation for the method "calculate()" which needs a list of products. The
 * clientside can be sure that when dealing with an object of type "VatCalculator", 
 * there will be a method "calculate()" that needs a list of products.
 */
public interface VatCalculator {
    
    double calculate(List<Product> products);
    
}
