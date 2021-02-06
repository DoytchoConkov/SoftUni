import java.util.Scanner;

public class BlackFlag {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int days =Integer.parseInt(scan.nextLine());
        int plunderPerDay =Integer.parseInt(scan.nextLine());
        double expectedPlunder = Double.parseDouble(scan.nextLine());
        double totalPlunder=0;
        for (int i = 1; i <= days; i++) {
            totalPlunder+=plunderPerDay;
            if (i%3==0){
                totalPlunder+=plunderPerDay*0.5;
            }
            if(i%5==0){
                totalPlunder=totalPlunder*0.7;
            }
        }
        if (totalPlunder>=expectedPlunder){
            System.out.printf("Ahoy! %.2f plunder gained.",totalPlunder);
        }else {
            System.out.printf("Collected only %.2f%% of the plunder.",100.0*totalPlunder/expectedPlunder);
        }
    }
}
