import java.util.Scanner;

public class CarRace {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split(" ");
        double leftRacer = 0;
        for (int i = 0; i < input.length / 2; i++) {
            int distance = Integer.parseInt(input[i]);
            if (distance == 0) {
                leftRacer = leftRacer * 0.8;
            } else {
                leftRacer = leftRacer + distance;
            }
        }
        double rightRacer = 0;
        for (int i = input.length - 1; i >= (input.length / 2)+1 ; i--) {
            int distance = Integer.parseInt(input[i]);
            if (distance == 0) {
                rightRacer = rightRacer * 0.8;
            } else {
                rightRacer = rightRacer + distance;
            }
        }
        if (leftRacer < rightRacer) {
            System.out.printf("The winner is left with total time: %.1f", leftRacer);
        } else {
            System.out.printf("The winner is right with total time: %.1f", rightRacer);
        }
    }
}
