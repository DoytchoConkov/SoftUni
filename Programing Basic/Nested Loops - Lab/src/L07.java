import java.util.Scanner;

public class L07 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String movie = scan.nextLine();
        int studentsCnt = 0;
        int studentsCntTotal = 0;
        int standartCnt = 0;
        int standartCntTotal = 0;
        int kidCnt = 0;
        int kidCntTotal = 0;
        int counter = 0;
        while (!movie.equals("Finish")) {
            int seats = Integer.parseInt(scan.nextLine());
            String ticketType = scan.nextLine();
            while (!ticketType.equals("End")) {
                switch (ticketType) {
                    case "student":
                        studentsCnt++;
                        studentsCntTotal++;
                        break;
                    case "standard":
                        standartCnt++;
                        standartCntTotal++;
                        break;
                    case "kid":
                        kidCntTotal++;
                        break;
                }
                counter++;
                if (counter == seats) {
                    break;
                }
                ticketType = scan.nextLine();
            }
            System.out.printf("%s - %.2f%% full.%n", movie, counter * 100.0 / seats);
            counter=0;
            standartCnt = 0;
            studentsCnt = 0;
            kidCnt = 0;
            movie = scan.nextLine();
        }

        System.out.printf("Total tickets: %d%n", standartCntTotal + studentsCntTotal + kidCntTotal);
        System.out.printf("%.2f%% student tickets.%n", studentsCntTotal * 100.0 / (standartCntTotal + studentsCntTotal + kidCntTotal));
        System.out.printf("%.2f%% standard tickets.%n", standartCntTotal * 100.0 / (standartCntTotal + studentsCntTotal + kidCntTotal));
        System.out.printf("%.2f%% kids tickets.%n", kidCntTotal * 100.0 / (standartCntTotal + studentsCntTotal + kidCntTotal));
    }
}
