package model;

public abstract class User {
    private int id;
    private String nama;
    private String username;

    public User(int id, String nama, String username) {
        this.id = id;
        this.nama = nama;
        this.username = username;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }
    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public abstract void showInfo();
}
