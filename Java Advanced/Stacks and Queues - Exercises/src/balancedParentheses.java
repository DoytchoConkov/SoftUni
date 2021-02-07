import java.util.ArrayDeque;
import java.util.Scanner;

public class balancedParentheses {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < input.length(); i++) {
            char symbol = input.charAt(i);
            if (symbol == '(' || symbol == '[' || symbol == '{') {
                stack.push(symbol);
            } else {
                if (stack.size()==0){
                    System.out.println("NO");
                    return;
                }
                char lastElement = stack.pop();
                if (symbol == ']' && lastElement != '[') {
                    System.out.println("NO");
                    return;
                } else if (symbol == '}' && lastElement != '{') {
                    System.out.println("NO");
                    return;
                } else if (symbol == ')' && lastElement != '(') {
                    System.out.println("NO");
                    return;
                }
            }
        }
        System.out.println("YES");
    }
}
