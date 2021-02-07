import java.io.File;

public class getFolderSize {
    public static void main(String[] args) {
        String path = "C:\\Users\\doytc\\IdeaProjects\\Java Advanced\\src\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources";
        File file = new File(path);
        int sum = 0;
        File[] files = file.listFiles();
        for (File f : files) {
            if (!f.isDirectory()) {
                sum += f.length();
            }
        }
        System.out.println("Folder size: " + sum);
    }
}
