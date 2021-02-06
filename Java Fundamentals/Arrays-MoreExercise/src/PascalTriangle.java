import java.util.Scanner;

public class PascalTriangle {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n =Integer.parseInt(scan.nextLine());
        System.out.println("1");
        System.out.println("1 1");
        int [] paskalLine=new int[n];
        paskalLine[0]=1;
        paskalLine[1]=1;
        int [] currentPaskalLine=new int[n];
        for (int i = 2; i < n; i++) {
            for (int j = 0; j <=i ; j++) {
                if (j==0||j==i){
                    currentPaskalLine[j]=1;
                }else {
                    currentPaskalLine[j]=paskalLine[j-1]+paskalLine[j];
                }
            }
            for (int j = 0; j <= i; j++) {
                System.out.print(currentPaskalLine[j]+" ");
                paskalLine[j]=currentPaskalLine[j];
            }
            System.out.println();
        }
    }
}
