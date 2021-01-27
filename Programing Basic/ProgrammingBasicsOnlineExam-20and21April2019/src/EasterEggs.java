import javax.swing.*;
import java.util.Scanner;

public class EasterEggs {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int redCnt = 0;
        int orangeCnt = 0;
        int blueCnt = 0;
        int greenCnt = 0;
        for (int i = 0; i < n; i++) {
            String color = scan.nextLine();
            switch (color) {
                case "red":
                    redCnt++;
                    break;
                case "orange":
                    orangeCnt++;
                    break;
                case "blue":
                    blueCnt++;
                    break;
                case "green":
                    greenCnt++;
                    break;
            }
        }
        int maxEggs = Integer.MIN_VALUE;
        String text = "";
        if (maxEggs < redCnt) {
            text = "red";
            maxEggs = redCnt;
        }
        if (maxEggs < orangeCnt) {
            text = "orange";
            maxEggs = orangeCnt;
        }
        if (maxEggs < blueCnt) {
            text = "blue";
            maxEggs = blueCnt;
        }
        if (maxEggs < greenCnt) {
            text = "green";
            maxEggs = greenCnt;
        }
        System.out.printf("Red eggs: %d%n", redCnt);
        System.out.printf("Orange eggs: %d%n", orangeCnt);
        System.out.printf("Blue eggs: %d%n", blueCnt);
        System.out.printf("Green eggs: %d%n", greenCnt);
        System.out.printf("Max eggs: %d -> %s", maxEggs, text);
    }
}
