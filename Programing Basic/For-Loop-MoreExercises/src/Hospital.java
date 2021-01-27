import java.util.Scanner;

public class Hospital {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int doctors = 7;
        int pacientsCured = 0;
        int pacientsCuredTemp = 0;
        int pacientsNotCured = 0;
        int pacientsNotCuredTemp = 0;
        int every3Days = 1;
        int days = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < days; i++) {
            int pacients = Integer.parseInt(scan.nextLine());
            if (pacientsCured > pacientsNotCured && every3Days == 3) {
                doctors++;
                every3Days = 0;
            }
            if (pacients <= doctors) {
                pacientsNotCuredTemp = pacients;
                pacientsCuredTemp = 0;
            } else {
                pacientsNotCuredTemp = doctors;
                pacientsCuredTemp = pacients - doctors;
            }
            pacientsNotCured = pacientsNotCured + pacientsNotCuredTemp;
            pacientsCured = pacientsCured + pacientsCuredTemp;
            every3Days++;
        }
        System.out.printf("Treated patients: %d.%n", pacientsNotCured);
        System.out.printf("Untreated patients: %d.", pacientsCured);
    }
}
