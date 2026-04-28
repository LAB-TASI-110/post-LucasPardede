package driver;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import model.City;
import model.ShippingService;

public class Driver1 {
    public static void main(String[] args) {
        // Inisialisasi In-Memory Database tarif ongkir
        Map<String, City> cityDB = new HashMap<>();
        cityDB.put("MDN", new City("MDN", "Medan", 8000.0, false));
        cityDB.put("BLG", new City("BLG", "Balige", 5000.0, false));
        cityDB.put("JKT", new City("JKT", "Jakarta", 12000.0, true));
        cityDB.put("SBY", new City("SBY", "Surabaya", 13000.0, true));
        
        ShippingService shippingService = new ShippingService();
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            // Membaca input kode kota atau perintah END
            String inputCode = scanner.next();
            
            if (inputCode.equalsIgnoreCase("END")) {
                break;
            }
            
            // Membaca variabel x (berat basis)
            double x = scanner.nextDouble();
            
            // Validasi keberadaan kode kota di database
            City targetCity = cityDB.get(inputCode.toUpperCase());
            if (targetCity == null) {
                System.out.println("Error: Kode Kota tidak valid.\n");
                continue; 
            }
            
            // Eksekusi proses transaksi
            shippingService.processTransaction(targetCity, x);
        }
        
        scanner.close();
    }
}