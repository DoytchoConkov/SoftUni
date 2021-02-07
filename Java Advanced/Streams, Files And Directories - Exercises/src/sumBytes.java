import java.io.*;

public class sumBytes {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\doytc\\IdeaProjects\\Java Advanced\\src\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        String pathOut = "C:\\Users\\doytc\\IdeaProjects\\Java Advanced\\src\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\out.txt";
        BufferedReader reader = new BufferedReader(new FileReader(path));
        String line = reader.readLine();
        PrintWriter writer = new PrintWriter(new FileWriter(pathOut));
        while (line != null) {
            writer.println(line.toUpperCase());
            line = reader.readLine();
        }
        writer.close();
    }
}
