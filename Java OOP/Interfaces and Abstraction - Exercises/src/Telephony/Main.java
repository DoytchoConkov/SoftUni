package Telephony;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> numbers = Arrays.stream(scan.nextLine().split(" "))
                .collect(Collectors.toList());
        List<String> urls = Arrays.stream(scan.nextLine().split(" "))
                .collect(Collectors.toList());
        Smartphone iphone12 = new Smartphone(numbers, urls);
        System.out.println(iphone12.call());
        System.out.println(iphone12.browse());
    }
}
