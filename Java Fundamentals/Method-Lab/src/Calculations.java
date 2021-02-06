import java.util.Scanner;

public class Calculations {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String comand = scan.nextLine();
        int number1 = Integer.parseInt(scan.nextLine());
        int number2 = Integer.parseInt(scan.nextLine());
        switch (comand) {
            case "add":
                addNumbers(number1, number2);
                break;
            case "multiply":
                multiplyNumbers(number1, number2);
                break;
            case "subtract":
                subtractNumbers(number1, number2);
                break;
            case "divide":
                divideNumbers(number1, number2);
                break;
        }

    }

    public static void addNumbers(int n1, int n2) {
        System.out.println(n1 + n2);
    }

    public static void multiplyNumbers(int n1, int n2) {
        System.out.println(n1 * n2);
    }

    public static void subtractNumbers(int n1, int n2) {
        System.out.println(n1 - n2);
    }

    public static void divideNumbers(int n1, int n2) {
        System.out.println(n1 / n2);
    }
}