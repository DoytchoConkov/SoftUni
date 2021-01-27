import java.util.Scanner;

public class MobileOperator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String term = scan.nextLine();
        String typeContract = scan.nextLine();
        String mobileInternet = scan.nextLine();
        double contractPrice = 0;
        int mounts = Integer.parseInt(scan.nextLine());
        switch (typeContract) {
            case "Small":
                if (term.equals("one")) {
                    contractPrice = 9.98;
                } else {
                    contractPrice = 8.58;
                }
                break;
            case "Middle":
                if (term.equals("one")) {
                    contractPrice = 18.99;
                } else {
                    contractPrice = 17.09;
                }
                break;
            case "Large":
                if (term.equals("one")) {
                    contractPrice = 25.98;
                } else {
                    contractPrice = 23.59;
                }
                break;
            case "ExtraLarge":
                if (term.equals("one")) {
                    contractPrice = 35.99;
                } else {
                    contractPrice = 31.79;
                }
                break;
        }
        if (mobileInternet.equals("yes")) {
            if (contractPrice <= 10) {
                contractPrice = contractPrice + 5.5;
            } else if (contractPrice <= 30) {
                contractPrice = contractPrice + 4.35;
            } else if (contractPrice > 30) {
                contractPrice = contractPrice + 3.85;
            }
        }
        if (term.equals("two")) {
            contractPrice = contractPrice * 0.9625;
        }
        System.out.printf("%.2f lv.", contractPrice * mounts);
    }
}
