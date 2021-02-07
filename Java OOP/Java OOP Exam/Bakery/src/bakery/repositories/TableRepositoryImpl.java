package bakery.repositories;

import bakery.entities.tables.interfaces.Table;
import bakery.repositories.interfaces.TableRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

public class TableRepositoryImpl implements TableRepository<Table> {
    private Collection<Table> models;

    public TableRepositoryImpl() {
        models = new ArrayList<>();
    }

    @Override
    public Collection<Table> getAll() {
        return this.models;
    }

    @Override
    public void add(Table table) {
        this.models.add(table);
    }

    @Override
    public Table getByNumber(int number) {
        for (Table model : this.models) {
            if (model.getTableNumber() == number) {
                return model;
            }
        }
        return null;
    }
}
