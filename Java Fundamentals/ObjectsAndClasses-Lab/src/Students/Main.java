package Students;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Students> students = new ArrayList<>();
        String input = scan.nextLine();
        while (!"end".equals(input)) {
            String[] token = input.split("\\s+");
            Students student = new Students();
            if (!studentexist(students, token[0], token[1], token[2], token[3])) {
                student.setFirstName(token[0]);
                student.setLastName(token[1]);
                student.setAge(Integer.parseInt(token[2]));
                student.setHometown(token[3]);
                students.add(student);
            }
            input = scan.nextLine();
        }
        String town = scan.nextLine();
        for (Students students1 : students) {
            if (students1.getHometown().equals(town)) {
                System.out.printf("%s %s is %d years old%n", students1.getFirstName(), students1.getLastName(), students1.getAge());
            }
        }
    }

    private static boolean studentexist(List<Students> students, String firstName, String lastName, String age, String hometown) {

        for (Students temp : students) {
            if (temp.getFirstName().equals(firstName) && temp.getLastName().equals(lastName)) {
                temp.setAge(Integer.parseInt(age));
                temp.setHometown(hometown);
                return true;
            }
        }
        return false;
    }
}
