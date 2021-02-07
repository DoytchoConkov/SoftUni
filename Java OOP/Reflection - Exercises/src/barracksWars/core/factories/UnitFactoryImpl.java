package barracksWars.core.factories;

import barracksWars.interfaces.Unit;
import barracksWars.interfaces.UnitFactory;
import barracksWars.models.units.AbstractUnit;
import jdk.jshell.spi.ExecutionControl;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class UnitFactoryImpl implements UnitFactory {

    private static final String UNITS_PACKAGE_NAME =
            "barracksWars.models.units.";

    @Override
    public Unit createUnit(String unitType) {
        try {
            Class<?> unit = Class.forName(UNITS_PACKAGE_NAME + unitType);
            try {
                Constructor<?> declaredConstructor = unit.getDeclaredConstructor();
                try {
                    Object objectUnit = declaredConstructor.newInstance();
                    if (objectUnit instanceof AbstractUnit) {
                        return (Unit) objectUnit;
                    }
                } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        throw new IllegalArgumentException("This is not an Unit!!!");
    }
}
