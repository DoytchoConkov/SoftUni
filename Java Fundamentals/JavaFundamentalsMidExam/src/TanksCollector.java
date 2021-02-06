import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TanksCollector {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] temp = scan.nextLine().split(",");
        List<String> tanks = new ArrayList<>();
        for (String tank : temp) {
            tanks.add(tank.trim());
        }
        int n = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < n; i++) {
            String[] tokens = scan.nextLine().split(", ");
            switch (tokens[0]) {
                case "Add":
                    if (tanks.contains(tokens[1].trim())) {
                        System.out.println("Tank is already bought");
                    } else {
                        System.out.println("Tank successfully bought");
                        tanks.add(tokens[1]);
                    }
                    break;
                case "Remove":
                    if (tanks.contains(tokens[1].trim())) {
                        System.out.println("Tank successfully sold");
                        tanks.remove(tokens[1]);
                    } else {
                        System.out.println("Tank not found");
                    }
                    break;
                case "Remove At":
                    int index = Integer.parseInt(tokens[1]);
                    if (index >= 0 && index < tanks.size()) {
                        System.out.println("Tank successfully sold");
                        tanks.remove(index);
                    } else {
                        System.out.println("Index out of range");
                    }
                    break;
                case "Insert":
                    int indexInsert = Integer.parseInt(tokens[1]);
                    if (indexInsert >= 0 && indexInsert < tanks.size()) {
                        if (tanks.contains(tokens[2].trim())) {
                            System.out.println("Tank is already bought");
                        } else {
                            System.out.println("Tank successfully bought");
                            tanks.add(indexInsert, tokens[2]);
                        }
                    } else {
                        System.out.println("Index out of range");
                    }
                    break;
            }
        }
        System.out.println(tanks.toString().replaceAll("[\\[\\]]", ""));
    }
}
