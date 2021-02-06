import java.util.Arrays;
import java.util.Scanner;

public class LadyBugs {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int cells = Integer.parseInt(scan.nextLine());
        int[] ladyBuggs = Arrays.stream(scan.nextLine().split(" ")).mapToInt(e -> Integer.parseInt(e)).toArray();
        int[] board = new int[cells];
        for (int i = 0; i < ladyBuggs.length; i++) {
            if (ladyBuggs[i] >= 0 && ladyBuggs[i] < cells) {
                board[ladyBuggs[i]] = 1;
            }
        }
        String input = scan.nextLine();
        while (!"end".equals(input)) {
            String[] text = input.split(" ");
            String comand = text[1];
            int distance = Integer.parseInt(text[2]);
            int buggPositio = Integer.parseInt(text[0]);
            if (distance < 0) {
                if ("left".equals(comand)) {
                    distance*=-1;
                    comand = "right";
                }
                if ("right".equals(comand)) {
                    distance*=-1;
                    comand = "left";
                }
            }
            if (buggPositio >= 0 && buggPositio < cells) {
                if ("left".equals(comand)) {
                    if (board[buggPositio] == 1) {
                        board[buggPositio] = 0;
                        while (buggPositio - distance >= 0)
                            if (board[buggPositio - distance] == 0) {
                                board[buggPositio - distance] = 1;
                                break;
                            } else {
                                distance+=distance;
                            }
                    }
                } else if ("right".equals(comand)) {
                    if (board[buggPositio] == 1) {
                        board[buggPositio] = 0;
                        while (buggPositio + distance < cells)
                            if (board[buggPositio + distance] == 0) {
                                board[buggPositio + distance] = 1;
                                break;
                            } else {
                                distance+=distance;
                            }
                    }
                }
            }
            input = scan.nextLine();
        }
        for (int i = 0; i < board.length; i++) {
            System.out.print(board[i] + " ");
        }
    }
}
