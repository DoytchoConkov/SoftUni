package Google;

public class Company {
    private String companyName;
    private String companyDepartment;
    private double salary;

    public Company(String companyName, String companyDepartment, double salary) {
        this.companyName = companyName;
        this.companyDepartment = companyDepartment;
        this.salary = salary;
    }

    public Company() {
        this.companyName="";
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getCompanyDepartment() {
        return companyDepartment;
    }

    public double getSalary() {
        return salary;
    }
}
