import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;

public class periodicTable {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        TreeSet<String> periodicTable = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            String[] chemicalElements = scan.nextLine().split("\\s+");
            Arrays.stream(chemicalElements).forEach(e -> periodicTable.add(e));
        }
        periodicTable.stream().forEach(e -> System.out.print(e + " "));
    }
}
