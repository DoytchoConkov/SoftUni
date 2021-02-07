import java.util.ArrayDeque;
import java.util.Scanner;

public class printerQueue {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayDeque<String> printer = new ArrayDeque<>();
        String input = scan.nextLine();
        while (!input.equals("print")) {
            if (input.equals("cancel")) {
                if (printer.size() < 1) {
                    System.out.println("Printer is on standby");
                } else {
                    System.out.printf("Canceled %s%n", printer.poll());
                }
            } else {
                printer.offer(input);
            }
            input = scan.nextLine();
        }
        while (!printer.isEmpty()){
            System.out.println(printer.poll());
        }
    }
}
