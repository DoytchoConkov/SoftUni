import java.util.Scanner;

public class E05 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int hoursToCompleteProject = Integer.parseInt(scan.nextLine());
        int days = Integer.parseInt(scan.nextLine());
        int employees = Integer.parseInt(scan.nextLine());
        double firmHours = 0.9 * days * 8;
        int workersExtraHours = employees * days * 2;
        double totalHours = Math.floor(firmHours) + workersExtraHours;
        if (totalHours >= hoursToCompleteProject) {
            System.out.printf("Yes!%.0f hours left.", totalHours - hoursToCompleteProject);
        } else {
            System.out.printf("Not enough time!%.0f hours needed.", hoursToCompleteProject - totalHours);
        }
    }
}
