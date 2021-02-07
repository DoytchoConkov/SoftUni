package SalaryIncrease;

import java.text.DecimalFormat;

public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private double salary;

    public Person(String firstName, String lastName, int age, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.salary = salary;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public int getAge() {
        return this.age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return String.format("%s %s gets %.2f leva",this.firstName,this.lastName,this.salary);
    }

    public void increaseSalary(double bonus) {
        if(this.age<30){
            this.salary=this.salary*(100+bonus/2)/100;
        }else{
            this.salary=this.salary*(100+bonus)/100;
        }
    }
}

