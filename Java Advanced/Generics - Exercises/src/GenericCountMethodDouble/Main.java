package GenericCountMethodDouble;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        List<Box<Double>> numbers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            numbers.add(new Box<>(Double.parseDouble(scan.nextLine())));
        }
        Double compareElement = Double.parseDouble(scan.nextLine());

        System.out.println(generate(numbers,compareElement));
    }

    public static <T> int generate(List<Box<Double>> list, Double target) {
        int count = 0;
        for (Box<Double> element : list) {
            if(element.compareTo(target)>0){
                count++;
            }
        }
        return count;
    }
}
