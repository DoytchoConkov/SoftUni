import java.util.Scanner;

public class L09 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String city = scan.nextLine();
        double sales = Double.parseDouble(scan.nextLine());
        double comision = 0;
        switch (city) {
            case "Sofia":
                if (sales >= 0 && sales <= 500) {
                    comision = 0.05;
                } else if (sales <= 1000) {
                    comision = 0.07;
                }else if (sales <= 10000) {
                    comision = 0.08;
                }else if (sales > 10000) {
                    comision = 0.12;
                }
                break;
            case "Varna":
                if (sales >= 0 && sales <= 500) {
                    comision = 0.045;
                } else if (sales <= 1000) {
                    comision = 0.075;
                }else if (sales <= 10000) {
                    comision = 0.1;
                }else if (sales > 10000) {
                    comision = 0.13;
                }
                break;
            case "Plovdiv":
                if (sales >= 0 && sales <= 500) {
                    comision = 0.055;
                } else if (sales <= 1000) {
                    comision = 0.08;
                }else if (sales <= 10000) {
                    comision = 0.12;
                }else if (sales > 10000) {
                    comision = 0.145;
                }
                break;
        }
if (comision!=0){
    System.out.printf("%.2f",sales*comision);
}else {
    System.out.println("error");
}
    }
}
