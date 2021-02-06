import java.util.Scanner;

public class ExtractFile {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        int pointIndex = input.indexOf('.');
        int slash = input.lastIndexOf('\\');
        String fileName = input.substring(slash + 1, pointIndex);
        String extension = input.substring(pointIndex + 1);
        System.out.printf("File name: %s%n", fileName);
        System.out.printf("File extension: %s%n", extension);
    }
}
