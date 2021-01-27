import java.util.Scanner;

public class L03 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double years = Double.parseDouble(scan.nextLine());
        String pol = scan.nextLine();
        if (pol.equals("m")) {
            if (years < 16) {
                System.out.println("Master");
            } else {
                System.out.println("Mr.");
            }
        } else if (pol.equals("f")) {
            if (years < 16) {
                System.out.println("Miss");
            } else {
                System.out.println("Ms.");
            }
        }

    }
}
