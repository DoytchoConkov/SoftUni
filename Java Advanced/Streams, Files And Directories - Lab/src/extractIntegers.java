import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class extractIntegers {
    public static void main(String[] args) throws FileNotFoundException {
        String path = "C:\\Users\\doytc\\IdeaProjects\\Java Advanced\\src\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        Scanner scanner = new Scanner(new FileInputStream(path));
        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                System.out.println(scanner.nextInt());
            }
            scanner.next();
        }
    }
}
