import java.io.File;
import java.util.ArrayDeque;
import java.util.Deque;

public class nestedFolders {
    public static void main(String[] args) {
        String path = "C:\\Users\\doytc\\IdeaProjects\\Java Advanced\\src\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams";
        File root = new File(path);
        Deque<File> directories = new ArrayDeque<>();
        directories.offer(root);
        int cnt = 1;
        while (!directories.isEmpty()) {
            File currentFile = directories.poll();
            File[] files = currentFile.listFiles();
            for (File file : files) {
                if (file.isDirectory()) {
                    directories.offer(file);
                    cnt++;
                }
            }
            System.out.println(currentFile.getName());

        }
        System.out.println(cnt + " folders");
    }
}
