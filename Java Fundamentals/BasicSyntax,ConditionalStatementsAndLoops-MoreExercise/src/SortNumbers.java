import java.util.Scanner;

public class SortNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int number1 = Integer.parseInt(scan.nextLine());
        int number2 = Integer.parseInt(scan.nextLine());
        int number3 = Integer.parseInt(scan.nextLine());
        int bigges = 0;
        int lowwest = 0;
        int middle = 0;
        if (number1 > number2) {
            if (number1 > number3) {
                bigges = number1;
                if (number2 > number3) {
                    middle = number2;
                    lowwest = number3;
                } else {
                    middle = number3;
                    lowwest = number2;
                }
            } else {
                bigges = number3;
                middle = number1;
                lowwest = number2;
            }
        } else {
            if (number2 > number3) {
                bigges = number2;
                if (number1 > number3) {
                    middle = number1;
                    lowwest = number3;
                } else {
                    middle = number3;
                    lowwest = number1;
                }
            } else {
                bigges = number3;
                middle = number2;
                lowwest = number1;
            }
        }
        System.out.println(bigges);
        System.out.println(middle);
        System.out.println(lowwest);
    }
}