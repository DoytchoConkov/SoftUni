package harvestingFields;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        while (!input.equals("HARVEST")) {

            Class richSoiland = RichSoilLand.class;
            Field[] fields = richSoiland.getDeclaredFields();
            switch (input) {
                case "public":
                    for (Field field : fields) {
                        if (Modifier.isPublic(field.getModifiers())) {
                            System.out.printf("public %s %s%n", field.getType().getSimpleName(), field.getName());
                        }
                    }
                    break;
                case "private":
                    for (Field field : fields) {
                        if (Modifier.isPrivate(field.getModifiers())) {
                            System.out.printf("private %s %s%n", field.getType().getSimpleName(), field.getName());
                        }
                    }
                    break;
                case "protected":
                    for (Field field : fields) {
                        if (Modifier.isProtected(field.getModifiers())) {
                            System.out.printf("protected %s %s%n", field.getType().getSimpleName(), field.getName());
                        }
                    }
                    break;
                case "all":
                    for (Field field : fields) {
                        System.out.printf("%s %s %s%n", Modifier.toString(field.getModifiers()),field.getType().getSimpleName(), field.getName());
                    }
                    break;
            }


            input = scan.nextLine();
        }

        // <access modifier> <field type> <field name>
    }
}
