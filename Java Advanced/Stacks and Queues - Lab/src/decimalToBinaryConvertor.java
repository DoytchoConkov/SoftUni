import java.util.ArrayDeque;
import java.util.Scanner;

public class decimalToBinaryConvertor {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int decimal = Integer.parseInt(scan.nextLine());
        if (decimal==0){
            System.out.println(0);
            return;
        }
        ArrayDeque<Integer> binaryResult=new ArrayDeque<>();
        while (decimal!=0){
            binaryResult.push(decimal%2);
            decimal/=2;
        }
        while (!binaryResult.isEmpty()){
            System.out.print(binaryResult.pop());}
    }
}
