package onlineShop.core;

import onlineShop.core.interfaces.Controller;
import onlineShop.models.products.BaseComputer;
import onlineShop.models.products.components.*;
import onlineShop.models.products.computers.Computer;
import onlineShop.models.products.computers.DesktopComputer;
import onlineShop.models.products.computers.Laptop;
import onlineShop.models.products.peripherals.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static onlineShop.common.constants.ExceptionMessages.*;
import static onlineShop.common.constants.OutputMessages.*;

public class ControllerImpl implements Controller {
    private Map<Integer, Computer> computers;

    public ControllerImpl() {

        this.computers = new HashMap<>();
    }

    @Override
    public String addComputer(String computerType, int id, String manufacturer, String model, double price) {
        Computer computer;
        if (this.computers.containsKey(id)) {
            throw new IllegalArgumentException(EXISTING_COMPUTER_ID);
        }
        if (computerType.equals("Laptop")) {
            computer = new Laptop(id, manufacturer, model, price);
        } else if (computerType.equals("DesktopComputer")) {
            computer = new DesktopComputer(id, manufacturer, model, price);
        } else {
            throw new IllegalArgumentException(INVALID_COMPUTER_TYPE);
        }
        this.computers.put(id, computer);
        return String.format(ADDED_COMPUTER, id);
    }

    @Override
    public String addPeripheral(int computerId, int id, String peripheralType, String manufacturer, String model, double price, double overallPerformance, String connectionType) {
        for (Peripheral peripheral : this.computers.get(computerId).getPeripherals()) {
            if (peripheral.getId() == id) {
                throw new IllegalArgumentException(EXISTING_PERIPHERAL_ID);
            }
        }
        Peripheral peripheral;
        if (peripheralType.equals("Headset")) {
            peripheral = new Headset(id, manufacturer, model, price, overallPerformance, connectionType);
        } else if (peripheralType.equals("Keyboard")) {
            peripheral = new Keyboard(id, manufacturer, model, price, overallPerformance, connectionType);
        } else if (peripheralType.equals("Monitor")) {
            peripheral = new Monitor(id, manufacturer, model, price, overallPerformance, connectionType);
        } else if (peripheralType.equals("Mouse")) {
            peripheral = new Mouse(id, manufacturer, model, price, overallPerformance, connectionType);
        } else {
            throw new IllegalArgumentException(INVALID_COMPONENT_TYPE);
        }
        this.computers.get(computerId).addPeripheral(peripheral);
        return String.format(ADDED_PERIPHERAL, peripheralType, id, computerId);
    }

    @Override
    public String removePeripheral(String peripheralType, int computerId) {
        Peripheral p=   this.computers.get(computerId).removePeripheral(peripheralType);
        System.out.println( p);
        return String.format(REMOVED_PERIPHERAL, peripheralType, p.getId());
    }

    @Override
    public String addComponent(int computerId, int id, String componentType, String manufacturer, String model, double price, double overallPerformance, int generation) {
        for (Component compn : this.computers.get(computerId).getComponents()) {
            if (compn.getId() == id) {
                throw new IllegalArgumentException(EXISTING_PERIPHERAL_ID);
            }
        }
        Component compne;
        if (componentType.equals("CentralProcessingUnit")) {
            compne = new CentralProcessingUnit(id, manufacturer, model, price, overallPerformance, generation);
        } else if (componentType.equals("Motherboard")) {
            compne = new Motherboard(id, manufacturer, model, price, overallPerformance, generation);
        } else if (componentType.equals("PowerSupply")) {
            compne = new PowerSupply(id, manufacturer, model, price, overallPerformance, generation);
        } else if (componentType.equals("RandomAccessMemory")) {
            compne = new RandomAccessMemory(id, manufacturer, model, price, overallPerformance, generation);
        } else if (componentType.equals("SolidStateDrive")) {
            compne = new SolidStateDrive(id, manufacturer, model, price, overallPerformance, generation);
        } else if (componentType.equals("VideoCard")) {
            compne = new VideoCard(id, manufacturer, model, price, overallPerformance, generation);
        } else {
            throw new IllegalArgumentException(INVALID_COMPONENT_TYPE);
        }
        this.computers.get(computerId).addComponent(compne);
        return String.format(ADDED_COMPONENT, componentType, id, computerId);
    }

    @Override
    public String removeComponent(String componentType, int computerId) {
      Component component=  this.computers.get(computerId).removeComponent(componentType);
        return String.format(REMOVED_COMPONENT, componentType, component.getId());
    }

    @Override
    public String buyComputer(int id) {
        Computer computer =this.computers.get(id);
        this.computers.remove(id);
        return computer.toString();
    }

    @Override
    public String BuyBestComputer(double budget) {


        return this.computers.values().stream().filter(c-> c.getPrice()<=budget).sorted((c1,c2)->{
            if (c2.getPrice() >= c1.getPrice()) return 1;
            else return -1;
        }).limit(1).toString();
    }

    @Override
    public String getComputerData(int id) {
        return this.computers.get(id).toString();
    }
}
