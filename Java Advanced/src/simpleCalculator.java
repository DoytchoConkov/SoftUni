import java.util.ArrayDeque;
import java.util.Scanner;

public class simpleCalculator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split("\\s+");
        ArrayDeque<String> stack = new ArrayDeque<>();
        for (int i = 0; i < input.length; i++) {
            stack.offer(input[i]);
        }
        while (stack.size()>1){
            int firstNumber= Integer.parseInt(stack.poll());
            String operator=stack.poll();
            int secondNumber= Integer.parseInt(stack.poll());
            if (operator.equals("+")){
                stack.push(String.valueOf(firstNumber+secondNumber));
            }else {
                stack.push(String.valueOf(firstNumber-secondNumber));
            }
        }
        System.out.println(stack.poll());
    }
}
