import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class writeEveryThirdLine {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\doytc\\IdeaProjects\\Java Advanced\\src\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String pathOut = "C:\\Users\\doytc\\IdeaProjects\\Java Advanced\\src\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\out4.txt";
        BufferedReader inputFile = new BufferedReader(new FileReader(path));
        BufferedWriter writer = new BufferedWriter(new FileWriter(pathOut));
        Stream<String> lines = inputFile.lines();
        List<String > listLines= lines.collect(Collectors.toList());

        final int[] cnt = {0};
        listLines.stream().forEach(line -> {
            cnt[0]++;
            if (cnt[0] % 3 == 0) {
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
