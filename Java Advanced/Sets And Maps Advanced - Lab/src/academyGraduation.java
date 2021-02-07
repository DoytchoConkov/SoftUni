import java.util.*;

public class academyGraduation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        Map<String, List<Double>> students = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            String student = scan.nextLine();
            double[] scores = Arrays.stream(scan.nextLine().split("\\s+")).mapToDouble(e -> Double.parseDouble(e)).toArray();
            students.putIfAbsent(student, new ArrayList<>());
            for (Double score : scores) {
                students.get(student).add(score);
            }
        }

        students.entrySet().stream().forEach(e -> {
            final double[] avr = {0};
            e.getValue().stream().forEach(s -> avr[0] += s);
            System.out.printf("%s is graduated with %f %n", e.getKey(), avr[0] / e.getValue().size());
        });
    }
}
