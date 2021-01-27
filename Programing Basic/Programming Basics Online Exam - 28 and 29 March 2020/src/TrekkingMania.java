import java.util.Scanner;

public class TrekkingMania {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int personsMusala = 0;
        int personsMonblan = 0;
        int personsKalimandjaro = 0;
        int personsK2 = 0;
        int personsEverest = 0;
        int groups = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < groups; i++) {
            int persons = Integer.parseInt(scan.nextLine());
            if (persons <= 5) {
                personsMusala = personsMusala + persons;
            } else if (persons <= 12) {
                personsMonblan = personsMonblan + persons;
            } else if (persons <= 25) {
                personsKalimandjaro = personsKalimandjaro + persons;
            } else if (persons <= 40) {
                personsK2 = personsK2 + persons;
            } else {
                personsEverest = personsEverest + persons;
            }
        }
        int totalPersons = personsEverest + personsK2 + personsKalimandjaro + personsMonblan + personsMusala;
        System.out.printf("%.2f%%%n", personsMusala * 100.0 / totalPersons);
        System.out.printf("%.2f%%%n", personsMonblan * 100.0 / totalPersons);
        System.out.printf("%.2f%%%n", personsKalimandjaro * 100.0 / totalPersons);
        System.out.printf("%.2f%%%n", personsK2 * 100.0 / totalPersons);
        System.out.printf("%.2f%%%n", personsEverest * 100.0 / totalPersons);
    }
}
