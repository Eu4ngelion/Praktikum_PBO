package model;

public class Penghuni {
    public int idPenghuni, idKamar;
    public String password, nama, noHp;

    public Penghuni(int idPenghuni, int idKamar, String password, String nama, String noHp) {
        this.idPenghuni = idPenghuni;
        this.idKamar = idKamar;
        this.password = password;
        this.nama = nama;
        this.noHp = noHp;
    }

    public void viewPenghuni(){
        System.out.println("ID Penghuni: " + idPenghuni);
        System.out.println("ID Kamar: " + idKamar);
        System.out.println("Nama: " + nama);
        System.out.println("No HP: " + noHp);
    }

    public void viewPenghuniDetail() {
        System.out.println("ID Penghuni: " + idPenghuni);
        System.out.println("Password: " + password);
        System.out.println("ID Kamar: " + idKamar);
        System.out.println("Nama: " + nama);
        System.out.println("No HP: " + noHp);
    }
}