import java.util.Scanner;

public class PrintPartOfASCIITable {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int startSymbol = Integer.parseInt(scan.nextLine());
        int endSymbol = Integer.parseInt(scan.nextLine());
        for (int i = startSymbol; i <= endSymbol; i++) {
            System.out.printf("%c ", i);
        }
    }
}
