import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Train {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> train = Arrays.stream(scan.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        int maxCapacity = Integer.parseInt(scan.nextLine());
        String input = scan.nextLine();
        while (!"end".equals(input)) {
            String[] command = input.split(" ");
            if ("Add".equals(command[0])) {
                train.add(Integer.parseInt(command[1]));
            } else {
                int people = Integer.parseInt(command[0]);
                for (int i = 0; i < train.size(); i++) {
                    if (people + train.get(i) <= maxCapacity) {
                        train.set(i, train.get(i) + people);
                        break;
                    }
                }
            }
            input = scan.nextLine();
        }
        System.out.println(train.toString().replaceAll("[\\[\\],]", ""));
    }
}
