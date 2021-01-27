import java.util.Scanner;

public class E07 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double recordTime = Double.parseDouble(scan.nextLine());
        double distance = Double.parseDouble(scan.nextLine());
        double timePerMeter = Double.parseDouble(scan.nextLine());
        double impedance = Math.floor(distance / 15)*12.5;
        double totatalTime = distance * timePerMeter + impedance;

        if (totatalTime < recordTime) {
            System.out.printf("Yes, he succeeded! The new world record is %.2f seconds.", totatalTime);
        }else{
            System.out.printf("No, he failed! He was %.2f seconds slower.",totatalTime-recordTime);
        }
    }
}
