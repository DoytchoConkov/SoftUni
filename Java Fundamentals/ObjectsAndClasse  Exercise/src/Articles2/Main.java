package Articles2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        List<Articles> articles = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] input = scan.nextLine().split(", ");
            Articles tempArticels = new Articles(input[0], input[1], input[2]);
            articles.add(tempArticels);
        }
        String token= scan.nextLine();
        switch (token){
            case "title" :
                articles.stream()
                        .sorted((p1,p2)->p1.getTitle().compareTo(p2.getTitle()))
                        .forEach(p -> System.out.println(p));
                break;
            case "content" :
                articles.stream()
                        .sorted((p1,p2)->p1.getContent().compareTo(p2.getContent()))
                        .forEach(p -> System.out.println(p));
                break;
            case "author" :
                articles.stream()
                        .sorted((p1,p2)->p1.getAuthor().compareTo(p2.getAuthor()))
                        .forEach(p -> System.out.println(p));
                break;
        }
    }
}
