import java.util.Scanner;

public class EasterShop {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int eggs = Integer.parseInt(scan.nextLine());
        int soldEggs = 0;
        int buyFilleggs = 0;
        String imput = scan.nextLine();
        while (!imput.equals("Close")) {
            buyFilleggs = Integer.parseInt(scan.nextLine());
            if (imput.equals("Buy")) {
                eggs -= buyFilleggs;
                soldEggs += buyFilleggs;
            } else {

                eggs += buyFilleggs;
            }
            if (eggs <= 0) {
                break;
            }
            imput = scan.nextLine();
        }
        if (eggs > 0) {
            System.out.println("Store is closed!");
            System.out.printf("%d eggs sold.", soldEggs);
        } else {
            System.out.println("Not enough eggs in store!");
            System.out.printf("You can buy only %d.", buyFilleggs + eggs);
        }
    }
}