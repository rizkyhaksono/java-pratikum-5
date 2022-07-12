package com.rizky;

import java.io.*;
import java.util.Scanner;

/**
 *
 * @author rizkyhaksono
 */
public class Main {

    public static void main(String args[]) throws IOException {

        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033\143");
            }
        } catch (Exception ex) {
            System.err.println("Tidak bisa clear screen");
        }

        Scanner scn = new Scanner(System.in);

        int perulangan = -1;
        int pilihan;

        do {
            System.out.println("===== Dinas Pertanahan =====");

            try {

                dinasPertanahan dp = new dinasPertanahan();

                System.out.println("1. Write data\n2. Read data\n3. Exit");
                System.out.print("Menu pilihan : ");
                pilihan = scn.nextInt();

                switch (pilihan) {
                    case 1:
                        // write data to file
                        dp.setAlamat();
                        dp.setPanjangTanah();
                        dp.setLuasTanah();

                        FileWriter fw = new FileWriter(dp.file);
                        fw.append("[1] Alamat        : " + dp.getAlamat() + "\n");
                        fw.append("[2] Panjang tanah : " + dp.getPanjangTanah() + "\n");
                        fw.append("[3] Luas tanah    : " + dp.getLuasTanah());

                        fw.flush();
                        fw.close();

                        break;
                    case 2:
                        // read data to file
                        FileReader fr = new FileReader(dp.file);
                        BufferedReader br = new BufferedReader(fr);

                        String data = br.readLine();

                        while (data != null) {
                            System.out.println(data);
                            data = br.readLine();
                        }

                        break;

                    case 3:
                        System.out.println("Terima kasih sudah menggunakan program ini!");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("\nInputan tidak ada!");
                        main(args);
                        break;
                }

                perulangan = 1;
            } catch (Exception e) {
                System.out.println("Error : " + e);
                perulangan = 0;
                scn.next();
            }
        } while (perulangan != 1);

        Scanner userOption = new Scanner(System.in);
        System.out.print("\nApakah anda ingin mengulang [y/n] ");
        String ulang = userOption.nextLine();

        while (!ulang.toLowerCase().equalsIgnoreCase("y")
                && !ulang.toLowerCase().equalsIgnoreCase("n")) {
            System.err.println("Pilihan anda tidak y atau n!");
            System.out.print("\nApakah anda ingin mengulang [y/n] ");
            ulang = userOption.next();
        }

        if (ulang.toLowerCase().equalsIgnoreCase("y")) {
            main(args);
        } else {
            System.out.println("Terima kasih sudah menggunakan program ini!");
            System.exit(0);
        }

        scn.close();
        userOption.close();
    }
}
