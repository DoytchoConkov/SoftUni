import java.util.Scanner;

public class ChangeBureau {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int bitcoins = Integer.parseInt(scan.nextLine());
        double chinaUans = Double.parseDouble(scan.nextLine());
        double commission = Double.parseDouble(scan.nextLine());
        double chinaUansInDolars = chinaUans * 0.15;
        double sumInLevs = bitcoins * 1168 + chinaUansInDolars * 1.76;
        double sumInEuro = sumInLevs / 1.95;
        sumInEuro = sumInEuro * (100 - commission) / 100;
        System.out.printf("%.2f", sumInEuro);
    }
}
