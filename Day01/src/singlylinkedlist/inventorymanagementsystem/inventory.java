package singlylinkedlist.inventorymanagementsystem;

class Inventory {
    private Item head;

    // Add item at the beginning
    public void addAtBeginning(int itemId, String itemName, int quantity, double price) {
        Item newItem = new Item(itemId, itemName, quantity, price);
        newItem.next = head;
        head = newItem;
    }

    // Add item at the end
    public void addAtEnd(int itemId, String itemName, int quantity, double price) {
        Item newItem = new Item(itemId, itemName, quantity, price);
        if (head == null) {
            head = newItem;
            return;
        }
        Item temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newItem;
    }

    // Add item at a specific position
    public void addAtPosition(int itemId, String itemName, int quantity, double price, int position) {
        if (position <= 1) {
            addAtBeginning(itemId, itemName, quantity, price);
            return;
        }
        Item newItem = new Item(itemId, itemName, quantity, price);
        Item temp = head;
        int count = 1;
        while (count < position - 1 && temp != null) {
            temp = temp.next;
            count++;
        }
        if (temp == null) {
            addAtEnd(itemId, itemName, quantity, price);
            return;
        }
        newItem.next = temp.next;
        temp.next = newItem;
    }

    // Remove item by ID
    public void removeById(int itemId) {
        if (head == null) return;
        if (head.itemId == itemId) {
            head = head.next;
            return;
        }
        Item temp = head;
        while (temp.next != null && temp.next.itemId != itemId) {
            temp = temp.next;
        }
        if (temp.next != null) {
            temp.next = temp.next.next;
        }
    }

    // Update item quantity by ID
    public void updateQuantity(int itemId, int newQuantity) {
        Item temp = head;
        while (temp != null) {
            if (temp.itemId == itemId) {
                temp.quantity = newQuantity;
                return;
            }
            temp = temp.next;
        }
    }

    // Search item by ID or Name
    public void searchItem(int itemId, String itemName) {
        Item temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.itemId == itemId || temp.itemName.equalsIgnoreCase(itemName)) {
                System.out.println("Item ID: " + temp.itemId + ", Name: " + temp.itemName + ", Quantity: " + temp.quantity + ", Price: " + temp.price);
                found = true;
            }
            temp = temp.next;
        }
        if (!found) System.out.println("Item not found");
    }

    // Calculate total inventory value
    public double totalInventoryValue() {
        double total = 0;
        Item temp = head;
        while (temp != null) {
            total += temp.quantity * temp.price;
            temp = temp.next;
        }
        return total;
    }

    // Display all items
    public void display() {
        Item temp = head;
        while (temp != null) {
            System.out.println("Item ID: " + temp.itemId + ", Name: " + temp.itemName + ", Quantity: " + temp.quantity + ", Price: " + temp.price);
            temp = temp.next;
        }
    }

    // Sort inventory by name (Bubble Sort)
    public void sortByName() {
        if (head == null || head.next == null) return;
        boolean swapped;
        do {
            swapped = false;
            Item temp = head;
            while (temp.next != null) {
                if (temp.itemName.compareToIgnoreCase(temp.next.itemName) > 0) {
                    swap(temp, temp.next);
                    swapped = true;
                }
                temp = temp.next;
            }
        } while (swapped);
    }

    // Sort inventory by price (Bubble Sort)
    public void sortByPrice() {
        if (head == null || head.next == null) return;
        boolean swapped;
        do {
            swapped = false;
            Item temp = head;
            while (temp.next != null) {
                if (temp.price > temp.next.price) {
                    swap(temp, temp.next);
                    swapped = true;
                }
                temp = temp.next;
            }
        } while (swapped);
    }

    // Swap two items
    private void swap(Item a, Item b) {
        int tempId = a.itemId;
        String tempName = a.itemName;
        int tempQty = a.quantity;
        double tempPrice = a.price;

        a.itemId = b.itemId;
        a.itemName = b.itemName;
        a.quantity = b.quantity;
        a.price = b.price;

        b.itemId = tempId;
        b.itemName = tempName;
        b.quantity = tempQty;
        b.price = tempPrice;
    }
}
