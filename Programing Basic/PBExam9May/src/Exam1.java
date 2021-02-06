import java.util.Scanner;

public class Exam1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int students = Integer.parseInt(scan.nextLine());
        int problems = Integer.parseInt(scan.nextLine());
        double submisions = students * Math.ceil(problems * 2.8);
        int extraSubmisions = students * (problems / 3);
        double totalSubmision = submisions + extraSubmisions;
        double needMemory = 5 * Math.ceil(totalSubmision / 10.0);
        System.out.printf("%.0fKB needed%n", needMemory);
        System.out.printf("%.0f submisions", totalSubmision);
    }
}
