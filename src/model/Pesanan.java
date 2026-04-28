package model;

public class Pesanan {
    private String kategori;
    private String detailItem;
    private double harga;

    public Pesanan(String kategori, String detailItem, double harga) {
        this.kategori = kategori;
        this.detailItem = detailItem;
        this.harga = harga;
    }

    public String getKategori() {
        return this.kategori;
    }

    public String getDetailItem() {
        return this.detailItem;
    }

    public double getHarga() {
        return this.harga;
    }
}