import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class lineNumbers {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\doytc\\IdeaProjects\\Java Advanced\\src\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputLineNumbers.txt";
        BufferedReader reader = new BufferedReader(new FileReader(path));
        String line = reader.readLine();
        int cnt = 1;
        while (line != null) {
            System.out.println(cnt + ". " + line);
            cnt++;
            line = reader.readLine();
        }
    }
}
