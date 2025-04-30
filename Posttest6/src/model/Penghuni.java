package model;

import kos.Kamar;

public class Penghuni extends User {
    private int idKamar;
    private Boolean isHuni; 

    public Penghuni(int id, String nama, String username, int idKamar, Boolean isHuni) {
        super(id, nama, username);
        this.idKamar = idKamar;
        this.isHuni = isHuni;
    }
    public int getIdKamar() {
        return idKamar;
    }
    public void setIdKamar(int idKamar) {
        this.idKamar = idKamar;
    }
    public Boolean getIsHuni() {
        return isHuni;
    }
    public void setIsHuni(Boolean isHuni) {
        this.isHuni = isHuni;
    }

    @Override
    public void showInfo() {
        System.out.println("ID Penghuni: " + getId());
        System.out.println("ID Kamar: " + idKamar);
        System.out.println("Nama: " + getNama());
        System.out.println("Status Huni: " + (isHuni ? "Dihuni" : "Kosong"));
    }

    public void showInfo(Penghuni p, Kamar kamar) {
        System.out.println("------ Profil Penghuni ------");
        System.out.println("ID Penghuni: " + getId());
        System.out.println("ID Kamar: " + idKamar);
        System.out.println("Nama: " + getNama());
        System.out.println("Username: " + getUsername());
        System.out.println("Status Huni: " + (isHuni ? "Dihuni" : "Kosong"));
        System.out.println("----- Profil Kamar ------");
        System.out.println("ID Kamar: " + kamar.getId());
        System.out.println("Nomor Kamar: " + kamar.getNomor());
        System.out.println("Harga: Rp" + kamar.getHarga());
    }
}
