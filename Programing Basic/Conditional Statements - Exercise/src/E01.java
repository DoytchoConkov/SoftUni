import java.util.Scanner;

public class E01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int second1= Integer.parseInt(scan.nextLine());
        int second2= Integer.parseInt(scan.nextLine());
        int second3= Integer.parseInt(scan.nextLine());
        int sumSeconds = second1+second2+second3;
        System.out.printf("%d:%02d",sumSeconds/60 , sumSeconds%60);
    }
}
