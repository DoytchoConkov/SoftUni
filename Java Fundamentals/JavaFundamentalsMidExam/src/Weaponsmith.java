import java.util.Scanner;

public class Weaponsmith {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] weapons = scan.nextLine().split("\\|");
        String input = scan.nextLine();
        while (!"Done".equals(input)) {
            String[] token = input.split("\\s+");
            switch (token[0]) {
                case "Move":
                    int moveIndex = Integer.parseInt(token[2]);
                    switch (token[1]) {
                        case "Left":
                            if (moveIndex > 0 && moveIndex < weapons.length) {
                                String temp = weapons[moveIndex - 1];
                                weapons[moveIndex - 1] = weapons[moveIndex];
                                weapons[moveIndex] = temp;
                            }
                            break;
                        case "Right":
                            if (moveIndex >= 0 && moveIndex < weapons.length - 1) {
                                String temp = weapons[moveIndex + 1];
                                weapons[moveIndex + 1] = weapons[moveIndex];
                                weapons[moveIndex] = temp;
                            }
                            break;
                    }
                    break;
                case "Check":
                    switch (token[1]) {
                        case "Even":
                            for (int i = 0; i < weapons.length; i += 2) {
                                System.out.print(weapons[i] + " ");
                            }
                            System.out.println();
                            break;
                        case "Odd":
                            for (int i = 1; i < weapons.length; i += 2) {
                                System.out.print(weapons[i] + " ");
                            }
                            System.out.println();
                            break;
                    }
                    break;
            }
            input = scan.nextLine();
        }
        System.out.println("You crafted " + String.join("", weapons)+"!");
    }
}
