package StrategyPattern;

import java.util.Comparator;

public class PersonByName implements Comparator<Person> {

    @Override
    public int compare(Person a, Person b) {
        int result = a.getName().length() - b.getName().length();
        if (result == 0) {
            result = Character.toUpperCase(a.getName().charAt(0)) - Character.toUpperCase(b.getName().charAt(0));
        }

        return result;
    }
}
