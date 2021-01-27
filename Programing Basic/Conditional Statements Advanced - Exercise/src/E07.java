import java.util.Scanner;

public class E07 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n1 = Integer.parseInt(scan.nextLine());
        int n2 = Integer.parseInt(scan.nextLine());
        String operator = scan.nextLine();
        int result = 0;
        String cetno = "odd";
        switch (operator) {
            case "+":
                result = n1 + n2;
                if (result % 2 == 0) {
                    cetno = "even";
                }
                System.out.printf("%d %s %d = %d – %s", n1, operator, n2, result, cetno);
                break;
            case "-":
                result = n1 - n2;
                if (result % 2 == 0) {
                    cetno = "even";
                }
                System.out.printf("%d %s %d = %d – %s", n1, operator, n2, result, cetno);
                break;
            case "*":
                result = n1 * n2;
                if (result % 2 == 0) {
                    cetno = "even";
                }
                System.out.printf("%d %s %d = %d – %s", n1, operator, n2, result, cetno);
                break;
            case "/":
                if(n2==0){
                    System.out.printf("Cannot divide %d by zero", n1);
                }else {
                    System.out.printf("%d / %d = %.2f", n1, n2, 1.0 * n1 / n2);
                }
                break;
            case "%":
                if(n2==0){
                    System.out.printf("Cannot divide %d by zero", n1);
                }else {
                    System.out.printf("%d %% %d = %d", n1, n2, n1 % n2);
                }
                break;
        }

    }
}
