import java.util.Scanner;

public class E02 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double number = Double.parseDouble(scan.nextLine());
        double bonus =0;

        if (number%2==0) {bonus=1;}
        if (number%10==5) {bonus=2;}
        if (number <= 100) {
            bonus = bonus + 5;
        } else if (number <= 1000) {
            bonus = bonus+number * 0.2;
        } else {
            bonus = bonus+ number * 0.1;
        }
        System.out.println(bonus);
        System.out.println(bonus+number);
    }
}
