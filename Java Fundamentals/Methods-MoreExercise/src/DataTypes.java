import java.util.Scanner;

public class DataTypes {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String textType = scan.nextLine();
        String text = scan.nextLine();
        printResult(textType, text);
    }

    private static void printResult(String textType, String text) {
        switch (textType) {
            case "int":
                int intNumber = Integer.parseInt(text);
                System.out.println(intNumber * 2);
                break;
            case "real":
                double doubleNumber = Double.parseDouble(text);
                System.out.printf("%.2f", doubleNumber * 1.5);
                break;
            case "string":
                String result = String.format("$%s$", text);
                System.out.println(result);
                break;
        }
    }
}
