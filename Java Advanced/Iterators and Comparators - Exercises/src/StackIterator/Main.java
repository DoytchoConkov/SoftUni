package StackIterator;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Stack<Integer> stack = new Stack();
        Arrays.stream(scan.nextLine().split("[, ]+"))
                .skip(1)
                .mapToInt(Integer::parseInt)
                .forEach(stack::push);
        String input = scan.nextLine();
        while (!input.equals("END")) {
            if (input.equals("Pop")) {
                try {
                    stack.pop();
                } catch (IndexOutOfBoundsException ex) {
                    System.out.println(ex.getMessage());
                }
            } else {
                stack.push(Integer.parseInt(input.split("\\s+")[1]));
            }
            input = scan.nextLine();
        }
        stack.forEach(System.out::println);
        stack.forEach(System.out::println);
    }
}
