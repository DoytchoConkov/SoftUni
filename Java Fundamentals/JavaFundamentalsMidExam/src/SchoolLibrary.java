import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SchoolLibrary {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] booksInput = scan.nextLine().split("&");
        List<String> books = new ArrayList<>();
        for (String book : booksInput) {
            books.add(book.trim());
        }
        String input = scan.nextLine();
        while (!"Done".equals(input)) {
            String[] tokens = input.split("\\| ");
            switch (tokens[0].trim()) {
                case "Add Book":
                    if (!books.contains(tokens[1].trim())) {
                        books.add(0, tokens[1].trim());
                    }
                    break;
                case "Take Book":
                    books.remove(tokens[1].trim());
                    break;
                case "Swap Books":
                    if (books.contains(tokens[1].trim()) && books.contains(tokens[2].trim())) {
                        int book1 = 0;
                        int book2 = 0;
                        for (int i = 0; i < books.size(); i++) {
                            if (books.get(i).equals(tokens[1].trim())) {
                                book1 = i;
                            }
                            if (books.get(i).equals(tokens[2].trim())) {
                                book2 = i;
                            }
                        }
                        String temp = books.get(book1);
                        books.set(book1, books.get(book2));
                        books.set(book2, temp);
                    }
                    break;
                case "Insert Book":
                    books.add(tokens[1].trim());
                    break;
                case "Check Book":
                    int index = Integer.parseInt(tokens[1].trim());
                    if (index >= 0 && index < books.size()) {
                        System.out.println(books.get(index));
                    }
                    break;
            }
            input = scan.nextLine();
        }
        System.out.println(books.toString().replaceAll("[\\[\\]]", ""));
    }
}
