package com.github.affandes.kuliah.pm;

import java.util.ArrayList;
import java.util.Scanner;

public class BrowserHistory {
    private ArrayList<String> history;

    public BrowserHistory() {
        history = new ArrayList<>();
    }

    public void view() {
        if (history.isEmpty()) {
            System.out.println("History masih kosong.");
            return;
        }
        System.out.println("History Browser (dari yang terbaru):");
        for (int i = history.size() - 1; i >= 0; i--) {
            System.out.println((i + 1) + ". " + history.get(i));
        }
    }

    public void browse(String website) {
        history.add(website);
        System.out.println("Website '" + website + "' ditambahkan ke history.");
    }

    public void back() {
        if (history.isEmpty()) {
            System.out.println("Tidak ada website untuk kembali.");
            return;
        }
        String lastWebsite = history.remove(history.size() - 1);
        System.out.println("Kembali dari website: " + lastWebsite);
    }

    public void showMenu() {
        System.out.println("\n === Simulator history browser! ===");
        System.out.println("Menu History Browser : ");
        System.out.println("1. View");
        System.out.println("2. Browse");
        System.out.println("3. Back");
        System.out.println("4. Exit");
        System.out.print("Pilih : ");
    }

    public static void main(String[] args) {
        BrowserHistory browserHistory = new BrowserHistory();
        Scanner scanner = new Scanner(System.in);
        int choice;


        do {
            browserHistory.showMenu();
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    browserHistory.view();
                    break;
                case 2:
                    System.out.print("Masukkan website: ");
                    String website = scanner.nextLine();
                    browserHistory.browse(website);
                    break;
                case 3:
                    browserHistory.back();
                    break;
                case 4:
                    System.out.println("Keluar dari program.");
                    break;
                default:
                    System.out.println("Pilihan tidak dikenal. Silahkan coba lagi!!!");
            }
        } while (choice != 4);

        scanner.close();
    }
}
