import java.util.*;

public class StudentAcademy {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, List<Double>> students = new LinkedHashMap<>();
        int n = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < n; i++) {
            String name = scan.nextLine();
            double grade = Double.parseDouble(scan.nextLine());
            students.putIfAbsent(name, new ArrayList<>());
            List<Double> newList = students.get(name);
            newList.add(grade);
            students.put(name, newList);
        }
        Map<String, Double> averege = new LinkedHashMap<>();
        for (Map.Entry<String, List<Double>> student : students.entrySet()) {
            double averageGrade = student.getValue().stream().mapToDouble(x -> x).average().getAsDouble();
            if (averageGrade >= 4.50) {
                averege.put(student.getKey(), averageGrade);
            }
        }
        averege.entrySet().stream().sorted((g1, g2) -> g2.getValue().compareTo(g1.getValue())).forEach(grade -> {
            System.out.printf("%s -> %.2f%n", grade.getKey(), grade.getValue());
        });
    }
}
