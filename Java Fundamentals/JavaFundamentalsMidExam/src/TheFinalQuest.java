import java.util.*;
import java.util.stream.Collectors;

public class TheFinalQuest {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<String> words = Arrays.stream(scan.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        String input = scan.nextLine();
        while (!"Stop".equals(input)) {
            String[] token = input.split("\\s+");
            switch (token[0]) {
                case "Delete": {
                    int index = Integer.parseInt(token[1]) + 1;
                    if (index >= 0 && index < words.size()) {
                        words.remove(index);
                    }
                }
                break;
                case "Swap":
                    if (words.contains(token[1]) && words.contains(token[2])) {
                        int index1 = 0;
                        int index2 = 0;
                        for (int i = 0; i < words.size(); i++) {
                            if (words.get(i).equals(token[1])) {
                                index1 = i;
                            }
                            if (words.get(i).equals(token[2])) {
                                index2 = i;
                            }
                        }
                        String temp = words.get(index1);
                        words.set(index1, words.get(index2));
                        words.set(index2, temp);
                    }
                    break;
                case "Put": {
                    int index = Integer.parseInt(token[2]) - 1;
                    if (index >= 0 && index <= words.size()) {
                        words.add(index, token[1]);
                    }
                }
                break;
                case "Sort":
                    Collections.sort(words);
                    Collections.reverse(words);
                    break;
                case "Replace":
                    for (int i = 0; i < words.size(); i++) {
                        if (words.get(i).equals(token[2])) {
                            words.set(i, token[1]);
                        }
                    }
                    break;
            }
            input = scan.nextLine();
        }
        System.out.println(words.toString().replaceAll("[\\[\\],]", ""));
    }
}
