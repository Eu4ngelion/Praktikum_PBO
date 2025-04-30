package model;

public class Admin extends User {
    private String password;

    public Admin(int id, String nama, String username, String password) {
        super(id, nama, username);
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public void showInfo() {
        System.out.println("ID Admin: " + getId());
        System.out.println("Nama: " + getNama());
        System.out.println("Username: " + getUsername());
        System.out.println("Password: " + getPassword());
    }


}
