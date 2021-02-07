import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class writeToFile {
    public static void main(String[] args) {
        String path = "C:\\Users\\doytc\\IdeaProjects\\Java Advanced\\src\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
String outPath="C:\\Users\\doytc\\IdeaProjects\\Java Advanced\\src\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\out.txt";
        String puctoation="!,.?";
        try {
            FileInputStream file = new FileInputStream(path);
            FileOutputStream outputFile=new FileOutputStream(outPath);
            int oneByte = file.read();
            while ((oneByte >= 0)) {
                if (!puctoation.contains(String.valueOf((char) oneByte))) {
                    outputFile.write(oneByte);
                }
                oneByte = file.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}