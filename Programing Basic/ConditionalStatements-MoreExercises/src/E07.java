import java.util.Scanner;

public class E07 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int magnoliiCnt = Integer.parseInt(scan.nextLine());
        int zumbulsCnt = Integer.parseInt(scan.nextLine());
        int rosesCnt = Integer.parseInt(scan.nextLine());
        int cactusCNt = Integer.parseInt(scan.nextLine());
        double giftPrice = Double.parseDouble(scan.nextLine());
        double oborot = (magnoliiCnt * 3.25 + zumbulsCnt * 4 + rosesCnt * 3.5 + cactusCNt * 8) * 0.95;
        if (oborot >= giftPrice) {
            System.out.printf("She is left with %.0f leva.", Math.floor(oborot - giftPrice));
        } else {
            System.out.printf("She will have to borrow %.0f leva.", Math.ceil(giftPrice - oborot));
        }
    }
}
