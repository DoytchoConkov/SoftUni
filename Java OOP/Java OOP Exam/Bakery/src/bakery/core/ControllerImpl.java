package bakery.core;

import bakery.common.ExceptionMessages;
import bakery.common.OutputMessages;
import bakery.core.interfaces.Controller;
import bakery.entities.bakedFoods.BaseFood;
import bakery.entities.bakedFoods.Bread;
import bakery.entities.bakedFoods.Cake;
import bakery.entities.bakedFoods.interfaces.BakedFood;
import bakery.entities.drinks.BaseDrink;
import bakery.entities.drinks.Tea;
import bakery.entities.drinks.Water;
import bakery.entities.drinks.interfaces.Drink;
import bakery.entities.tables.BaseTable;
import bakery.entities.tables.InsideTable;
import bakery.entities.tables.OutsideTable;
import bakery.entities.tables.interfaces.Table;
import bakery.repositories.interfaces.*;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static bakery.common.ExceptionMessages.FOOD_OR_DRINK_EXIST;
import static bakery.common.ExceptionMessages.TABLE_EXIST;
import static bakery.common.OutputMessages.*;

public class ControllerImpl implements Controller {
    private FoodRepository<BakedFood> foodStore;
    private DrinkRepository<Drink> drinkStore;
    private TableRepository<Table> tableStore;
    private double totalIncome;

    public ControllerImpl(FoodRepository<BakedFood> foodRepository, DrinkRepository<Drink> drinkRepository, TableRepository<Table> tableRepository) {
        this.foodStore = foodRepository;
        this.drinkStore = drinkRepository;
        this.tableStore = tableRepository;
        this.totalIncome = 0;
    }


    @Override
    public String addFood(String type, String name, double price) {
        BaseFood food;
        BakedFood haveFood = foodStore.getByName(name);
        if (haveFood != null) {
            throw new IllegalArgumentException(String.format(FOOD_OR_DRINK_EXIST, type, name));
        }
        if ("Bread".equals(type)) {
            food = new Bread(name, price);
        } else {
            food = new Cake(name, price);
        }
        this.foodStore.add(food);
        return String.format(FOOD_ADDED,name, type);
    }

    @Override
    public String addDrink(String type, String name, int portion, String brand) {
        BaseDrink drink;
        Drink haveDrink = drinkStore.getByNameAndBrand(name, brand);
        if (haveDrink != null) {
            throw new IllegalArgumentException(String.format(FOOD_OR_DRINK_EXIST, type, name));
        }
        if ("Tea".equals(type)) {
            drink = new Tea(name, portion, brand);
        } else {
            drink = new Water(name, portion, brand);
        }
        this.drinkStore.add(drink);
        return String.format(DRINK_ADDED, name,brand);
    }

    @Override
    public String addTable(String type, int tableNumber, int capacity) {
        BaseTable table;
        Table haveTable = tableStore.getByNumber(tableNumber);
        if (haveTable != null) {
            throw new IllegalArgumentException(String.format(TABLE_EXIST, tableNumber));
        }
        if ("InsideTable".equals(type)) {
            table = new InsideTable(tableNumber, capacity);
        } else {
            table = new OutsideTable(tableNumber, capacity);
        }
        this.tableStore.add(table);
        return String.format(TABLE_ADDED, tableNumber);
    }

    @Override
    public String reserveTable(int numberOfPeople) {
        List<Table> tables = this.tableStore.getAll().stream().filter(t -> t.getCapacity() >= numberOfPeople && !t.isReserved()).sorted(Comparator.comparingInt(Table::getCapacity)).collect(Collectors.toList());
        if (tables.isEmpty()) {
            return String.format(RESERVATION_NOT_POSSIBLE, numberOfPeople);
        }
        tables.get(0).reserve(numberOfPeople);
        return String.format(TABLE_RESERVED, tables.get(0).getTableNumber(), numberOfPeople);
    }

    @Override
    public String orderFood(int tableNumber, String foodName) {
        Table haveTable = tableStore.getByNumber(tableNumber);
        if (haveTable == null||!haveTable.isReserved()) {
            return String.format(WRONG_TABLE_NUMBER, tableNumber);
        }
        BakedFood haveFood = foodStore.getByName(foodName);
        if (haveFood == null) {
            return String.format(NONE_EXISTENT_FOOD, foodName);
        }
        haveTable.orderFood(haveFood);
        return String.format(FOOD_ORDER_SUCCESSFUL, tableNumber, foodName);
    }

    @Override
    public String orderDrink(int tableNumber, String drinkName, String drinkBrand) {
        Table haveTable = tableStore.getByNumber(tableNumber);
        if (haveTable == null||!haveTable.isReserved()) {
            return String.format(WRONG_TABLE_NUMBER, tableNumber);
        }
        Drink haveDrink = drinkStore.getByNameAndBrand(drinkName, drinkBrand);
        if (haveDrink == null) {
            return String.format(NON_EXISTENT_DRINK, drinkName, drinkBrand);
        }
        haveTable.orderDrink(haveDrink);
        return String.format(DRINK_ORDER_SUCCESSFUL, tableNumber, drinkName, drinkBrand);
    }

    @Override
    public String leaveTable(int tableNumber) {
        Table haveTable = tableStore.getByNumber(tableNumber);
        if (haveTable == null||!haveTable.isReserved()) {
            return String.format(WRONG_TABLE_NUMBER, tableNumber);
        }
        double bill = tableStore.getByNumber(tableNumber).getBill();
        this.totalIncome+=bill;
        tableStore.getByNumber(tableNumber).clear();
        return String.format(BILL, tableNumber, bill);
    }

    @Override
    public String getFreeTablesInfo() {
        StringBuilder result = new StringBuilder();
        for (Table table : tableStore.getAll()) {
            if (!table.isReserved()) {
                result.append(table.getFreeTableInfo()).append(System.lineSeparator());
            }
        }
        return result.toString().trim();
    }

    @Override
    public String getTotalIncome() {


        return String.format(TOTAL_INCOME, this.totalIncome);
    }
}
