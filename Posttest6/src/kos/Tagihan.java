package kos;

public class Tagihan {
    private int idTagihan;
    private int idKamar;
    private int bulan;
    private int tahun;
    private double harga;
    private boolean isLunas;

    public Tagihan(int idTagihan, int idKamar, int bulan, int tahun, double harga, boolean isLunas) {
        this.idTagihan = idTagihan;
        this.idKamar = idKamar;
        this.bulan = bulan;
        this.tahun = tahun;
        this.harga = harga;
        this.isLunas = isLunas;
    }

    public int getIdTagihan() {
        return idTagihan;
    }
    public void setIdTagihan(int idTagihan) {
        this.idTagihan = idTagihan;
    }

    public int getIdKamar() {
        return idKamar;
    }
    public void setIdKamar(int idKamar) {
        this.idKamar = idKamar;
    }

    public int getBulan() {
        return bulan;
    }
    public void setBulan(int bulan) {
        this.bulan = bulan;
    }

    public int getTahun() {
        return tahun;
    }
    public void setTahun(int tahun) {
        this.tahun = tahun;
    }

    public double getHarga() {
        return harga;
    }
    public void setHarga(double harga) {
        this.harga = harga;
    }

    public boolean getStatusLunas() {
        return isLunas;
    }
    public void setStatusLunas(boolean isLunas) {
        this.isLunas = isLunas;
    }

    public void infoTagihan() {
        System.out.println("ID Tagihan: " + idTagihan);
        System.out.println("ID Kamar: " + idKamar);
        System.out.println("Bulan: " + bulan);
        System.out.println("Tahun: " + tahun);
        System.out.println("Harga: " + harga);
        System.out.println("Status Lunas: " + (isLunas ? "Lunas" : "Belum Lunas"));
    }

    public void infoTagihan(Kamar kamar) {
        System.out.println("ID Tagihan: " + idTagihan);
        System.out.println("ID Kamar: " + idKamar);
        System.out.println("Nomor Kamar: " + kamar.getNomor());
        System.out.println("Bulan: " + bulan);
        System.out.println("Tahun: " + tahun);
        System.out.println("Harga: " + harga);
        System.out.println("Status Lunas: " + (isLunas ? "Lunas" : "Belum Lunas"));
    }
}
