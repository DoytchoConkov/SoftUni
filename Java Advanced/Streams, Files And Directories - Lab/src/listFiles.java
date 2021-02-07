import java.io.File;
import java.util.Arrays;
import java.util.stream.Stream;

public class listFiles {
    public static void main(String[] args) {
        String path = "C:\\Users\\doytc\\IdeaProjects\\Java Advanced\\src\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams";
        File file = new File(path);
        File[] files = file.listFiles();
        for (File f : files) {
            if (!f.isDirectory()) {
                System.out.println(f.getName() + ": [" + f.length()+"]");
            }
        }
    }
}
