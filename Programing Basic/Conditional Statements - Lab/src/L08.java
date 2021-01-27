import java.util.Scanner;

public class L08 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double tripPrice = Double.parseDouble(scan.nextLine());
        int puzzel= Integer.parseInt(scan.nextLine());
        int doll= Integer.parseInt(scan.nextLine());
        int teddyBear= Integer.parseInt(scan.nextLine());
        int minon= Integer.parseInt(scan.nextLine());
        int truck= Integer.parseInt(scan.nextLine());

        double sum = puzzel*2.6+doll*3+teddyBear*4.1+minon*8.2+truck*2;
        int count = puzzel+doll+teddyBear+minon+truck;
        if (count>=50){sum=sum*0.75;}
        double money = sum*0.9;
        if (tripPrice-money<=0){
            System.out.printf("Yes! %.2f lv left.",money-tripPrice);
        }else {
            System.out.printf("Not enough money! %.2f lv needed.", tripPrice-money);
        }

    }
}
