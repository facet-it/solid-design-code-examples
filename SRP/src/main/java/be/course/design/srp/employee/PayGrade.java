package be.course.design.srp.employee;

public enum PayGrade {
    A(11, 15), 
    B(20, 30),
    C(50, 75);
    
    private final double payPerHour;
    private final double payPerOverHour;
    
    PayGrade(double payPerHour, double payPerOverHour) {
        this.payPerHour = payPerHour;
        this.payPerOverHour = payPerOverHour;
    }
    
    double getNormalPay() {
        return payPerHour;
    }
    
    double getExtraPay() {
        return payPerOverHour;
    }
}
