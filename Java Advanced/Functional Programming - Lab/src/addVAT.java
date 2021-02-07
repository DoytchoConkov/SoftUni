import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class addVAT {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Double> numbers = Arrays.stream(scan.nextLine().split(", "))
                .map(Double::parseDouble).collect(Collectors.toList());

        UnaryOperator<Double> addVat = x -> x * 1.2;
        System.out.println("Prices with VAT:");
        for (Double number : numbers)
            System.out.println(String.format("%.2f",
                    addVat.apply(number)));
    }
}
