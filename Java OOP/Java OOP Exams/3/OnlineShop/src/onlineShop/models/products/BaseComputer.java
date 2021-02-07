package onlineShop.models.products;

import onlineShop.models.products.components.Component;
import onlineShop.models.products.computers.Computer;
import onlineShop.models.products.peripherals.Peripheral;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static onlineShop.common.constants.ExceptionMessages.*;

public abstract class BaseComputer extends BaseProduct implements Computer {
    private List<Component> components;
    private List<Peripheral> peripherals;

    protected BaseComputer(int id, String manufacturer, String model, double price, double overallPerformance) {
        super(id, manufacturer, model, price, overallPerformance);
        this.components = new ArrayList<>();
        this.peripherals = new ArrayList<>();
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(String.format("Overall Performance: %.2f. Price: %.2f - %s: %s %s (Id: %d)",
                this.getOverallPerformance(), this.getPrice(), this.getClass().getSimpleName(), this.getManufacturer(), this.getModel(), this.getId()));
        sb.append(System.lineSeparator());
        sb.append(String.format(" Components (%d):", this.components.size()));
        sb.append(System.lineSeparator());
        for (Component component : this.components) {
            sb.append(String.format("  %s", component.toString()));
            sb.append(System.lineSeparator());
        }
        sb.append(String.format(" Peripherals (%d); Average Overall Performance (%.2f):", this.peripherals.size(),this.getOverallPerformance()));
        sb.append(System.lineSeparator());
        for (Peripheral peripheral : this.peripherals) {
            sb.append(String.format("  %s", peripheral.toString()));
            sb.append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
    @Override
    public void addComponent(Component component) {
        List<Component> isFind = this.components.stream().filter(c -> c.getClass().getSimpleName().equals(component.getClass().getSimpleName())).collect(Collectors.toList());
        if (isFind.size() != 0) {
            throw new IllegalArgumentException(String.format(EXISTING_COMPONENT, component.getClass().getSimpleName(), this.getClass().getSimpleName(), this.getId()));
        }
        this.components.add(component);
    }

    @Override
    public Component removeComponent(String componentType) {
        List<Component> isFind = this.components.stream().filter(c -> c.getClass().getSimpleName().equals(componentType)).collect(Collectors.toList());
        if (isFind.size() == 0) {
            throw new IllegalArgumentException(String.format(NOT_EXISTING_COMPONENT, componentType, this.getClass().getSimpleName(), this.getId()));
        }
        this.components.remove(isFind.get(0));
        return isFind.get(0);
    }

    @Override
    public void addPeripheral(Peripheral peripheral) {
        List<Peripheral> isFind = this.peripherals.stream().filter(c -> c.getClass().getSimpleName().equals(peripheral.getClass().getSimpleName())).collect(Collectors.toList());
        if (isFind.size() != 0) {
            throw new IllegalArgumentException(String.format(EXISTING_PERIPHERAL, peripheral.getClass().getSimpleName(), this.getClass().getSimpleName(), this.getId()));
        }
        this.peripherals.add(peripheral);
    }

    @Override
    public Peripheral removePeripheral(String peripheralType) {
        List<Peripheral> isFind = this.peripherals.stream().filter(c -> c.getClass().getSimpleName().equals(peripheralType)).collect(Collectors.toList());
        if (isFind.size() == 0) {
            throw new IllegalArgumentException(String.format(NOT_EXISTING_PERIPHERAL, peripheralType, this.getClass().getSimpleName(), this.getId()));
        }
        this.peripherals.remove(isFind.get(0));
        return isFind.get(0);
    }


    @Override
    public List<Component> getComponents() {
        return this.components;
    }

    @Override
    public List<Peripheral> getPeripherals() {
        return this.peripherals;
    }

    @Override
    public double getPrice() {
        double sum = super.getPrice();
        for (Component component : this.components) {
            sum += component.getPrice();
        }
        for (Peripheral peripheral : this.peripherals) {
            sum += peripheral.getPrice();
        }
        return sum;
    }

    @Override
    public double getOverallPerformance() {
        double result = super.getOverallPerformance();
        double avrComp = 0;
        double avrPer = 0;
        for (Component component : this.components) {
            avrComp += component.getOverallPerformance();
        }
        for (Peripheral peripheral : this.peripherals) {
            avrPer += peripheral.getOverallPerformance();
        }
        return result + avrComp / this.components.size() + avrPer / this.peripherals.size();
    }
}
