import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;

public class sortLines {
    public static void main(String[] args) throws IOException {
        Path path = Path.of("C:\\Users\\doytc\\IdeaProjects\\Java Advanced\\src\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt");
        String pathOut = "C:\\Users\\doytc\\IdeaProjects\\Java Advanced\\src\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\out5.txt";
        List<String> lines = Files.readAllLines(path);
        Collections.sort(lines);
        BufferedWriter writer = new BufferedWriter(new FileWriter(pathOut));
        lines.forEach(line -> {
            if (!line.equals("")) {
                try {
                    writer.write(line);
                    writer.newLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        writer.close();
    }
}
