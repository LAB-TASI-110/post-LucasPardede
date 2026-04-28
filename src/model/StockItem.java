package model;

/**
 * Class model untuk merepresentasikan satu entitas stok barang.
 */
public class StockItem {
    private String category;
    private int quantity;

    // Constructor
    public StockItem(String category, int quantity) {
        this.category = category;
        this.quantity = quantity;
    }

    // Getter methods
    public String getCategory() {
        return category;
    }

    public int getQuantity() {
        return quantity;
    }
}