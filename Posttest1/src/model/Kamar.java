package model;

public class Kamar {
    public int idKamar, lantai;
    public double harga;
    public boolean is_disewakan;

    public Kamar(int idKamar, int lantai, double harga, boolean is_disewakan) {
        this.idKamar = idKamar;
        this.lantai = lantai;
        this.harga = harga;
        this.is_disewakan = is_disewakan;
    }

    public void viewKamar() {
        System.out.println("ID Kamar: " + idKamar);
        System.out.println("Lantai: " + lantai);
        System.out.println("Harga: " + harga);
        System.out.println("Status: " + (is_disewakan ? "Disewakan" : "Kosong"));
    }
}