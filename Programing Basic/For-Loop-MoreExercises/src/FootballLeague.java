import java.util.Scanner;

public class FootballLeague {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int capacity = Integer.parseInt(scan.nextLine());
        int fens = Integer.parseInt(scan.nextLine());
        int fansA = 0;
        int fansB = 0;
        int fansV = 0;
        int fansG = 0;
        for (int i = 0; i < fens; i++) {
            String sector = scan.nextLine();
            switch (sector) {
                case "A":
                    fansA++;
                    break;
                case "B":
                    fansB++;
                    break;
                case "G":
                    fansG++;
                    break;
                case "V":
                    fansV++;
                    break;
            }
        }

        System.out.printf("%.2f%%%n", 100.0 * fansA / fens);
        System.out.printf("%.2f%%%n", 100.0 * fansB / fens);
        System.out.printf("%.2f%%%n", 100.0 * fansV / fens);
        System.out.printf("%.2f%%%n", 100.0 * fansG / fens);
        System.out.printf("%.2f%%", 100.0 * fens / capacity);
    }
}
