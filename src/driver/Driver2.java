package driver;

import model.StockItem;
import model.WarehouseManager;
import java.util.Scanner;

public class Driver2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            System.out.print("N (Jumlah total data rak): ");
            // Menggunakan Integer.parseInt(scanner.nextLine()) untuk menghindari masalah "Enter" (newline) pada Scanner
            int n = Integer.parseInt(scanner.nextLine());
            
            if (n < 0) {
                System.out.println("Error: Jumlah data (N) tidak boleh negatif.");
                return;
            }
            
            // Deklarasi array dari objek StockItem
            StockItem[] stocks = new StockItem[n];
            
            System.out.println("--- Masukkan Deret Stok ---");
            for (int i = 0; i < n; i++) {
                System.out.print("Kategori Barang ke-" + (i+1) + " (Contoh: Minyak): ");
                String category = scanner.nextLine();
                
                System.out.print("Jumlah Stok " + category + " (Contoh: 120): ");
                int quantity = Integer.parseInt(scanner.nextLine());
                
                // Memasukkan objek baru ke dalam array
                stocks[i] = new StockItem(category, quantity);
                System.out.println("-");
            }
            
            System.out.print("Masukkan Kategori Target yang ingin dihitung: ");
            String targetCategory = scanner.nextLine();
            
            WarehouseManager manager = new WarehouseManager();
            int totalStock = manager.calculateTotalStock(stocks, targetCategory);
            
            System.out.println("\n>>> Total stok untuk kategori '" + targetCategory + "' adalah: " + totalStock + " pcs <<<");
            
        } catch (NumberFormatException e) {
            System.out.println("Error: Input angka tidak valid. Pastikan stok dan N berupa angka.");
        } finally {
            scanner.close();
        }
    }
}