package classroom;

import java.util.ArrayList;
import java.util.List;

public class Classroom {
    public List<Student> students;
    public int capacity;
    public List<Student> data;

    public Classroom(int capacity) {
        this.capacity = capacity;
        this.students = new ArrayList<>();
        this.data = new ArrayList<>();
    }

    public int getCapacity() {
        return this.capacity;
    }

    public List<Student> getStudents() {
        return this.students;
    }

    public int getStudentCount() {
        return this.data.size();
    }

    public String registerStudent(Student student) {
        boolean isThere = false;
        for (Student currentStudent : this.data) {
            if (currentStudent.getFirstName().equals(student.getFirstName()) && currentStudent.getLastName().equals(student.getLastName())&&currentStudent.getBestSubject().equals(student.getBestSubject())) {
                isThere = true;
                break;
            }
        }
        if (isThere) {
            return "Student is already in the classroom";
        }
        if (this.data.size() >= this.capacity) {
            return "No seats in the classroom";
        }
        this.data.add(student);
            this.students.add(student);


        return String.format("Added student %s %s", student.getFirstName(), student.getLastName());
    }

    public String dismissStudent(Student student) {
        boolean isThere = false;
        Student toRemove = null;
        for (Student currentStudent : this.data) {
            if (currentStudent.getFirstName().equals(student.getFirstName()) && currentStudent.getLastName().equals(student.getLastName()) && currentStudent.getBestSubject().equals(student.getBestSubject())) {
                isThere = true;
                toRemove = currentStudent;
                break;
            }
        }
        if (!isThere) {
            return "Student not found";
        }
        this.data.remove(toRemove);
        return String.format("Removed student %s %s", student.getFirstName(), student.getLastName());
    }

    public String getSubjectInfo(String subject) {
        List<Student> goodStudens = new ArrayList<>();
        for (Student currentStudent : this.data) {
            if (currentStudent.getBestSubject().equals(subject)) {
                goodStudens.add(currentStudent);
            }
        }
        if (goodStudens.size() == 0) {
            return String.format("No students enrolled for the subject");
        }
        String result = String.format("Subject: %s %nStudents:", subject);
        for (Student stud : goodStudens) {
            result += String.format("%n%s %s", stud.getFirstName(), stud.getLastName());
        }
        return result;
    }

    public Student getStudent(String firstName, String lastName) {
        Student stud = null;
        for (Student currentStudent : this.data) {
            if (currentStudent.getFirstName().equals(firstName) && currentStudent.getLastName().equals(lastName)) {
                stud = currentStudent;
                break;
            }
        }
        return stud;
    }

    public String getStatistics() {
        String result = String.format("Classroom size: %d", this.data.size());
        for (Student student : this.data) {
            result += String.format("%n==Student: First Name= %s,Last Name= %s, Best Subject= %s", student.getFirstName(), student.getLastName(), student.getBestSubject());

        }
        return result;
    }
}
