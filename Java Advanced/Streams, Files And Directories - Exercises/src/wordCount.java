import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class wordCount {
    public static void main(String[] args) throws IOException {
        String pathWords = "C:\\Users\\doytc\\IdeaProjects\\Java Advanced\\src\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\words.txt";
        String pathText = "C:\\Users\\doytc\\IdeaProjects\\Java Advanced\\src\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\text.txt";
        String pathOut = "C:\\Users\\doytc\\IdeaProjects\\Java Advanced\\src\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\out2.txt";
        BufferedReader reader = new BufferedReader(new FileReader(pathWords));
        BufferedReader text = new BufferedReader(new FileReader(pathText));
        BufferedWriter writer = new BufferedWriter(new FileWriter(pathOut));
        Map<String, Integer> words = new LinkedHashMap<>();
        String line = reader.readLine();
        while (line != null) {
            String[] wordsArray = line.split("\\s+");
            for (String s : wordsArray) {
                words.put(s, 0);
            }
            line = reader.readLine();
        }

        line = text.readLine();
        while (line != null) {
            line = line.replaceAll(",", "");
            String[] wordsArray = line.split("\\s+");
            for (String s : wordsArray) {
                if (words.containsKey(s)) {
                    words.put(s, words.get(s) + 1);
                }
            }
            line = text.readLine();
        }
        words.entrySet().stream().forEach(e -> {
            try {
                writer.write(String.format("%s - %s%n", e.getKey(), e.getValue()));
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });
        writer.close();
    }
}
