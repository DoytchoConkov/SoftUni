package bakery.repositories;

import bakery.entities.drinks.interfaces.Drink;
import bakery.repositories.interfaces.DrinkRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

public class DrinkRepositoryImpl implements DrinkRepository<Drink> {
    private Collection<Drink> models;

    public DrinkRepositoryImpl() {
        models = new ArrayList<>();
    }

    @Override
    public Drink getByNameAndBrand(String drinkName, String drinkBrand) {
        for (Drink model : this.models) {
            if (model.getName().equals(drinkName) && model.getBrand().equals(drinkBrand)) {
                return model;
            }
        }
        return null;
    }

    @Override
    public Collection<Drink> getAll() {
        return this.models;
    }

    @Override
    public void add(Drink drink) {
        this.models.add(drink);
    }
}
