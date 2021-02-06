import java.util.Scanner;

public class BeerKegs {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        double maxVolume = 0;
        String kegMax = "";
        for (int i = 0; i < n; i++) {
            String name = scan.nextLine();
            double radius = Double.parseDouble(scan.nextLine());
            double height = Double.parseDouble(scan.nextLine());
            double volume = Math.PI * radius * radius * height;
            if (volume > maxVolume) {
                maxVolume=volume;
                kegMax = name;
            }
        }
        System.out.println(kegMax);
    }
}
