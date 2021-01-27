import java.util.Scanner;

public class E01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int currentNumber = 1;
        for (int rows = 0; rows < n; rows++) {
            for (int colums = 0; colums < rows + 1; colums++) {
                System.out.print(currentNumber + " ");
                currentNumber++;
                if (currentNumber > n) {
                    break;
                }
            }
            System.out.println();
            if (currentNumber > n) {
                break;
            }
        }

    }
}
