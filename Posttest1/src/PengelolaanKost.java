
import java.util.ArrayList;
import java.util.Scanner;
import model.Admin;
import model.Kamar;
import model.Penghuni;
import view.MenuAdmin;


public class PengelolaanKost {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String username, password;
        Boolean isLogin = false;

        // Arraylist
        ArrayList<Kamar> daftarKamar = new ArrayList<>();
        ArrayList<Penghuni> daftarPenghuni = new ArrayList<>();
        ArrayList<Admin> daftarAdmin = new ArrayList<>();

        Admin admin1 = new Admin(1, "admin", "admin", "Admin 1", "08123456789");
        Penghuni penghuni1 = new Penghuni(1, 1, "penghuni1", "Penghuni 1", "08123456789");
        Kamar kamar1 = new Kamar(1, 1, 1000000, false);

        daftarAdmin.add(admin1);
        daftarPenghuni.add(penghuni1);
        daftarKamar.add(kamar1);

        boolean running = true;
        while (running) {
            System.out.print("\033[H\033[2J"); // Clear 
            System.out.println("\n=== Sistem Pengelolaan Kost ===");
            System.out.println("1. Login Admin");
            System.out.println("2. Keluar");
            System.out.print("Pilih menu: ");
            int pilihan = scanner.nextInt();
            scanner.nextLine();
            System.out.println();

            switch (pilihan) {
                case 1:
                    // Login
                    System.out.println("\n=== Login Admin ===");
                    System.out.print("Username: ");
                    username = scanner.nextLine();
                    System.out.print("Password: ");
                    password = scanner.nextLine();

                    for (Admin admin : daftarAdmin) {
                        if (admin.username.equals(username) && admin.password.equals(password)) {
                            isLogin = true;
                            MenuAdmin menuAdmin = new MenuAdmin(daftarKamar, daftarPenghuni, scanner);
                            menuAdmin.showMenu();
                            break;
                        }
                    }
                    if (!isLogin) {
                        System.out.println("Username atau password salah!");
                        scanner.nextLine();
                    }
                    break;
                case 2:
                    running = false;
                    System.out.println("Sistem Berhenti!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        }
        scanner.close();
    }
}