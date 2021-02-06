import java.util.Scanner;

public class SpiceMustFlow {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int startingYield = Integer.parseInt(scan.nextLine());
        int sum = 0;
        int days = 0;
        while (startingYield >= 100) {
            sum += startingYield;
            if (sum >= 26) {
                sum-= 26;
            }else {
                sum=0;
            }
            days++;
            startingYield -= 10;
        }
      System.out.println(days);
        if (sum >= 26) {
            sum -= 26;
        }else {
            sum=0;
        }
       System.out.println(sum);
    }
}
