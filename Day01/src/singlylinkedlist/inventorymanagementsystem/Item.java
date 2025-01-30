package singlylinkedlist.inventorymanagementsystem;

class Item {
    String itemName;
    int itemId;
    int quantity;
    double price;
    Item next;

    public Item(int itemId, String itemName, int quantity, double price) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }
}