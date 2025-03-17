package model;

public class Admin {
    public int idAdmin;
    public String username, password, nama, noHp;

    public Admin(int idAdmin, String username, String password, String nama, String noHp) {
        this.idAdmin = idAdmin;
        this.username = username;
        this.password = password;
        this.nama = nama;
        this.noHp = noHp;
    }

    // !! Next
    public void viewAdmin() {
        System.out.println("ID Admin: " + idAdmin);
        System.out.println("Nama: " + nama);
        System.out.println("No HP: " + noHp);
    }

    public void viewAdminDetail() {
        System.out.println("ID Admin: " + idAdmin);
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);
        System.out.println("Nama: " + nama);
        System.out.println("No HP: " + noHp);
    }
}
