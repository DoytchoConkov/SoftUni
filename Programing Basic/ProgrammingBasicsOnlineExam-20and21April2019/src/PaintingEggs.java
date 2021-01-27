import java.util.Scanner;

public class PaintingEggs {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String size = scan.nextLine();
        String color = scan.nextLine();
        int partids = Integer.parseInt(scan.nextLine());
        double privePerPartide = 0;
        switch (size) {
            case "Large":
                switch (color) {
                    case "Red":
                        privePerPartide = 16;
                        break;
                    case "Green":
                        privePerPartide = 12;
                        break;
                    case "Yellow":
                        privePerPartide = 9;
                        break;
                }
                break;
            case "Medium":
                switch (color) {
                    case "Red":
                        privePerPartide = 13;
                        break;
                    case "Green":
                        privePerPartide = 9;
                        break;
                    case "Yellow":
                        privePerPartide = 7;
                        break;
                }
                break;
            case "Small":
                switch (color) {
                    case "Red":
                        privePerPartide = 9;
                        break;
                    case "Green":
                        privePerPartide = 8;
                        break;
                    case "Yellow":
                        privePerPartide = 5;
                        break;
                }
                break;
        }
        System.out.printf("%.2f leva.", privePerPartide * partids * 0.65);

    }
}
