import java.util.Scanner;

public class WinningTicket {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        input.replace("\\s+", "");
        String[] tikets = input.split(", ");
        for (String tiket : tikets) {
            tiket.strip();
            if (tiket.length() == 20) {
                if (tiket.equals("@@@@@@@@@@@@@@@@@@@@")) {
                    System.out.println("ticket \"@@@@@@@@@@@@@@@@@@@@\" - 10$ Jackpot!");
                } else if (tiket.equals("####################")) {
                    System.out.println("ticket \"####################\" - 10$ Jackpot!");
                } else if (tiket.equals("$$$$$$$$$$$$$$$$$$$$")) {
                    System.out.println("ticket \"$$$$$$$$$$$$$$$$$$$$\" - 10$ Jackpot!");
                } else if (tiket.equals("^^^^^^^^^^^^^^^^^^^^")) {
                    System.out.println("ticket \"^^^^^^^^^^^^^^^^^^^^\" - 10$ Jackpot!");
                } else {
                    int left1 = 0;
                    int left2 = 0;
                    int left3 = 0;
                    int left4 = 0;
                    int right1 = 0;
                    int right2 = 0;
                    int right3 = 0;
                    int right4 = 0;
                    for (int i = 0; i < 10; i++) {
                        switch (tiket.charAt(i)) {
                            case '@':
                                left1++;
                                break;
                            case '#':
                                left2++;
                                break;
                            case '$':
                                left3++;
                                break;
                            case '^':
                                left4++;
                                break;
                        }
                        switch (tiket.charAt(i + 10)) {
                            case '@':
                                right1++;
                                break;
                            case '#':
                                right2++;
                                break;
                            case '$':
                                right3++;
                                break;
                            case '^':
                                right4++;
                                break;
                        }
                    }
                    if (left1 == right1 && left1 >= 6) {
                        System.out.printf("ticket \"%s\" - %d@%n", tiket, left1);
                    } else if (left2 == right2 && left2 >= 6) {
                        System.out.printf("ticket \"%s\" - %d#%n", tiket, left2);
                    } else if (left3 == right3 && left3 >= 6) {
                        System.out.printf("ticket \"%s\" - %d$%n", tiket, left3);
                    } else if (left4 == right4 && left4 >= 6) {
                        System.out.printf("ticket \"%s\" - %d^%n", tiket, left4);
                    }
                }
            } else {
                System.out.println("invalid ticket");
            }
        }
    }
}
