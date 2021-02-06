import java.util.Scanner;

public class EasterGifts {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] gifts = scan.nextLine().split("\\s+");
        String input = scan.nextLine();
        while (!"No Money".equals(input)) {
            String[] token = input.split("\\s+");
            switch (token[0]) {
                case "OutOfStock":
                    for (int i = 0; i < gifts.length; i++) {
                        if (gifts[i].equals(token[1])) {
                            gifts[i] = "None";
                        }
                    }
                    break;
                case "Required": {
                    int index = Integer.parseInt(token[2]);
                    if (index >= 0 && index < gifts.length) {
                        gifts[index] = token[1];
                    }
                }
                break;
                case "JustInCase":
                    gifts[gifts.length - 1] = token[1];
                    break;
            }
            input = scan.nextLine();
        }
        for (String gift : gifts) {
            if (!gift.equals("None")) {
                System.out.print(gift + " ");
            }
        }
    }
}
