package view;

import java.util.ArrayList;
import java.util.Scanner;
import model.Kamar;
import model.Penghuni;

public class MenuAdmin {
    Scanner scanner = new Scanner(System.in);
    String buffer;
    int inputId, pilihan1, pilihan2;
    boolean isFound, isRunning;

    Kamar inputKamar = new Kamar(999, 999, 999, false);
    Penghuni inputPenghuni = new Penghuni(999, 999, "999", "999", "999");

    ArrayList<Kamar> daftarKamar;
    ArrayList<Penghuni> daftarPenghuni;

    public MenuAdmin(ArrayList<Kamar> daftarKamar, ArrayList<Penghuni> daftarPenghuni, Scanner scanner) {
        this.daftarKamar = daftarKamar;
        this.daftarPenghuni = daftarPenghuni;
        this.scanner = scanner;
    }

    public void showMenu() {
        do { 
            System.out.print("\033[H\033[2J"); // Clear 
            System.out.println("\n=== Menu Admin ===");
            System.out.println("1. Lihat Kamar");
            System.out.println("2. Lihat Penghuni");
            System.out.println("3. Kembali (Login)");
            System.out.print("Pilih menu: ");
            pilihan1 = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan1) {
                case 1:
                    do{
                        // Lihat daftar kamar
                        System.out.print("\033[H\033[2J");
                        System.out.println("=== Daftar Kamar ===");
                        if (daftarKamar.isEmpty()) {
                            System.out.println("Tidak ada kamar.");
                        } else {
                            for (Kamar kamar : daftarKamar) {
                                kamar.viewKamar();
                                System.out.println();
                            }
                        }
                        System.out.println("--------------------");
                        System.out.println("1. Tambah Kamar");
                        System.out.println("2. Edit Kamar");
                        System.out.println("3. Hapus Kamar");
                        System.out.println("4. Kembali (Menu Admin)");
                        System.out.print("Pilih menu: ");
                        pilihan2 = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println();
                        switch (pilihan2) {
                            case 1:
                                // Tambah Kamar
                                addKamar();
                                break;
                            case 2:
                                // Edit Kamar
                                updateKamar();
                                break;
                            case 3:
                                // Hapus Kamar
                                deleteKamar();
                                break;
                            case 4:
                                // Kembali
                                break;
                            default:
                                System.out.println("Menu tidak tersedia!");
                                scanner.nextLine();
                                break;
                        }
                    } while (pilihan2 != 4);
                    break;
                case 2:
                    do{
                        // Lihat daftar penghuni
                        System.out.print("\033[H\033[2J");
                        System.out.println("=== Daftar Penghuni ===");
                        if (daftarPenghuni.isEmpty()) {
                            System.out.println("Tidak ada penghuni");
                        }else{
                            for (Penghuni penghuni : daftarPenghuni) {
                                penghuni.viewPenghuni();
                                System.out.println();
                            }
                        }
                        System.out.println("--------------------");
                        System.out.println("1. Tambah Penghuni");
                        System.out.println("2. Edit Penghuni");
                        System.out.println("3. Hapus Penghuni");
                        System.out.println("4. Kembali (Menu Admin)");
                        System.out.print("Pilih menu: ");
                        pilihan2 = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println();
                        switch (pilihan2) {
                            case 1:
                                // Tambah Penghuni
                                addPenghuni();
                                break;
                            case 2:
                                // Edit Penghuni
                                updatePenghuni();
                                break;
                            case 3:
                                // Hapus Penghuni
                                deletePenghuni();
                                break;
                            case 4:
                                // Kembali
                                break;
                            default:
                                System.out.println("Menu tidak tersedia!");
                                scanner.nextLine();
                                break;
                        }
                    } while (pilihan2 != 4);
                    break;


                case 3:
                    break;

                default:
                    System.out.println("Menu tidak tersedia!");
                    scanner.nextLine();
                    break;
            }
            
        } while (pilihan1 != 3);
    }

    public void addKamar() {
        System.out.println("=== Tambah Kamar ===");
        System.out.print("ID Kamar: ");
        inputKamar.idKamar = scanner.nextInt();
        scanner.nextLine();
        for (Kamar kamar : daftarKamar) {
            if (kamar.idKamar == inputKamar.idKamar) {
                System.out.println("ID Kamar ("+ kamar.idKamar +") sudah digunakan!");
                scanner.nextLine();
                return;
            }
        }
        System.out.print("Lantai: ");
        inputKamar.lantai = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Harga: ");
        inputKamar.harga = scanner.nextDouble();
        System.out.print("Status (1: Disewakan, 0: Kosong): ");
        inputId = scanner.nextInt();
        scanner.nextLine();
        if (inputId == 1) {
            inputKamar.is_disewakan = true;
        } else if (inputId == 0) {
            inputKamar.is_disewakan = false;
        } else {
            System.out.println("Status tidak valid!");
            scanner.nextLine();
            return;
        }

        daftarKamar.add(new Kamar(inputKamar.idKamar, inputKamar.lantai, inputKamar.harga, inputKamar.is_disewakan));
        System.out.println("Kamar berhasil ditambahkan!");
        scanner.nextLine();
    }

    public void updateKamar() {
        System.out.println("=== Edit Kamar ===");
        System.out.print("ID Kamar: ");
        inputId = scanner.nextInt();
        scanner.nextLine();

        boolean found = false;
        for (Kamar kamar : daftarKamar) {
            if (kamar.idKamar == inputId) {
                found = true;
                System.out.print("ID Kamar Baru: ");
                inputId = scanner.nextInt();
                scanner.nextLine();
                // id baru tidak boleh duplikat
                for (Kamar k : daftarKamar) {
                    if (k.idKamar != kamar.idKamar &&k.idKamar == inputId ) {
                        System.out.println("ID Kamar ("+ k.idKamar +") sudah digunakan!");
                        scanner.nextLine();
                        return;
                    }
                }
                kamar.idKamar = inputId;
                System.out.println("Lantai: " + kamar.lantai);
                System.out.print("Lantai Baru: ");
                kamar.lantai = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Harga: " + kamar.harga);
                System.out.print("Harga Baru: ");
                kamar.harga = scanner.nextDouble();
                System.out.println("Status: " + (kamar.is_disewakan ? "Disewakan" : "Kosong"));
                System.out.print("Status Baru (1: Disewakan, 0: Kosong): ");
                inputId = scanner.nextInt();
                if (inputId == 1) {
                    kamar.is_disewakan = true;
                } else if (inputId == 0) {
                    kamar.is_disewakan = false;
                } else {
                    System.out.println("Status tidak valid!");
                    scanner.nextLine();
                    return;
                }

                scanner.nextLine();
                System.out.println("Kamar berhasil diubah!");
                scanner.nextLine();
                break;
            }
        }
        if (!found) {
            System.out.println("Kamar tidak ditemukan!");
            scanner.nextLine();
        }
    }

    public void deleteKamar(){
        System.out.println("=== Hapus Kamar ===");
        System.out.print("ID Kamar: ");
        inputId = scanner.nextInt();
        scanner.nextLine();

        isFound = false;
        for (Kamar kamar : daftarKamar) {
            if (kamar.idKamar == inputId) {
                for (Penghuni penghuni : daftarPenghuni) {
                    if (penghuni.idKamar == kamar.idKamar) {
                        System.out.println("Kamar masih ditempati penghuni (Id = " + penghuni.idPenghuni + ")");
                        scanner.nextLine();
                        return;
                    }
                }
                isFound = true;
                daftarKamar.remove(kamar);
                System.out.println("Kamar berhasil dihapus!");
                scanner.nextLine();
                break;
            }
        }
        if (!isFound) {
            System.out.println("Kamar tidak ditemukan!");
            scanner.nextLine();
        }
    }

    public void addPenghuni(){

        System.out.println("=== Tambah Penghuni ===");

        System.out.print("ID Penghuni: ");
        inputPenghuni.idPenghuni = scanner.nextInt();
        for (Penghuni penghuni : daftarPenghuni) {
            if (penghuni.idPenghuni == inputPenghuni.idPenghuni) {
                scanner.nextLine();
                System.out.println("ID Penghuni ("+ penghuni.idPenghuni +") sudah digunakan!");
                scanner.nextLine();
                return;
            }
        }

        System.out.print("ID Kamar: ");
        inputPenghuni.idKamar = scanner.nextInt();
        scanner.nextLine();
        isFound = false;
        for (Kamar kamar : daftarKamar) {
            if (kamar.idKamar == inputPenghuni.idKamar) {
                isFound = true;
                break;
            }
        }
        if (!isFound) {
            System.out.println("ID Kamar tidak ditemukan!");
            scanner.nextLine();
            return;
        }


        System.out.print("Password: ");
        inputPenghuni.password = scanner.nextLine();
        System.out.print("Nama: ");
        inputPenghuni.nama = scanner.nextLine();
        System.out.print("No HP: ");
        inputPenghuni.noHp = scanner.nextLine();

        daftarPenghuni.add(new Penghuni(inputPenghuni.idPenghuni, inputPenghuni.idKamar, inputPenghuni.password, inputPenghuni.nama, inputPenghuni.noHp));

        System.out.println("Penghuni berhasil ditambahkan!");
        scanner.nextLine();
    }

    public void updatePenghuni(){
        System.out.println("=== Edit Penghuni ===");
        System.out.print("ID Penghuni: ");
        inputId = scanner.nextInt();
        scanner.nextLine();

        isFound = false;
        for (Penghuni penghuni : daftarPenghuni) {
            if (penghuni.idPenghuni == inputId) {
                isFound = true;
                System.out.print("ID Penghuni Baru: ");
                penghuni.idPenghuni = scanner.nextInt();
                scanner.nextLine();
                for (Penghuni p : daftarPenghuni) {
                    if (p.idPenghuni == penghuni.idPenghuni && p.idPenghuni != inputId) {
                        System.out.println("ID Penghuni ("+ p.idPenghuni +") sudah digunakan!");
                        scanner.nextLine();
                        return;
                    }
                }

                System.out.print("ID Kamar: ");
                penghuni.idKamar = scanner.nextInt();
                scanner.nextLine();
                isFound = false;
                for (Kamar kamar : daftarKamar) {
                    if (kamar.idKamar == penghuni.idKamar) {
                        isFound = true;
                        break;
                    }
                }
                if (!isFound) {
                    System.out.println("ID Kamar tidak ditemukan!");
                    scanner.nextLine();
                    return;
                }

                System.out.print("Password: ");
                penghuni.password = scanner.nextLine();
                System.out.print("Nama: ");
                penghuni.nama = scanner.nextLine();
                System.out.print("No HP: ");
                penghuni.noHp = scanner.nextLine();
                System.out.println("Penghuni berhasil diubah!");
                scanner.nextLine();
                break;
            }
        }
        if (!isFound) {
            System.out.println("Penghuni tidak ditemukan!");
            scanner.nextLine();
        }
    }

    public void deletePenghuni(){
        System.out.println("=== Hapus Penghuni ===");
        System.out.print("ID Penghuni: ");
        inputId = scanner.nextInt();
        scanner.nextLine();

        isFound = false;
        for (Penghuni penghuni : daftarPenghuni) {
            if (penghuni.idPenghuni == inputId) {
                isFound = true;
                daftarPenghuni.remove(penghuni);
                System.out.println("Penghuni berhasil dihapus!");
                scanner.nextLine();
                break;
            }
        }
        if (!isFound) {
            System.out.println("Penghuni tidak ditemukan!");
            scanner.nextLine();
        }
    }
}