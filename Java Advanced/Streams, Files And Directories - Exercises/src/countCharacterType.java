import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class countCharacterType {
    public static void main(String[] args) throws IOException {
        String puctoation = "!,.?";
        String vowels = "aeoui";
        String path = "C:\\Users\\doytc\\IdeaProjects\\Java Advanced\\src\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        BufferedReader reader = new BufferedReader(new FileReader(path));
        int vowelsCnt = 0;
        int puctoationCnt = 0;
        int others = 0;
        String line = reader.readLine();
        while (line != null) {
            line = line.replaceAll("\\s+", "");
            for (char c : line.toCharArray()) {
                if (vowels.contains(String.valueOf(c))) {
                    vowelsCnt++;
                } else if (puctoation.contains(String.valueOf(c))) {
                    puctoationCnt++;
                } else {
                    others++;
                }
            }
            line = reader.readLine();
        }
        System.out.printf("Vowels: %d%n", vowelsCnt);
        System.out.printf("Consonants: %d%n", others);
        System.out.printf("Punctuation: %d%n", puctoationCnt);
    }
}
