import java.util.ArrayDeque;
import java.util.Scanner;

public class matchingBrackets {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        ArrayDeque<Integer> indexes=new ArrayDeque<>();
        for (int i = 0; i < input.length(); i++) {
            char symbol=input.charAt(i);
            if (symbol=='('){
                indexes.push(i);
            }else if (symbol==')'){
                String result=input.substring(indexes.pop(),i+1);
                System.out.println(result);
            }
        }
    }
}
