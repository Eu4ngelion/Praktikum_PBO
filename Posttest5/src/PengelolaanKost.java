import java.util.ArrayList;
import java.util.Scanner;
import kos.Kamar;
import model.Admin;
import model.Penghuni;
import model.User;


public class PengelolaanKost{
    private static final Scanner scanner = new Scanner(System.in);
    private static final ArrayList<User> daftarUser = new ArrayList<>();
    private static final ArrayList<Kamar> daftarKamar = new ArrayList<>();

    public static int count_idUser = 3;
    public static int count_idKamar = 2;
    public static String global_Username;

    public static void clear() {
        System.out.print("\033[H\033[2J"); // Clear console
        System.out.flush();
    }
    public static void main(String[] args) {
        // Inisialisasi data
        daftarUser.add(new Admin(1, "Injil Karepowan", "admin", "admin123"));
        daftarUser.add(new Penghuni(2, "Kevin", "kevin123", 1, true));
        daftarUser.add(new Penghuni(3, "Budi", "budi321", 2, true));
        daftarKamar.add(new Kamar(1, "101", 1000000, true));
        daftarKamar.add(new Kamar(2, "102", 1000000, true));
        
        menuAwal();
    }

    public static void menuAwal(){
        clear();
        System.out.println("====== BERKAH KOST ======");
        System.out.println("1. Login");
        System.out.println("0. Keluar");
        System.out.print("Pilih menu: ");
        int pilihan = scanner.nextInt();
        scanner.nextLine(); 

        switch (pilihan) {
            case 1:
                clear();
                login();
                break;
            case 0:
                clear();
                System.out.println("Program Selesai");
                System.exit(0);
            default:
                System.out.println("> Pilihan tidak valid. Silakan coba lagi.");
                System.out.println("...");
                scanner.nextLine();
                clear();
                menuAwal();
                break;
        }
    }

    public static void login() {
        System.out.println("====== LOGIN ======");
        System.out.print("Username: ");
        String username = scanner.nextLine();

        for (User user : daftarUser) {
            if (user.getUsername().equalsIgnoreCase(username)) {
                if (user instanceof Admin) {
                    System.out.println("> Login Sebagai Admin");
                    System.out.print("Password: ");
                    String password = scanner.nextLine();
                    if (((Admin) user).getPassword().equals(password)) {
                        global_Username = username;
                        System.out.println("> Login berhasil!");
                        System.out.println("...");
                        scanner.nextLine();
                        clear();
                        menuAdmin();
                        return;
                    } else {
                        System.out.println("> Password salah.");
                        System.out.println("...");
                        scanner.nextLine();
                        clear();
                        menuAwal();
                    } 

                } else if(user instanceof Penghuni) {
                    global_Username = username;
                    System.out.println("> Login berhasil!");
                    System.out.println("...");
                    scanner.nextLine();
                    clear();
                    menuPenghuni(); 
                    return;
                } else {
                    System.out.println("> Password salah.");
                    System.out.println("...");
                    scanner.nextLine();
                    clear();
                    menuAwal();
                }

            }
        }
        System.out.println("> Username atau password salah. Silakan coba lagi.");
        System.out.println("...");
        scanner.nextLine();
        clear();
        menuAwal();
    }

    public static void menuAdmin(){
        System.out.println("====== MENU ADMIN ======");
        System.out.println("1. Kelola Kamar");
        System.out.println("2. Kelola Penghuni");
        System.out.println("3. Kelola Admin");
        System.out.println("0. Logout");
        System.out.print("Pilih menu: ");
        int pilihan = scanner.nextInt();
        scanner.nextLine(); 

        switch (pilihan) {
            case 1:
                clear();
                kelolaKamar();
                break;
            case 2:
                kelolaPenghuni();
                break;
            case 3:
                kelolaAdmin();
                break;
            case 0:
                menuAwal();
                break;
            default:
                System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                menuAdmin();
                break;
        }
    }

