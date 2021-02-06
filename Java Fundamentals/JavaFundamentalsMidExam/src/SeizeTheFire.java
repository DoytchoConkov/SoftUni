import java.util.Scanner;

public class SeizeTheFire {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] fireCells = scan.nextLine().split("#");
        int totalWater = Integer.parseInt(scan.nextLine());
        System.out.println("Cells:");
        double effort = 0;
        int totalFires = 0;
        for (int i = 0; i < fireCells.length; i++) {
            String[] token = fireCells[i].split(" = ");
            int fire = Integer.parseInt(token[1]);
            switch (token[0]) {
                case "High":
                    if (fire >= 81 && fire <= 125 && fire <= totalWater) {
                        System.out.printf("- %d%n", fire);
                        totalWater = totalWater - fire;
                        effort = effort + fire * 0.25;
                        totalFires = totalFires + fire;
                    }
                    break;
                case "Medium":
                    if (fire >= 51 && fire <= 80 && fire <= totalWater) {
                        System.out.printf("- %d%n", fire);
                        totalWater = totalWater - fire;
                        effort = effort + fire * 0.25;
                        totalFires = totalFires + fire;
                    }
                    break;
                case "Low":
                    if (fire >= 1 && fire <= 50 && fire <= totalWater) {
                        System.out.printf("- %d%n", fire);
                        totalWater = totalWater - fire;
                        effort = effort + fire * 0.25;
                        totalFires = totalFires + fire;
                    }
                    break;
            }
        }
        System.out.printf("Effort: %.2f%n", effort);
        System.out.printf("Total Fire: %d", totalFires);
    }
}
