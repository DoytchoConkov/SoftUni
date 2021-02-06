import java.util.Scanner;

public class GreaterOfTwoValues {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String typeObject = scan.nextLine();
        String object1 = scan.nextLine();
        String object2 = scan.nextLine();
        switch (typeObject) {
            case "int":
                System.out.println(getMax(Integer.parseInt(object1), Integer.parseInt(object2))); break;
            case "char":
                System.out.printf("%c",getMax(object1.charAt(0), object2.charAt(0))); break;
            case "string":
                if (getMax(object1, object2) >= 0) {
                    System.out.println(object1);
                } else  {
                    System.out.println(object2);
                }
                break;
        }
    }

    public static int getMax(int n1, int n2) {
        if (n1 > n2) {
            return n1;
        } else {
            return n2;
        }
    }

    public static int getMax(char n1, char n2) {
        if (n1 > n2) {
            return n1;
        } else {
            return n2;
        }
    }

    public static int getMax(String n1, String n2) {
        return n1.compareTo(n2);
    }
}
