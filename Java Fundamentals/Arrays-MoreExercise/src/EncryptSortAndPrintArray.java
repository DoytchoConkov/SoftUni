import java.util.Scanner;

public class EncryptSortAndPrintArray {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int[] code = new int[n];
        for (int i = 0; i < n; i++) {
            String text = scan.nextLine();
            for (int j = 0; j < text.length(); j++) {
                if (text.charAt(j) == 'a' || text.charAt(j) == 'e' || text.charAt(j) == 'i' || text.charAt(j) == 'o'
                        || text.charAt(j) == 'u' || text.charAt(j) == 'A' || text.charAt(j) == 'E'
                        || text.charAt(j) == 'I' || text.charAt(j) == 'O' || text.charAt(j) == 'U') {
                    code[i] += text.charAt(j) * text.length();
                } else {
                    code[i] += text.charAt(j) / text.length();
                }
            }
        }
        for (int j = 0; j < n-1; j++) {
            for (int i = 0; i < n - 1; i++) {
                if (code[i] > code[i + 1]) {
                    int temp = code[i];
                    code[i] = code[i + 1];
                    code[i + 1] = temp;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.println(code[i]);
        }
    }
}
