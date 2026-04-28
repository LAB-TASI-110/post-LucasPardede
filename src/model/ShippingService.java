package model;

public class ShippingService {
    
    // Menggunakan konstanta agar mudah disesuaikan jika aturan bisnis berubah
    private static final double DISCOUNT_THRESHOLD_KG = 10.0;
    private static final double DISCOUNT_RATE = 0.10;
    
    public void processTransaction(City city, double x) {
        // 1. Kalkulasi Berat sesuai rumus
        double wB = x + 1.0;
        double wU = 1.5 * wB;
        double totalWeight = wB + wU;
        
        // 2. Kalkulasi Biaya Dasar
        double baseCost = totalWeight * city.getPricePerKg();
        
        // 3. Pengecekan Syarat Promo
        double discountAmount = 0.0;
        boolean getsDiscount = false;
        boolean getsInsurance = city.isOuterIsland();
        
        if (totalWeight > DISCOUNT_THRESHOLD_KG) {
            discountAmount = baseCost * DISCOUNT_RATE;
            getsDiscount = true;
        }
        
        double finalCost = baseCost - discountAmount;
        
        // 4. Penentuan String Informasi Promo
        String promoInfo = "Tanpa Promo";
        if (getsDiscount && getsInsurance) {
            promoInfo = "Diskon 10% & Asuransi Gratis";
        } else if (getsDiscount) {
            promoInfo = "Diskon 10%";
        } else if (getsInsurance) {
            promoInfo = "Asuransi Gratis";
        }
        
        printReceipt(city.getName(), wB, wU, totalWeight, finalCost, promoInfo);
    }
    
    private void printReceipt(String cityName, double wB, double wU, double totalWeight, double finalCost, String promoInfo) {
        System.out.println("=========================================");
        System.out.println("          STRUK PEMBAYARAN DEL-EXPRESS   ");
        System.out.println("=========================================");
        System.out.printf("Kota Tujuan         : %s%n", cityName);
        System.out.printf("Berat Paket Butet   : %.2f kg%n", wB);
        System.out.printf("Berat Paket Ucok    : %.2f kg%n", wU);
        System.out.printf("Total Berat         : %.2f kg%n", totalWeight);
        System.out.println("-----------------------------------------");
        System.out.printf("Total Ongkos Kirim  : Rp %.0f%n", finalCost);
        System.out.printf("Informasi Promo     : %s%n", promoInfo);
        System.out.println("=========================================\n");
    }
}