package bakery.entities.tables;

import bakery.entities.bakedFoods.interfaces.BakedFood;
import bakery.entities.drinks.interfaces.Drink;
import bakery.entities.tables.interfaces.Table;

import java.util.ArrayList;
import java.util.Collection;

import static bakery.common.ExceptionMessages.INVALID_NUMBER_OF_PEOPLE;
import static bakery.common.ExceptionMessages.INVALID_TABLE_CAPACITY;

public abstract class BaseTable implements Table {
    private Collection<BakedFood> foodOrders;
    private Collection<Drink> drinkOrders;
    private int tableNumber;
    private int capacity;
    private int numberOfPeople;
    private double pricePerPerson;
    private boolean isReserved;
    private double price;

    public BaseTable(int tableNumber, int capacity, double pricePerPerson) {
        this.setTableNumber(tableNumber);
        this.setCapacity(capacity);
        this.setPricePerPerson(pricePerPerson);
        this.foodOrders = new ArrayList<>();
        this.drinkOrders = new ArrayList<>();
        this.numberOfPeople = 0;
        this.isReserved = false;
        this.price = 0;
    }

    private void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    private void setCapacity(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException(INVALID_TABLE_CAPACITY);
        }
        this.capacity = capacity;
    }

    private void setNumberOfPeople(int numberOfPeople) {
        if (numberOfPeople <= 0) {
            throw new IllegalArgumentException(INVALID_NUMBER_OF_PEOPLE);
        }
        this.numberOfPeople = numberOfPeople;
        this.isReserved = true;
    }

    private void setPricePerPerson(double pricePerPerson) {
        this.pricePerPerson = pricePerPerson;
    }

    @Override
    public int getTableNumber() {
        return this.tableNumber;
    }

    @Override
    public int getCapacity() {
        return this.capacity;
    }

    @Override
    public int getNumberOfPeople() {
        return this.numberOfPeople;
    }

    @Override
    public double getPricePerPerson() {
        return this.pricePerPerson;
    }

    @Override
    public boolean isReserved() {
        return this.isReserved;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public void reserve(int numberOfPeople) {

        this.setNumberOfPeople(numberOfPeople);
    }

    @Override
    public void orderFood(BakedFood food) {
        this.foodOrders.add(food);
        this.price += food.getPrice();
    }

    @Override
    public void orderDrink(Drink drink) {
        this.drinkOrders.add(drink);
        this.price += drink.getPrice();
    }

    @Override
    public double getBill() {
        double bill = 0;
        bill += this.numberOfPeople * this.pricePerPerson;
        for (BakedFood foodOrder : this.foodOrders) {
            bill += foodOrder.getPrice();
        }
        for (Drink drinkOrder : this.drinkOrders) {
            bill += drinkOrder.getPrice();
        }

        this.price = bill;
        return bill;
    }

    @Override
    public void clear() {
        this.drinkOrders = new ArrayList<>();
        this.foodOrders = new ArrayList<>();
        this.price = 0;
        this.numberOfPeople = 0;
        this.isReserved = false;

    }

    @Override
    public String getFreeTableInfo() {
        StringBuilder result = new StringBuilder();
        result.append(String.format("Table: %d", this.getTableNumber())).append(System.lineSeparator());
        result.append(String.format("Type: %s", this.getClass().getSimpleName())).append(System.lineSeparator());
        result.append(String.format("Capacity: %d", this.getCapacity())).append(System.lineSeparator());
        result.append(String.format("Price per Person: %.2f", this.getPricePerPerson())).append(System.lineSeparator());
        return result.toString().trim();
    }


}
