import java.util.*;

public class averageStudentGrade {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, List<String>> students = new TreeMap<>();
        int n = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < n; i++) {
            String[] token = scan.nextLine().split("\\s+");
            students.putIfAbsent(token[0], new ArrayList<>());
            students.get(token[0]).add(token[1]);
        }
        students.entrySet().stream().forEach(e -> {
            System.out.print(e.getKey() + " -> ");
            final double[] sum = {0};
            e.getValue().stream().forEach(grade -> {
                System.out.print(grade + " ");
                sum[0] += Double.parseDouble(grade);
            });
            System.out.printf("(avg: %.2f)\n", sum[0] / e.getValue().size());
        });

    }
}
