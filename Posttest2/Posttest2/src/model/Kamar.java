package model;

public class Kamar {
    private int idKamar, lantai;
    private double harga;
    private boolean is_disewakan;

    public Kamar(int idKamar, int lantai, double harga, boolean is_disewakan) {
        this.idKamar = idKamar;
        this.lantai = lantai;
        this.harga = harga;
        this.is_disewakan = is_disewakan;
    }

    public void setIdKamar(int idKamar) {
        this.idKamar = idKamar;
    }
    public int getIdKamar() {
        return idKamar;
    }

    public void setLantai(int lantai) {
        this.lantai = lantai;
    }
    public int getLantai() {
        return lantai;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }
    public double getHarga() {
        return harga;
    }

    public void setIsDisewakan(boolean is_disewakan) {
        this.is_disewakan = is_disewakan;
    }
    public boolean getIsDisewakan() {
        return is_disewakan;
    }



    public void viewKamar() {
        System.out.println("ID Kamar: " + idKamar);
        System.out.println("Lantai: " + lantai);
        System.out.println("Harga: " + harga);
        System.out.println("Status: " + (is_disewakan ? "Disewakan" : "Kosong"));
    }
}