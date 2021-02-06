package Students;

public class Students {
    private String firstName;
    private String lastName;
    private Double grade;

    public Students(String firstName, String lastName, Double grade) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.grade = grade;
    }

    public Double getGrade() {
        return grade;
    }

    @Override
    public String toString(){
        return String.format("%s %s: %.2f",this.firstName,this.lastName,this.grade);
    }
}
