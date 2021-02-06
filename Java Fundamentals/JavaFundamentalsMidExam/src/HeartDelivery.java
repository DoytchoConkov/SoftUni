import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class HeartDelivery {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> houses = Arrays.stream(scan.nextLine().split("\\@+"))
                .map(Integer::parseInt).collect(Collectors.toList());
        int index = 0;
        int housesWithValentinesDay = 0;
        String input = scan.nextLine();
        while (!"Love!".equals(input)) {
            String[] token = input.split("\\s+");
            int jump = Integer.parseInt(token[1]);
            if (index + jump < houses.size()) {
                index = index + jump;
            } else {
                index = 0;
            }
            if (houses.get(index) > 0) {
                houses.set(index, houses.get(index) - 2);
                if (houses.get(index) == 0) {
                    System.out.printf("Place %d has Valentine's day.%n", index);
                    housesWithValentinesDay++;
                }
            } else {
                System.out.printf("Place %d already had Valentine's day.%n", index);
            }
            input = scan.nextLine();
        }
        System.out.printf("Cupid's last position was %d.%n", index);
        if (housesWithValentinesDay == houses.size()) {
            System.out.println("Mission was successful.%n");
        } else {
            System.out.printf("Cupid has failed %d places.%n", houses.size() - housesWithValentinesDay);
        }
    }
}
