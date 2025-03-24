package model;

public class Admin {
    private int idAdmin;
    private String username, password, nama, noHp;

    public Admin(int idAdmin, String username, String password, String nama, String noHp) {
        this.idAdmin = idAdmin;
        this.username = username;
        this.password = password;
        this.nama = nama;
        this.noHp = noHp;
    }

    public void setIdAdmin(int idAdmin) {
        this.idAdmin = idAdmin;
    }

    public int getIdAdmin() {
        return idAdmin;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNama() {
        return nama;
    }

    public void setNoHp(String noHp) {
        this.noHp = noHp;
    }

    public String getNoHp() {
        return noHp;
    }
}
