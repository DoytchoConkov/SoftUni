package Articles;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] text = scan.nextLine().split(", ");
        Articles article = new Articles(text[0], text[1], text[2]);
        int n = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < n; i++) {
            String[] input = scan.nextLine().split(": ");
            switch (input[0]) {
                case "Edit":
                    article.edit(input[1]);
                    break;
                case "ChangeAuthor":
                    article.changeAutor(input[1]);
                    break;
                case "Rename":
                    article.rename(input[1]);
                    break;
            }
        }
        System.out.println(article.toString());
    }
}
