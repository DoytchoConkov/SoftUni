package blackBoxInteger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        BlackBoxInt blackBoxInt = null;
        try {
            Constructor declaredConstructor = BlackBoxInt.class.getDeclaredConstructor();
            declaredConstructor.setAccessible(true);
            blackBoxInt = (BlackBoxInt) declaredConstructor.newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        Method[] declaredMethods = BlackBoxInt.class.getDeclaredMethods();
        Map<String, Method> declaredMethodsMap = new LinkedHashMap<>();
        for (Method declaredMethod : declaredMethods) {
            declaredMethodsMap.putIfAbsent(declaredMethod.getName(), declaredMethod);
        }
        String input = scan.nextLine();
        while (!input.equals("END")) {
            String[] token = input.split("_");
            String command = token[0];
            int value = Integer.parseInt(token[1]);
            declaredMethodsMap.get(command).setAccessible(true);
            Method method = declaredMethodsMap.get(command);
            method.setAccessible(true);
            try {
                method.invoke(blackBoxInt, value);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            Field declaredField = blackBoxInt.getClass().getDeclaredFields()[1];
            declaredField.setAccessible(true);
            try {
                System.out.println(declaredField.getInt(blackBoxInt));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            input = scan.nextLine();
        }
    }
}
