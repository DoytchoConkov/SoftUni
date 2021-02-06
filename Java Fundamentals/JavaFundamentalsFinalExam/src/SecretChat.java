import java.util.Scanner;

public class SecretChat {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StringBuilder masage = new StringBuilder();
        String input = scan.nextLine();
        masage.append(input);
        String comand = scan.nextLine();
        while (!"Reveal".equals(comand)) {
            String[] tokens = comand.split(":\\|:");
            switch (tokens[0]) {
                case "InsertSpace":
                    masage.insert(Integer.parseInt(tokens[1]), " ");
                    System.out.println(masage);
                    break;
                case "Reverse":
                    int deleteIndex = masage.indexOf(tokens[1]);
                    if (deleteIndex >= 0) {
                        masage.delete(deleteIndex, deleteIndex + tokens[1].length());
                        for (int i = tokens[1].length() - 1; i >= 0; i--) {
                            masage.append(tokens[1].charAt(i));
                        }
                    System.out.println(masage);
                    } else {
                        System.out.println("error");
                    }
                    break;
                case "ChangeAll":
                    int startIndex = masage.indexOf(tokens[1]);
                    while (startIndex >= 0) {
                        masage.delete(startIndex, startIndex + tokens[1].length());
                        masage.insert(startIndex, tokens[2]);
                        startIndex = masage.indexOf(tokens[1]);
                    }
                    System.out.println(masage);
                    break;
            }
            comand = scan.nextLine();
        }
        System.out.printf("You have a new text message: %s", masage);
    }
}
