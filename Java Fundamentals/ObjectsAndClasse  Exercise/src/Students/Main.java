package Students;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        List<Students> students = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] token = scan.nextLine().split("\\s+");
            Students student = new Students(token[0], token[1], Double.parseDouble(token[2]));
            students.add(student);
        }
        students.stream()
                .sorted((p1,p2)-> p2.getGrade().compareTo(p1.getGrade()))
                .forEach(p -> System.out.println(p));
    }
}
