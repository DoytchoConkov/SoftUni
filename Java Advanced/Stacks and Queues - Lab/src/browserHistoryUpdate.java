import java.util.ArrayDeque;
import java.util.Scanner;

public class browserHistoryUpdate {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayDeque<String> stack = new ArrayDeque<>();
        ArrayDeque<String> stackForward = new ArrayDeque<>();
        String input = scan.nextLine();
        while (!input.equals("Home")) {
            if (input.equals("back")) {
                if (stack.size() <= 1) {
                    System.out.println("no previous URLs");
                } else {
                    stackForward.push(stack.pop());
                    System.out.println(stack.peek());
                }
            } else if (input.equals("forward")) {
                if (stackForward.isEmpty()) {
                    System.out.println("no next URLs");
                } else {

                    stack.push(stackForward.pop());
                    System.out.println(stack.peek());

                }
            } else {
                System.out.println(input);
                stack.push(input);
            }
            input = scan.nextLine();
        }
    }
}
