package Traffic_Lights;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] lights = scan.nextLine().split("\\s+");
        int n =Integer.parseInt(scan.nextLine());
        for (int i = 0; i <n; i++) {
            for (int j = 0; j < lights.length; j++) {
                lights[j]=TrafficLights.valueOf(lights[j]).getColor();
                System.out.print(lights[j]+" ");
            }
            System.out.println();
        }
    }
}
