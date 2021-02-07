package GenericCountMethodString;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        List<Box<String>> ithems = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ithems.add(new Box<>(scan.nextLine()));
        }
        String compareElement = scan.nextLine();

        System.out.println(generate(ithems,compareElement));
    }

    public static <T> int generate(List<Box<String>> list, String target) {
        int count = 0;
        for (Box<String> element : list) {
            if(element.compareTo(target)>0){
                count++;
            }
        }
        return count;
    }



    public static void swap(List<Box<String>> list, int first, int second) {
        Box<String> firstElement = list.get(first);
        Box<String> secondElement = list.get(second);
        list.set(first, secondElement);
        list.set(second, firstElement);
    }
}