    public static void kelolaKamar() {
        boolean found = false;
        String newNomorKamar, newStatusKamar;
        int newHarga;
        boolean newStatus;

        System.out.println("====== KELOLA KAMAR ======");
        // Tampilkan daftar kamar
        System.out.println("DAFTAR KAMAR:");
        if (daftarKamar.isEmpty()) {
            System.out.println("Tidak ada kamar yang tersedia.");
        } else {
            for (Kamar kamar : daftarKamar) {
                System.out.println("ID : " + kamar.getIdKamar() + ", Nomor: " + kamar.getNomor() + ", Harga: " + kamar.getHarga() + ", Status: " + (kamar.isDihuni() ? "Dihuni" : "Kosong"));
            }
        }
        System.out.println("==========================");
        System.out.println("1. Lihat Kamar");
        System.out.println("2. Tambah Kamar");
        System.out.println("3. Edit Kamar");
        System.out.println("4. Hapus Kamar");
        System.out.println("0. Kembali (Menu Admin)");
        System.out.print("Pilih menu: ");
        int pilihan = scanner.nextInt();
        scanner.nextLine();

        switch (pilihan) { 
            case 1: // Lihat Kamar
                System.out.println("====== LIHAT KAMAR ======");
                System.out.print("ID Kamar: ");
                String idKamar = scanner.nextLine();
                found = false;
                for (Kamar kamar : daftarKamar) {
                    if(kamar.getIdKamar() == Integer.parseInt(idKamar)) {
                        System.out.println("------ DETAIL KAMAR ------");   
                        kamar.infoKamar(daftarUser);
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    System.out.println("Kamar dengan ID " + idKamar + " tidak ditemukan.");
                }
                System.out.println("...");
                scanner.nextLine();
                clear();
                kelolaKamar();
                break;

            case 2: // Tambah Kamar
                System.out.println("====== TAMBAH KAMAR ======");
                System.out.println("ID Kamar: " + (count_idKamar+1));          
                System.out.print("Nomor Kamar: ");
                newNomorKamar = scanner.nextLine();
                System.out.print("Harga: ");
                newHarga = scanner.nextInt();
                scanner.nextLine();
                // Cek apakah nomor kamar sudah digunakan
                for (Kamar kamar : daftarKamar) {
                    if (kamar.getNomor().equals(newNomorKamar)) {
                        System.out.println("> Nomor Kamar sudah ada. Silakan gunakan nomor kamar yang berbeda.");
                        System.out.println("...");
                        scanner.nextLine();
                        kelolaKamar();
                        return;
                    }
                }
                count_idKamar++;
                daftarKamar.add(new Kamar(count_idKamar, newNomorKamar, newHarga, false));
                System.out.println("> Kamar berhasil ditambahkan!");
                System.out.println("...");
                scanner.nextLine();
                clear();
                kelolaKamar();
                break;

            case 3: // Edit Kamar
                System.out.println("====== EDIT KAMAR ======");
                System.out.print("ID Kamar: ");
                String editIdKamar = scanner.nextLine();
                found = false;
                // Detail Lama
                for (Kamar kamar : daftarKamar) {
                    if (kamar.getIdKamar() == Integer.parseInt(editIdKamar)) {
                        System.out.println("------ DETAIL KAMAR ------");   
                        kamar.infoKamar(daftarUser);
                        found = true;
                    }
                }
                if (!found) {
                    System.out.println("Kamar dengan ID " + editIdKamar + " tidak ditemukan.");
                    kelolaKamar();
                    break;
                }
                // Detail Baru
                System.out.println("------ DETAIL BARU ------");
                System.out.print("Nomor Kamar baru: ");
                newNomorKamar = scanner.nextLine();
                System.out.print("Harga baru: ");
                newHarga = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Dihuni? (y/n): ");
                newStatusKamar = scanner.nextLine();
                if (newStatusKamar.equalsIgnoreCase("y")) {
                    newStatus = true;
                } else if (newStatusKamar.equalsIgnoreCase("n")) {
                    newStatus = false;
                } else {
                    System.out.println("> Pilihan tidak valid. Silakan coba lagi!");
                    System.out.println("...");
                    scanner.nextLine();
                    kelolaKamar();
                    return;
                }
                // Cek apakah Nomor Kamar sudah ada
                for (Kamar kamar : daftarKamar) {
                    if (kamar.getNomor().equals(newNomorKamar) && kamar.getIdKamar() != Integer.parseInt(editIdKamar)) {
                        System.out.println("> Nomor Kamar (" + newNomorKamar + ")sudah digunakan.");
                        System.out.println("...");
                        scanner.nextLine();
                        clear();
                        kelolaKamar();
                        return;
                    }
                }
                // Input ID Penghuni 
                if (newStatus) {
                    System.out.print("ID Penghuni: ");
                    int idPenghuni = scanner.nextInt();
                    scanner.nextLine();
                    boolean penghuniFound = false;

                    for (User user : daftarUser) {
                        if (user instanceof Penghuni && user.getId() == idPenghuni) {
                            if (((Penghuni) user).getIsHuni()) {
                                System.out.println("> Penghuni dengan ID " + idPenghuni + " sudah menghuni kamar lain.");
                                System.out.println("...");
                                scanner.nextLine();
                                clear();
                                kelolaKamar();
                                return;
                            }

                            ((Penghuni) user).setIdKamar(Integer.parseInt(editIdKamar));
                            ((Penghuni) user).setIsHuni(true);
                            penghuniFound = true;
                            break;
                        }
                    }

                    if (!penghuniFound) {
                        System.out.println("> ID Penghuni tidak ditemukan.");
                        System.out.println("...");
                        scanner.nextLine();
                        clear();
                        kelolaKamar();
                        return;
                    }
                }

                // Update Kamar
                for (Kamar kamar : daftarKamar) {
                    if (kamar.getIdKamar() == Integer.parseInt(editIdKamar)) {
                        kamar.setNomor(newNomorKamar);
                        kamar.setHarga(newHarga);
                        kamar.setDihuni(newStatus);
                        System.out.println("Kamar dengan ID " + editIdKamar + " berhasil diupdate.");
                        break;
                    }
                }
                // Update Penghuni
                for (User penghuni : daftarUser) {
                    if (penghuni instanceof Penghuni && ((Penghuni) penghuni).getIdKamar() == Integer.parseInt(editIdKamar) && ((Penghuni) penghuni).getIsHuni()) {
                        ((Penghuni) penghuni).setIsHuni(newStatus);
                        
                        // DEBUG ONLY
                        System.out.println("Penghuni dengan ID " + penghuni.getId() + " berhasil diupdate.");
                    }
                }
                System.out.println("...");
                scanner.nextLine();
                clear();
                kelolaKamar();
                break;

            case 4: // Hapus Kamar
                System.out.println("====== HAPUS KAMAR ======");
                System.out.print("ID Kamar: ");
                String hapusIdKamar = scanner.nextLine();
                found = false;
                for (Kamar kamar : daftarKamar) {
                    if (kamar.getIdKamar() == Integer.parseInt(hapusIdKamar)) {
                        // Ganti Id Kamar 
                        for (User penghuni : daftarUser) {
                            if (penghuni instanceof Penghuni && ((Penghuni) penghuni).getIdKamar() == Integer.parseInt(hapusIdKamar) && ((Penghuni) penghuni).getIsHuni()) {
                                ((Penghuni) penghuni).setIdKamar(0);
                                ((Penghuni) penghuni).setIsHuni(false);
                            }
                        }
                        daftarKamar.remove(kamar);
                        System.out.println("> Kamar dengan ID " + hapusIdKamar + " berhasil dihapus.");
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    System.out.println("> Kamar dengan ID " + hapusIdKamar + " tidak ditemukan.");
                }
                System.out.println("...");
                scanner.nextLine();
                clear();
                kelolaKamar();
                break;
            case 0:
                clear();
                menuAdmin();
                break;
            default:
                System.out.println("> Pilihan tidak valid. Silakan coba lagi.");
                System.out.println("...");
                scanner.nextLine();
                clear();
                kelolaKamar();
                break;
        }
    }

    public static void kelolaPenghuni() {
        int pilihan;

        System.out.println("====== KELOLA PENGHUNI ======");
                System.out.println("------------------------------");
        // Tampilkan daftar penghuni
        System.out.println("DAFTAR PENGHUNI:");
        if (daftarUser.isEmpty()) {
            System.out.println("Tidak ada penghuni yang terdaftar.");
        } else {
            for (User penghuni : daftarUser) {
                if (penghuni instanceof Penghuni p) {
                    System.out.println("ID: " + p.getId() + 
                    ", Nama: " + p.getNama() + 
                    ", Username: " + p.getUsername() + 
                    ", ID Kamar: " + (p).getIdKamar() + 
                    ", Status: " + ((p.getIsHuni()) ? "Dihuni" : "Kosong"));
                }
            }
        }
        System.out.println("------------------------------");
        System.out.println("1. Tambah Penghuni");
        System.out.println("2. Edit Penghuni");
        System.out.println("3. Hapus Penghuni");
        System.out.println("0. Kembali (Menu Admin)");
        System.out.print("Pilih menu: ");
        pilihan = scanner.nextInt();
        scanner.nextLine();

        switch (pilihan){
            case 1: // Tambah Penghuni
                clear();
                System.out.println("====== TAMBAH PENGHUNI ======");
                System.out.println("ID Penghuni: " + (count_idUser+1));
                System.out.print("Nama: ");
                String nama = scanner.nextLine();
                System.out.print("Username: ");
                String username = scanner.nextLine();
                System.out.print("ID Kamar: ");
                int idKamar = scanner.nextInt();
                scanner.nextLine();

                // Cek Username
                for (User user : daftarUser) {
                    if (user.getUsername().equalsIgnoreCase(username)) {
                        System.out.println("> Username sudah ada. Silakan gunakan username yang berbeda.");
                        System.out.println("...");
                        scanner.nextLine();
                        clear();
                        kelolaPenghuni();
                        return;
                    }
                }
                // Cek ID Kamar
                boolean kamarFound = false;
                for (Kamar kamar : daftarKamar) {
                    if (kamar.getIdKamar() == idKamar) {
                        kamarFound = true;
                        break;
                    }
                }
                if (!kamarFound) {
                    System.out.println("> ID Kamar tidak ditemukan. Silakan coba lagi.");
                    System.out.println("...");
                    scanner.nextLine();
                    kelolaPenghuni();
                    return;
                }
                count_idUser++;
                daftarUser.add(new Penghuni(count_idUser, nama, username, idKamar, true));
                System.out.println("> Penghuni berhasil ditambahkan!");
                System.out.println("...");
                scanner.nextLine();
                clear();
                kelolaPenghuni();
                break;

            case 2: // Edit Penghuni
                System.out.println("====== EDIT PENGHUNI ======");
                System.out.print("ID Penghuni: ");
                String editIdPenghuni = scanner.nextLine();
                boolean found = false;
                // Detail Lama
                for (User penghuni : daftarUser) {
                    if (penghuni.getId() == Integer.parseInt(editIdPenghuni)) {
                        System.out.println("------ DETAIL PENGHUNI ------");   
                        penghuni.showInfo();
                        found = true;
                    }
                }
                if (!found) {
                    System.out.println("Penghuni dengan ID " + editIdPenghuni + " tidak ditemukan.");
                    kelolaPenghuni();
                    break;
                }
                // Detail Baru
                System.out.println("------ DETAIL BARU ------");
                System.out.print("ID Penghuni baru: " + editIdPenghuni + "\n");
                System.out.print("Nama baru: ");
                String newNama = scanner.nextLine();
                System.out.print("Username baru: ");
                String newUsername = scanner.nextLine();
                System.out.print("ID Kamar baru: ");
                int newIdKamar = scanner.nextInt();
                scanner.nextLine();

                // Cek Username
                for (User user : daftarUser) {
                    if (user.getUsername().equalsIgnoreCase(newUsername) && user.getId() != Integer.parseInt(editIdPenghuni)) {
                        System.out.println("> Username sudah digunakan.");
                        System.out.println("...");
                        scanner.nextLine();
                        clear();
                        kelolaPenghuni();
                        return;
                    }
                }
                
                // Cek ID Kamar
                boolean kamarFound2 = false;
                for (Kamar kamar : daftarKamar) {
                    if (kamar.getIdKamar() == newIdKamar) {
                        kamarFound2 = true;
                        break;
                    }
                }
                if (!kamarFound2) {
                    System.out.println("> ID Kamar tidak ditemukan. Silakan coba lagi.");
                    System.out.println("...");
                    scanner.nextLine();
                    kelolaPenghuni();
                    return;
                }

                // Update Penghuni
                for (User penghuni : daftarUser) {
                    if (penghuni.getId() == Integer.parseInt(editIdPenghuni)) {
                        ((Penghuni) penghuni).setNama(newNama);
                        ((Penghuni) penghuni).setUsername(newUsername);
                        ((Penghuni) penghuni).setIdKamar(newIdKamar);
                        ((Penghuni) penghuni).setIsHuni(true);
                        System.out.println("Penghuni dengan ID " + editIdPenghuni + " berhasil diupdate.");
                        break;
                    }
                }
                // Update Kamar
                for (Kamar kamar : daftarKamar) {
                    if (kamar.getIdKamar() == Integer.parseInt(editIdPenghuni)) {
                        kamar.setDihuni(true);
                        System.out.println("Kamar dengan ID " + editIdPenghuni + " berhasil diupdate.");
                        break;
                    }
                }
                System.out.println("...");
                scanner.nextLine();
                clear();
                kelolaPenghuni();
                break;

            case 3: // Hapus Penghuni
                System.out.println("====== HAPUS PENGHUNI ======");
                System.out.print("ID Penghuni: ");
                String hapusIdPenghuni = scanner.nextLine();
                found = false;
                for (User penghuni : daftarUser) {
                    if (penghuni.getId() == Integer.parseInt(hapusIdPenghuni)) {
                        for (Kamar kamar : daftarKamar) {
                            if (kamar.getIdKamar() == ((Penghuni) penghuni).getIdKamar()) {
                                kamar.setDihuni(false);
                            }
                        }
                        daftarUser.remove(penghuni);
                        System.out.println("> Penghuni dengan ID " + hapusIdPenghuni + " berhasil dihapus.");
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    System.out.println("> Penghuni dengan ID " + hapusIdPenghuni + " tidak ditemukan.");
                }
                System.out.println("...");
                scanner.nextLine();
                clear();
                kelolaPenghuni();
                break;
            case 0:
                clear();
                menuAdmin();
                break;
            default:
                System.out.println("> Pilihan tidak valid. Silakan coba lagi.");
                System.out.println("...");
                scanner.nextLine();
                clear();
                kelolaPenghuni();
                break;
        }

    }

    public static void kelolaAdmin() {
        int pilihan;
        System.out.println("====== KELOLA ADMIN ======");
        System.out.println("1. Lihat Profil");
        System.out.println("2. Edit Profil");
        System.out.println("0. Kembali (Menu Admin)");
        System.out.println("------------------------------");
        System.out.print("Pilih menu: ");
        pilihan = scanner.nextInt();
        scanner.nextLine();
        switch (pilihan) {
            case 1:
                clear();
                System.out.println("====== LIHAT PROFIL ======");
                for (User user : daftarUser) {
                    if (user instanceof Admin admin) {
                        admin.showInfo();
                    }
                }
                System.out.println("...");
                scanner.nextLine();
                clear();
                kelolaAdmin();
                break;
            case 2:
                clear();
                System.out.println("====== EDIT PROFIL ======");
                for (User user : daftarUser) {
                    if (user instanceof Admin admin) {
                        admin.showInfo();
                        System.out.println("------------------------------");
                        System.out.print("Nama baru: ");
                        String newNama = scanner.nextLine();
                        System.out.print("Password baru: ");
                        String newPassword = scanner.nextLine();
                        System.out.print("Konfirmasi Password baru: ");
                        String konfirmasiPassword = scanner.nextLine();
                        if (!newPassword.equals(konfirmasiPassword)) {
                            System.out.println("> Konfirmasi password tidak sesuai.");
                            System.out.println("...");
                            scanner.nextLine();
                            clear();
                            kelolaAdmin();
                            return;
                        } 
                        // Update Admin
                        admin.setNama(newNama);
                        admin.setPassword(newPassword);
                        System.out.println("> Profil berhasil diupdate!");
                        System.out.println("...");
                        scanner.nextLine();
                        clear();
                        kelolaAdmin();
                    }
                }
                break;
            case 0:
                clear();
                menuAwal();
            default:
                System.out.println("> Pilihan tidak valid. Silakan coba lagi.");
                System.out.println("...");
                scanner.nextLine();
                clear();
                kelolaAdmin();
        }



    }

    public static void menuPenghuni(){
        // WIP
        System.out.println("====== MENU PENGHUNI ======");
        System.out.println("Username: " + global_Username);
        System.out.println("------------------------------");
        System.out.println("1. Lihat Profil");
        System.out.println("2. Lihat Kamar");
        System.out.println("2. Lihat Penghuni");
        System.out.println("0. Logout");
        System.out.println("------------------------------");
        System.out.print("Pilih menu: ");
        int pilihan = scanner.nextInt();
        scanner.nextLine(); 

        switch (pilihan) {
            case 1: // Lihat Profil
                clear();
                System.out.println("====== LIHAT PROFIL ======");
                for (User user : daftarUser) {
                    if (user instanceof Penghuni penghuni) {
                        if (penghuni.getUsername().equalsIgnoreCase(global_Username)) {
                            for (Kamar kamar : daftarKamar) {
                                if (kamar.getIdKamar() == penghuni.getIdKamar()) {
                                    penghuni.showInfo(penghuni, kamar);
                                    break;
                                }
                            }
                        }
                    }
                }
                System.out.println("------------------------------");
                System.out.println("1. Edit Profil");
                System.out.println("0. Kembali (Menu Penghuni)");
                System.out.print("Pilih menu: ");
                pilihan = scanner.nextInt();
                scanner.nextLine();

                switch (pilihan){
                    case 1: // Edit Profil
                        clear();
                        System.out.println("====== EDIT PROFIL ======");
                        for (User user : daftarUser) {
                            if (user instanceof Penghuni penghuni) {
                                if (penghuni.getUsername().equalsIgnoreCase(global_Username)) {
                                    penghuni.showInfo();
                                    System.out.println("------------------------------");
                                    System.out.print("Nama baru: ");
                                    String newNama = scanner.nextLine();
                                    System.out.print("Username baru: ");
                                    String newUsername = scanner.nextLine();
                                    // Cek Username
                                    for (User u : daftarUser) {
                                        if (u.getUsername().equalsIgnoreCase(newUsername) && u.getId() != penghuni.getId()) {
                                            System.out.println("> Username sudah ada. Silakan gunakan username yang berbeda.");
                                            System.out.println("...");
                                            scanner.nextLine();
                                            clear();
                                            kelolaPenghuni();
                                            return;
                                        }
                                    }
                                    // Update Penghuni
                                    penghuni.setNama(newNama);
                                    penghuni.setUsername(newUsername);
                                    global_Username = newUsername;
                                    System.out.println("> Profil berhasil diupdate!");
                                    System.out.println("...");
                                    scanner.nextLine();
                                    clear();
                                    menuPenghuni();
                                }
                            }
                        }
                        break;
                    case 0:
                        clear();
                        menuPenghuni();
                        break;
                    default:
                        System.out.println("> Pilihan tidak valid. Silakan coba lagi.");
                        System.out.println("...");
                        scanner.nextLine();
                        clear();
                        menuPenghuni();
                }

            case 2: // Lihat Kamar
                clear();
                System.out.println("====== LIHAT KAMAR ======");
                System.out.println("DAFTAR KAMAR:");
                if (daftarKamar.isEmpty()) {
                    System.out.println("Tidak ada kamar yang tersedia.");
                } else {
                    for (Kamar kamar : daftarKamar) {
                        System.out.println("ID : " + kamar.getIdKamar() + ", Nomor: " + kamar.getNomor() + ", Harga: " + kamar.getHarga() + ", Status: " + (kamar.isDihuni() ? "Dihuni" : "Kosong"));
                        System.out.println("-");
                    }
                }
                System.out.println("------------------------------");
                System.out.print("ID Kamar: ");
                String idKamar = scanner.nextLine();
                boolean found = false;
                for (Kamar kamar : daftarKamar) {
                    if(kamar.getIdKamar() == Integer.parseInt(idKamar)) {
                        System.out.println("------ DETAIL KAMAR ------");   
                        kamar.infoKamar(daftarUser);
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    System.out.println("Kamar dengan ID " + idKamar + " tidak ditemukan.");
                }
                System.out.println("...");
                scanner.nextLine();
                clear();
                menuPenghuni();
                break;
                
            case 0: // Logout
                clear();
                menuAwal();
                break;
            default:
                System.out.println("> Pilihan tidak valid. Silakan coba lagi.");
                System.out.println("...");
                scanner.nextLine();
                clear();
                menuPenghuni();
                break;
        }
    }
}