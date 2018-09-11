package be.course.design.srp.employee;

import java.io.File;
import java.nio.file.Paths;
import java.time.LocalDate;

public class Employee {

    private String firstname;
    private String lastname;
    private String address;
    private String jobTitle;
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
        //save to file
        File export = Paths.get("employees.txt").toFile();
        String DELIMITER = ",";
        StringBuilder entry = new StringBuilder(firstname).append(DELIMITER);
        entry.append(lastname).append(DELIMITER);
        entry.append(jobTitle).append(DELIMITER);
        entry.append(address).append(DELIMITER);
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
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
