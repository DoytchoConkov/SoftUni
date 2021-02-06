import java.util.Scanner;

public class RageExpenses {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int games = Integer.parseInt(scan.nextLine());
        double headsetPrice = Double.parseDouble(scan.nextLine());
        double mousePrice = Double.parseDouble(scan.nextLine());
        double keyboardPrice = Double.parseDouble(scan.nextLine());
        double monitorPrice = Double.parseDouble(scan.nextLine());
        double money = 0;
        int headsetCnt = games / 2;
        int mouseCnt = games / 3;
        int keyboardCnt = games / 6;
        int monitorCnt = games / 12;
        money = headsetCnt * headsetPrice + mouseCnt * mousePrice + keyboardCnt * keyboardPrice + monitorCnt * monitorPrice;
        System.out.printf("Rage expenses: %.2f lv.", money);
    }
}
