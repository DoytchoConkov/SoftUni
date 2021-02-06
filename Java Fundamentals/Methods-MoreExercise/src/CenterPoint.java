import java.util.Scanner;

public class CenterPoint {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int x1 =Integer.parseInt(scan.nextLine());
        int y1 =Integer.parseInt(scan.nextLine());
        int x2 =Integer.parseInt(scan.nextLine());
        int y2 =Integer.parseInt(scan.nextLine());

        printCloserPoint(x1,y1,x2,y2);
    }

    private static void printCloserPoint(int x1, int y1, int x2, int y2) {
        int firstPoint=x1*x1+y1*y1;
        int secondPoint=x2*x2+y2*y2;
        if (secondPoint<firstPoint){
            System.out.printf("(%d, %d)",x2,y2);
        }else {
            System.out.printf("(%d, %d)",x1,y1);

        }
    }
}
