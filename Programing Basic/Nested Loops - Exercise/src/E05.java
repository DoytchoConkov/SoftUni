import java.util.Scanner;

public class E05 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int l = Integer.parseInt(scan.nextLine());
        String password = "";
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                for (int k = 'a'; k < 'a' + l; k++) {
                    for (int m = 'a'; m < 'a' + l; m++) {
                        int max = 0;
                        if (i > j) {
                            max = i;
                        } else {
                            max = j;
                        }
                        for (int o = max + 1; o <= n; o++) {
                            System.out.printf("%d%d%c%c%d ", i, j, k, m, o);
                        }
                    }
                }
            }
        }
    }
}
