package Songs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        List<Songs> songsList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] input = scan.nextLine().split("_");
            Songs song = new Songs();
            song.setTypeList(input[0]);
            song.setName(input[1]);
            song.setTime(input[2]);
            songsList.add(song);
        }
        String type = scan.nextLine();
        if (type.equals("all")) {
            for (Songs song : songsList) {
                System.out.println(song.getName());
            }
        } else {
            for (Songs song : songsList) {
                if (song.getTypeList().equals(type)) {
                    System.out.println(song.getName());
                }
            }
        }
    }
}