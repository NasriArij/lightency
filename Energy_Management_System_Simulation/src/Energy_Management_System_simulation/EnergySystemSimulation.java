package Energy_Management_System_simulation;

import java.util.ArrayList;
import java.util.List;


abstract class Component {
 abstract String getDetails();
}


class Battery extends Component {
 private int capacity;

 public Battery(int capacity) {
     this.capacity = capacity;
 }

 @Override
 String getDetails() {
     return "Battery - Capacity: " + capacity + " kWh";
 }

 public int getCapacity() {
     return capacity;
 }
}

class SolarPanel extends Component {
 private int power;

 public SolarPanel(int power) {
     this.power = power;
 }

 @Override
 String getDetails() {
     return "Solar Panel - Power: " + power + " kW";
 }

 public int generatePower() {
          return power;
 }
}

class EnergyManager {
 private List<Component> components = new ArrayList<>();

 public void addComponent(Component component) {
     components.add(component);
 }

 public void removeComponent(Component component) {
     components.remove(component);
 }

 public int calculateTotalCapacity() {
     int totalCapacity = 0;
     for (Component component : components) {
         if (component instanceof Battery) {
             totalCapacity += ((Battery) component).getCapacity();
         }
     }
     return totalCapacity;
 }

public List<Component> getComponents() {
    return components;
}
}


public class EnergySystemSimulation {
 public static void main(String[] args) {
     EnergyManager energyManager = new EnergyManager();

     Battery battery1 = new Battery(100);
     Battery battery2 = new Battery(150);
     SolarPanel solarPanel1 = new SolarPanel(50);

     energyManager.addComponent(battery1);
     energyManager.addComponent(battery2);
     energyManager.addComponent(solarPanel1);

         for (Component component : energyManager.getComponents()) {
         System.out.println(component.getDetails());
     }

     int totalCapacity = energyManager.calculateTotalCapacity();
     System.out.println("Total Battery Capacity: " + totalCapacity + " kWh");
 }
}