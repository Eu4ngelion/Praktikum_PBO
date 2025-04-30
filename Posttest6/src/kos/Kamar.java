package kos;

import java.util.ArrayList;
import model.Penghuni;
import model.User;

public class Kamar implements bangunan {
    private int idKamar;
    private String nomor;
    private int harga;
    private boolean isDihuni;

    public Kamar(int idKamar, String nomor, int harga, boolean isDihuni) {
        this.idKamar = idKamar;
        this.nomor = nomor;
        this.harga = harga;
        this.isDihuni = isDihuni;
    }
    @Override
    public int getId() {
        return idKamar;
    }
    @Override
    public void setId(int idKamar) {
        this.idKamar = idKamar;
    }
    @Override
    public int getHarga() {
        return harga;
    }
    @Override
    public void setHarga(int harga) {
        this.harga = harga;
    }

    public String getNomor() {
        return nomor;
    }
    public void setNomor(String nomor) {
        this.nomor = nomor;
    }
    

    public boolean isDihuni() {
        return isDihuni;
    }
    public void setDihuni(boolean isDihuni) {
        this.isDihuni = isDihuni;
    }



    public void infoKamar() {
        System.out.println("ID Kamar: " + idKamar);
        System.out.println("Nomor Kamar: " + nomor);
        System.out.println("Harga: Rp" + harga);
        System.out.println("Status: " + (isDihuni ? "Dihuni" : "Kosong"));
    }   

    public void infoKamar(ArrayList<User> User) {
        System.out.println("ID Kamar: " + idKamar);
        System.out.println("Nomor Kamar: " + nomor);
        System.out.println("Harga: Rp" + harga);
        System.out.println("Status: " + (isDihuni ? "Dihuni" : "Kosong"));
        if (isDihuni) {
            for (User penghuni : User) {
                if (penghuni instanceof Penghuni p) {
                    if (p.getIdKamar() == idKamar) {
                        System.out.println("Penghuni: " + p.getNama());
                    }
                }
            }
        } 
    }
    
}
