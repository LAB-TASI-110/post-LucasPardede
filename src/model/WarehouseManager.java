package model;

/**
 * Class model untuk mengelola logika bisnis inventaris gudang.
 */
public class WarehouseManager {
    
    // Kompleksitas Waktu: O(N)
    public int calculateTotalStock(StockItem[] stocks, String targetCategory) {
        int totalStock = 0;
        
        // Iterasi melalui array objek StockItem
        for (int i = 0; i < stocks.length; i++) {
            // Gunakan equalsIgnoreCase agar "Minyak" dan "minyak" dianggap sama
            if (stocks[i].getCategory().equalsIgnoreCase(targetCategory)) {
                totalStock += stocks[i].getQuantity(); 
            }
        }
        
        return totalStock;
    }
}