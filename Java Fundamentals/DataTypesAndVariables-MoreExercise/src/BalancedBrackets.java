import java.util.Scanner;

public class BalancedBrackets {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int openScobe = 0;
        int closeScobe = 0;
        boolean flag1 = false;
        boolean flag2 = false;
        for (int i = 0; i < n; i++) {
            String input = scan.nextLine();
            if ("(".equals(input)) {
                if (flag1) {
                    flag2 = true;
                }
                flag1 = true;
                openScobe++;
            }
            if (")".equals(input)) {
                if (flag1 && !flag2) {
                    flag1 = false;
                }
                closeScobe++;
            }
        }
        if (openScobe == closeScobe && !flag2) {
            System.out.println("BALANCED");
        } else {
            System.out.println("UNBALANCED");
        }
    }
}
