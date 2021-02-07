import java.util.ArrayDeque;
import java.util.Scanner;

public class mathPotato {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        String[] childrens = input.split("\\s+");
        int n = Integer.parseInt(scan.nextLine());
        ArrayDeque<String> kids = new ArrayDeque<>();
        int cycle = 1;
        for (String child : childrens) {
            kids.offer(child);
        }

        while (kids.size() > 1) {

            for (int i = 1; i < n; i++) {
                kids.offer(kids.poll());
            }

            if (IsPrime(cycle)) {
                System.out.println("Prime " + kids.peek());
            } else {
                System.out.println("Removed " + kids.poll());
            }
            cycle++;

        }

        System.out.println("Last is " + kids.poll());
    }

    private static boolean IsPrime(int n) {
        boolean primeCheck = true;
        if (n == 1) {
            primeCheck = false;
            return primeCheck;
        } else {
            for (int i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0) {
                    primeCheck = false;
                }
            }
            return primeCheck;
        }
    }

}

