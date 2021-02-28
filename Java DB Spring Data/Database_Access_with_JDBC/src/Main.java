import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Main {
    public static void main(String[] args) throws IOException, SQLException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Welcome to 'Exercises: Introduction to DB Apps'");
        System.out.println();
        System.out.print("Please enter your username (<Enter> for 'root'): ");
        String user = reader.readLine();
        if (user.equals("")) {
            user = "root";
        }
        System.out.print("Please enter your password (<Enter> for '1234'): ");
        String password = reader.readLine();
        if (password.equals("")) {
            password = "1234";
        }

        Homework homework = new Homework();
        homework.initialise(user, password);

        System.out.print("Please choose Ex number (2-9) or '0' for Exit : ");
        String exercise = reader.readLine();

        while (!"0".equals(exercise)) {
            switch (exercise) {
                case "2":
                    homework.getVillainsNames();
                    break;
                case "3":
                    System.out.println();
                    System.out.print("Please enter villain Id: ");
                    int minionId = Integer.parseInt(reader.readLine());
                    System.out.println();
                    homework.getMinionNames(minionId);
                    break;
                case "4":
                    homework.addMinion();
                    break;
                case "5":
                    homework.changeTownName();
                    break;
                case "6":
                    homework.removeillain();
                    break;
                case "7":
                    homework.printAllMinionsNames();
                    break;
                case "8":
                    homework.increaseMinionsAge();
                    break;
                case "9":
                    homework.increaseAgeProcedure();
                    break;
            }

            System.out.println();
            System.out.print("Please choose Ex number (2-9) or '0' for Exit : ");
            exercise = reader.readLine();
        }
        System.out.println();
        System.out.println("Good bye! See you soon :) !!!");
    }

}
