import java.io.*;

public class mergeTwoFiles {
    public static void main(String[] args) throws IOException {
        String file1 = "C:\\Users\\doytc\\IdeaProjects\\Java Advanced\\src\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputOne.txt";
        String file2 = "C:\\Users\\doytc\\IdeaProjects\\Java Advanced\\src\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputTwo.txt";
        String result = "C:\\Users\\doytc\\IdeaProjects\\Java Advanced\\src\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\out3.txt";
        BufferedReader one = new BufferedReader(new FileReader(file1));
        BufferedReader two = new BufferedReader(new FileReader(file2));
        BufferedWriter writer = new BufferedWriter(new FileWriter(result));
        String line = one.readLine();

        while (line != null) {
            writer.write(line);
            writer.newLine();
            line = one.readLine();
        }
        line = two.readLine();
        while (line != null) {
            writer.write(line);
            writer.newLine();
            line = two.readLine();
        }
        writer.close();
    }
}
