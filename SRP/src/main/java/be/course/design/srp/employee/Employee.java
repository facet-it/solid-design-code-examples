package be.course.design.srp.employee;

import java.time.LocalDate;

public class Employee {

    private String firstname;
    private String lastname;
    private int hoursWorkedThisWeek;
    private int hoursWorkedThisMonth;
    private final PayGrade paygrade;

    public Employee(PayGrade paygrade) {
        this.paygrade = paygrade;
    }

    public double calculatePay() {
        int dayOfMonth = LocalDate.now().getDayOfMonth();
        int monthOverHours = hoursWorkedThisMonth - (dayOfMonth * 8);
        
        int regularMontlyHours = hoursWorkedThisMonth - (monthOverHours < 0 ? 0 : monthOverHours);
        return regularMontlyHours * paygrade.getNormalPay() + 
                (monthOverHours < 0 ? 0 : monthOverHours) * paygrade.getExtraPay();
    }

    public void saveEmployee() {

    }

    public String reportHours() {
        int dayOfWeek = LocalDate.now().getDayOfWeek().getValue();
        int dayOfMonth = LocalDate.now().getDayOfMonth();

        int weekOverHours = hoursWorkedThisWeek - (dayOfWeek * 8);
        int monthOverHours = hoursWorkedThisMonth - (dayOfMonth * 8);

        StringBuilder hoursReport = new StringBuilder("Hours Report").append("\n");
        hoursReport.append("Hours this week: " + hoursWorkedThisWeek).append("\n");
        hoursReport.append("from which are extra hours: ").
                append((weekOverHours < 0 ? 0 : weekOverHours)).append("\n");
        hoursReport.append(" -------------").append("\n");
        hoursReport.append("Hours this month: ").
                append(hoursWorkedThisMonth).append("\n");
        hoursReport.append("from which are extra hours: ").
                append((monthOverHours < 0 ? 0 : monthOverHours)).append("\n");
        return hoursReport.toString();
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getHoursWorkedThisWeek() {
        return hoursWorkedThisWeek;
    }

    public void setHoursWorkedThisWeek(int hoursWorkedThisWeek) {
        this.hoursWorkedThisWeek = hoursWorkedThisWeek;
    }

    public int getHoursWorkedThisMonth() {
        return hoursWorkedThisMonth;
    }

    public void setHoursWorkedThisMonth(int hoursWorkedThisMonth) {
        this.hoursWorkedThisMonth = hoursWorkedThisMonth;
    }

}
