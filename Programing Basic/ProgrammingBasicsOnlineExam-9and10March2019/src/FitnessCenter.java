import java.util.Scanner;

public class FitnessCenter {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int back = 0;
        int chest = 0;
        int legs = 0;
        int abs = 0;
        int proteinShake = 0;
        int proteinBar = 0;
        int visitors = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < visitors; i++) {
            String type = scan.nextLine();
            switch (type) {
                case "Back":
                    back++;
                    break;
                case "Chest":
                    chest++;
                    break;
                case "Legs":
                    legs++;
                    break;
                case "Abs":
                    abs++;
                    break;
                case "Protein shake":
                    proteinShake++;
                    break;
                case "Protein bar":
                    proteinBar++;
                    break;
            }
        }
        System.out.printf("%d - back%n", back);
        System.out.printf("%d - chest%n", chest);
        System.out.printf("%d - legs%n", legs);
        System.out.printf("%d - abs%n", abs);
        System.out.printf("%d - protein shake%n", proteinShake);
        System.out.printf("%d - protein bar%n", proteinBar);
        System.out.printf("%.2f%% - work out%n", 100.0 * (back + chest + legs + abs) / visitors);
        System.out.printf("%.2f%% - protein%n", 100.0 * (proteinBar + proteinShake) / visitors);

    }
}
