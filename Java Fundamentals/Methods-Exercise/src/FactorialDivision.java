import java.util.Scanner;

public class FactorialDivision {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double n1 = Integer.parseInt(scan.nextLine());
        double n2 = Integer.parseInt(scan.nextLine());
        double firstFactoriel = factoriel(n1);
        double secondFactoriel = factoriel(n2);
        System.out.printf("%.2f", firstFactoriel / secondFactoriel);
    }

    private static double factoriel(double n) {
        double factoriel = n;
        for (int i = 1; i < n; i++) {
            factoriel *= i;
        }
        return factoriel;
    }
}
