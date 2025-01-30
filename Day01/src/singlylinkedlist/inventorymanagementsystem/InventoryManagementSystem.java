package singlylinkedlist.inventorymanagementsystem;

public class InventoryManagementSystem {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        inventory.addAtEnd(101, "Laptop", 10, 50000);
        inventory.addAtEnd(102, "Mouse", 50, 500);
        inventory.addAtBeginning(103, "Keyboard", 30, 1500);
        inventory.addAtPosition(104, "Monitor", 20, 10000, 2);

        System.out.println("Inventory Items:");
        inventory.display();

        System.out.println("\nTotal Inventory Value: " + inventory.totalInventoryValue());

        System.out.println("\nSorting by Name:");
        inventory.sortByName();
        inventory.display();

        System.out.println("\nSorting by Price:");
        inventory.sortByPrice();
        inventory.display();
    }
}
