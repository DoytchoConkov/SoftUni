import java.util.Scanner;

public class TribonacciSequence {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        printTribonacciSequence(num);
    }

    private static void printTribonacciSequence(int num) {
        int[] numbers = new int[num];
        if (num >= 3) {
            
            numbers[0] = 1;
            numbers[1] = 1;
            numbers[2] = 2;
            for (int i = 3; i < num; i++) {
                numbers[i] = numbers[i - 3] + numbers[i - 2] + numbers[i - 1];
            }
            for (int number : numbers) {
                System.out.print(number + " ");
            }
        }
        switch (num){
            case 0:
            System.out.println("");break;
            case 1: System.out.println("1");break;
            case 2: System.out.println("1 1");break;
        }
    }
}
