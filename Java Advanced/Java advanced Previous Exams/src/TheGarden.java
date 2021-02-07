import java.util.Scanner;

public class TheGarden {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        String[][] garden = new String[n][];
        for (int i = 0; i < n; i++) {
            String[] input = scan.nextLine().split("\\s+");
            garden[i] = input;
        }

        int carrots = 0;
        int potatoes = 0;
        int lettuce = 0;
        int harmed = 0;

        String input = scan.nextLine();
        while (!input.equals("End of Harvest")) {
            String[] tokens = input.split("\\s+");
            if (tokens[0].equals("Harvest")) {
                int x = Integer.parseInt(tokens[1]);
                int y = Integer.parseInt(tokens[2]);
                if (x >= 0 && x < garden.length) {
                    if (y >= 0 && y < garden[x].length) {
                        String element = garden[x][y];
                        switch (element) {
                            case "C":
                                garden[x][y] = " ";
                                carrots++;
                                break;
                            case "P":
                                garden[x][y] = " ";
                                potatoes++;
                                break;
                            case "L":
                                garden[x][y] = " ";
                                lettuce++;
                                break;
                        }
                    }
                }

            } else {
                int x = Integer.parseInt(tokens[1]);
                int y = Integer.parseInt(tokens[2]);
                while (x >= 0 && x < garden.length) {
                    if (y >= 0 && y < garden[x].length) {
                        String element = garden[x][y];
                        if (!element.equals(" ")) {
                            harmed++;
                            garden[x][y] = " ";
                        }
                        switch (tokens[3]) {
                            case "up":
                                x -= 2;
                                break;
                            case "down":
                                x += 2;
                                break;
                            case "left":
                                y -= 2;
                                break;
                            case "right":
                                y += 2;
                                break;
                        }
                    } else {
                        break;
                    }
                }
            }

            input = scan.nextLine();
        }

        for (int row = 0; row < garden.length; row++) {
            for (int col = 0; col < garden[row].length; col++) {
                System.out.print(garden[row][col] + " ");
            }
            System.out.println();
        }
        System.out.printf("Carrots: %d%n", carrots);
        System.out.printf("Potatoes: %d%n", potatoes);
        System.out.printf("Lettuce: %d%n", lettuce);
        System.out.printf("Harmed vegetables: %d%n", harmed);
    }
}
