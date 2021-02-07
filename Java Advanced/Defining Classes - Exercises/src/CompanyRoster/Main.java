package CompanyRoster;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        Employee employee;
        Map<String, Department> departments = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String[] token = scan.nextLine().split("\\s+");
            if (token.length == 4) {
                employee = new Employee(token[0], Double.parseDouble(token[1]), token[2], token[3], "n/a", -1);
            } else if (token.length == 6) {
                employee = new Employee(token[0], Double.parseDouble(token[1]), token[2], token[3], token[4], Integer.parseInt(token[5]));
            } else {
                if (token[4].contains("@")) {
                    employee = new Employee(token[0], Double.parseDouble(token[1]), token[2], token[3], token[4], -1);
                } else {
                    employee = new Employee(token[0], Double.parseDouble(token[1]), token[2], token[3], "n/a", Integer.parseInt(token[4]));
                }
            }
            departments.putIfAbsent(token[3], new Department(token[3]));
            departments.get(token[3]).getEmployees().add(employee);
        }
        Department maxAverageSalary = departments.entrySet().stream().max(Comparator.comparingDouble(e -> e.getValue().getAverageSalary())).get().getValue();
        System.out.printf("Highest Average Salary: %s%n", maxAverageSalary.getEmployees().get(0).getDepartment());
        maxAverageSalary.getEmployees().stream().sorted((a, b) -> Double.compare(b.getSalary(), a.getSalary()))
                .forEach(e -> {
                    System.out.println(e.toString());
                });
    }
}
