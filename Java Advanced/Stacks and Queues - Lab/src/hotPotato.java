import java.util.ArrayDeque;
import java.util.Scanner;

public class hotPotato {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        String[] childrens = input.split("\\s+");
        int n = Integer.parseInt(scan.nextLine());
        ArrayDeque<String> kids = new ArrayDeque<>();

        for (String child : childrens) {
            kids.offer(child);
        }

        while (kids.size()>1) {
            for (int i = 1; i < n; i++) {
                kids.offer(kids.poll());
            }
            System.out.println("Removed " + kids.poll());

        }

        System.out.println("Last is " + kids.poll());
    }
}

