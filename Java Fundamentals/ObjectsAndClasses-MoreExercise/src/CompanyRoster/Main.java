package CompanyRoster;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        List<Employer> employers = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] tokens = scan.nextLine().split("\\s+");

            if (tokens.length == 6) {
                Employer employer =
                        new Employer(tokens[0], Double.parseDouble(tokens[1]),
                                tokens[2], tokens[3], tokens[4], Integer.parseInt(tokens[5]));
                employers.add(employer);
            } else if (tokens.length == 4) {
                Employer employer =
                        new Employer(tokens[0], Double.parseDouble(tokens[1]),
                                tokens[2], tokens[3], "n/a", -1);
                employers.add(employer);
            } else {
                if (tokens[4].contains("@")) {
                    Employer employer =
                            new Employer(tokens[0], Double.parseDouble(tokens[1]),
                                    tokens[2], tokens[3], tokens[4], -1);
                    employers.add(employer);
                } else {
                    Employer employer =
                            new Employer(tokens[0], Double.parseDouble(tokens[1]),
                                    tokens[2], tokens[3], "n/a", Integer.parseInt(tokens[4]));
                    employers.add(employer);
                }
            }
        }

        double maxAvrSalary = 0;
        String maxDepertment = "";
        for (int i = 0; i < employers.size() - 1; i++) {
            int cnt = 0;
            double sum = 0;
            for (int j = 0; j < employers.size(); j++) {
                if (employers.get(i).getDepartment().equals(employers.get(j).getDepartment())) {
                    sum += employers.get(j).getSalary();
                    cnt++;
                }
            }
            if (sum / cnt > maxAvrSalary) {
                maxAvrSalary = sum / cnt;
                maxDepertment = employers.get(i).getDepartment();
            }
        }
        List<Employer> department = new ArrayList<>();
        for (Employer employer : employers) {
            if (employer.getDepartment().equals(maxDepertment)) {
                department.add(employer);
            }
        }
        department.sort(Comparator.comparingDouble(Employer::getSalary).reversed());
        System.out.printf("Highest Average Salary: %s%n", maxDepertment);
        for (Employer employer : department) {
            System.out.printf("%s %.2f %s %d%n", employer.getName(), employer.getSalary(), employer.getEmail(), employer.getAge());
        }
    }
}
