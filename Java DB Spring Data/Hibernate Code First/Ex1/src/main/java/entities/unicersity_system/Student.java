package entities.unicersity_system;

import entities.BaseEntity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table (name="students")
public class Student extends BaseEntity {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private double averageGrade;
    private boolean attendance;
    private Set<Course> courses;

    public Student() {
    }
    @ManyToMany
    @JoinTable(name = "students_couses",
            joinColumns = @JoinColumn(name="student_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name="course_id", referencedColumnName="id"))
    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    @Column(name="first_name", nullable = false)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    @Column(name="lsst_name", nullable = false)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    @Column(name="phone_number")
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    @Column(name="average_grade")
    public double getAverageGrade() {
        return averageGrade;
    }

    public void setAverageGrade(double averageGrade) {
        this.averageGrade = averageGrade;
    }
    @Column(name="attendance")
    public boolean isAttendance() {
        return attendance;
    }

    public void setAttendance(boolean attendance) {
        this.attendance = attendance;
    }
}
