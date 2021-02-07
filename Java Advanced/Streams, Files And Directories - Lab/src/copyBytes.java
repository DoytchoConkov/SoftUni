import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class copyBytes {
    public static void main(String[] args) {
        String path = "C:\\Users\\doytc\\IdeaProjects\\Java Advanced\\src\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String outPath = "C:\\Users\\doytc\\IdeaProjects\\Java Advanced\\src\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\out2.txt";
        String punctuation = "!,.?";
        try {
            FileInputStream file = null;
            try {
                file = new FileInputStream(path);
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }
            FileOutputStream outputFile = null;
            try {
                outputFile = new FileOutputStream(outPath);
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }
            int oneByte = file.read();
            while ((oneByte >= 0)) {
                String charInDigits = String.valueOf(oneByte);
                if (oneByte == 10 || oneByte == 32) {
                    outputFile.write(oneByte);
                } else {
                    for (int i = 0; i < charInDigits.length(); i++) {
                        outputFile.write(charInDigits.charAt(i));
                    }
                }
                oneByte = file.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}