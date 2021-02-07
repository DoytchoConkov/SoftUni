import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class readFile {
    public static void main(String[] args) {
        String path = "C:\\Users\\doytc\\IdeaProjects\\Java Advanced\\src\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        try {
            FileInputStream file = new FileInputStream(path);
            int oneByte = file.read();
            while ((oneByte >= 0)) {
                System.out.printf("%s ", Integer.toBinaryString(oneByte));
                oneByte = file.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
