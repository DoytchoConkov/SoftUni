import java.util.Arrays;
import java.util.Scanner;

public class CustomComparator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Arrays.stream(scan.nextLine().split(" "))
                .map(Integer::parseInt)
                .sorted((a, b) -> {
                    int result=Integer.compare(Math.abs(a%2),Math.abs(b%2));
                    if (result== 0) {
                       result=a-b;
                    }
                    return result;
                })
                .map(e -> e + " ")
                .forEach(System.out::print);
    }
}
