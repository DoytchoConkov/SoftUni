package FirstAndReserveTeam;

public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private double salary;
    private String team;

    public Person(String firstName, String lastName, int age, double salary) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setAge(age);
        this.setSalary(salary);
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public void setFirstName(String firstName) {
        if (firstName.trim().length() < 3) {
            throw new IllegalArgumentException("First name cannot be less than 3 symbols");
        }
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        if (lastName.trim().length() < 3) {
            throw new IllegalArgumentException("LAst name cannot be less than 3 symbols");
        }
        this.lastName = lastName;
    }

    public void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be zero or negative integer");
        }
        this.age = age;
    }

    public double getSalary() {

        return salary;
    }

    public void setSalary(double salary) {
        if (salary < 460) {
            throw new IllegalArgumentException("Salary cannot be less than 460 leva");
        }
        this.salary = salary;
    }

    @Override
    public String toString() {
        return String.format("%s %s gets %.2f leva", this.firstName, this.lastName, this.salary);
    }

    public void increaseSalary(double bonus) {
        if (this.age <= 30) {
            this.salary = this.salary * (100 + bonus / 2) / 100;
        } else {
            this.salary = this.salary * (100 + bonus) / 100;
        }
    }

    public int getAge() {
        return this.age;
    }
}


