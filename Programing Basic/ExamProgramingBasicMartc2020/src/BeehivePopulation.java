import java.util.Scanner;

public class BeehivePopulation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int population =Integer.parseInt(scan.nextLine());
        int years =Integer.parseInt(scan.nextLine());
        int countFive=0;
        for (int i = 0; i <years ; i++) {
            population=population+population/10*2;
            countFive++;
            if (countFive == 5) {
                population=population-population/50*5;
                countFive=0;
            }
            population=population-population/20*2;
        }
        System.out.printf("Beehive population: %d",population);
    }
}
