import java.util.Scanner;

public class Cinema {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int capacity = Integer.parseInt(scan.nextLine());
        int totalPeople = 0;
        int income = 0;
        boolean flag=false;
        String imput = scan.nextLine();
        while (!imput.equals("Movie time!")) {
            int people = Integer.parseInt(imput);
            totalPeople += people;
            if (people % 3 == 0) {
                income = income - 5;
            }
            if (totalPeople > capacity) {
                System.out.printf("The cinema is full.%n");
                income = income + (people-totalPeople+capacity) * 5;
                flag=true;
                break;
            }
            income = income + people * 5;
            imput = scan.nextLine();
        }
        if (!flag) {
            System.out.printf("There are %d seats left in the cinema.%n", capacity-totalPeople);
        }
        System.out.printf("Cinema income - %d lv.", income);
    }
}
