package be.course.design.srp.employee;

import java.util.ArrayList;
import java.util.List;

public class AccountingApplication {
    private List<Employee> employees;
    private List<Object> otherCosts;
    
    public List<Employee> getEmployees() {
        employees = new ArrayList<>();
        //logic to get all the employees
        return employees;
    }
    
    public double totalCostOfEmployees() {
        double totalCostEmployees  = 0;
        for(Employee employee : employees) {
            totalCostEmployees += employee.calculatePay();
        }
        
        return totalCostEmployees;
    }
}
