import java.util.Scanner;

public class StrongNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int number =Integer.parseInt(scan.nextLine());
        int sum=0;
        String textNumber=""+number;
        for (int i = 0; i <= textNumber.length()-1; i++) {
            int digit= Integer.parseInt(""+textNumber.charAt(i));
            int factorial=1;
            for (int j = 1; j <=digit ; j++) {
                factorial=factorial*j;
            }
            sum=sum+factorial;
        }
        if (sum == number) {
            System.out.println("yes");
        }else {
            System.out.println("no");
        }
    }
}
