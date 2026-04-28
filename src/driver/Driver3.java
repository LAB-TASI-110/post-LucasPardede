package driver;

import java.util.Scanner;
import java.util.ArrayList;
import model.Pesanan;

public class Driver3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Pesanan> keranjang = new ArrayList<>();

        System.out.print("Masukkan nama pelanggan: ");
        String nama = scanner.nextLine();

        // Terus menerima input sampai dimasukkan "---"
        while (true) {
            System.out.print("Kategori (makanan/minuman/atribut/print/fotocopy) atau ketik '---' untuk selesai: ");
            String kategori = scanner.nextLine();

            if (kategori.equals("---")) {
                break;
            }

            System.out.print("Detail yang dibeli (misal: bakwan tempe, jus, ngeprint 45 lembar): ");
            String detailItem = scanner.nextLine();

            System.out.print("Total harga untuk item ini (Rp): ");
            double harga = Double.parseDouble(scanner.nextLine());

            keranjang.add(new Pesanan(kategori, detailItem, harga));
            System.out.println(">> Item berhasil ditambahkan!\n");
        }

        // Hitung total belanjaan
        double totalTagihan = 0;
        for (Pesanan p : keranjang) {
            totalTagihan += p.getHarga();
        }

        System.out.println("\nTotal tagihan keseluruhan: Rp" + totalTagihan);
        System.out.print("Masukkan total uang yang dibayar (Rp): ");
        double uangDibayar = Double.parseDouble(scanner.nextLine());

        double kembalian = uangDibayar - totalTagihan;

        // Cetak Struk
        System.out.println("\n=========================================");
        System.out.println("          STRUK KAFETARIA IT DEL         ");
        System.out.println("           Samping Kantin Lama           ");
        System.out.println("=========================================");
        System.out.println("Nama Pelanggan : " + nama);
        System.out.println("-----------------------------------------");
        for (Pesanan p : keranjang) {
            // Format output agar rapi dan lurus
            System.out.printf("%-12s : %-15s | Rp%.2f\n", p.getKategori(), p.getDetailItem(), p.getHarga());
        }
        System.out.println("-----------------------------------------");
        System.out.printf("Total Tagihan  : Rp%.2f\n", totalTagihan);
        System.out.printf("Uang Dibayar   : Rp%.2f\n", uangDibayar);
        System.out.printf("Kembalian      : Rp%.2f\n", kembalian);
        System.out.println("=========================================");
        System.out.println("        Terima Kasih, Deltizen!          ");
        System.out.println("=========================================");

        scanner.close();
    }
}