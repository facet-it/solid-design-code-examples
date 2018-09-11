package be.course.design.srp.employee;

import java.util.ArrayList;
import java.util.List;

public class HRApplication {  
    private List<Employee> employees;
    
    public List<Employee> getEmployees() {
        employees = new ArrayList<>();
        //logic to get all the employees
        return employees;
    }
    
    public void fullReportOnHoursWorked() {
        employees.stream().forEach(employee -> System.out.println(employee.reportHours()));
    }
}
