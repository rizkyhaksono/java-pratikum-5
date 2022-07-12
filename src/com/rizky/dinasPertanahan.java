package com.rizky;

import java.io.File;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author rizkyhaksono
 */
public class dinasPertanahan {
    private String alamat;
    private int panjangTanah;
    private int luasTanah;

    File file = new File("DinasPertanahan.txt");

    Scanner setAlamat = new Scanner(System.in);
    Scanner setPanjang = new Scanner(System.in);
    Scanner setLuas = new Scanner(System.in);

    // setter
    public void setAlamat() throws IOException, InputMismatchException {
        int loopPanjang = -1;

        do {

            try {
                System.out.print("Masukkan alamat tanah : ");
                this.alamat = setAlamat.nextLine();
                loopPanjang = 1;
            } catch (InputMismatchException type_error) {
                System.out.println("Error : " + type_error);
                loopPanjang = 0;
                setAlamat.next();
            } catch (Exception typeError) {
                System.out.println("Error : " + typeError);
                loopPanjang = 0;
                setAlamat.next();
            } finally {
                System.out.println("Alamat sudah dijalankan");
            }

        } while (loopPanjang != 1);

    }

    public void setPanjangTanah() throws IOException {
        int loopPanjang = -1;

        do {

            try {
                System.out.print("Masukkan panjang tanah : ");
                this.panjangTanah = setPanjang.nextInt();
                loopPanjang = 1;

            } catch (InputMismatchException typeError) {
                System.out.println("Error : " + typeError);
                loopPanjang = 0;
                setPanjang.next();
            } catch (Exception type_error) {
                System.out.println("Error : " + type_error);
                loopPanjang = 0;
                setPanjang.next();
                // return;
            } finally {
                System.out.println("Panjang tanah sudah dijalankan");
            }

        } while (loopPanjang != 1);

    }

    public void setLuasTanah() throws IOException {
        int loopPanjang = -1;

        do {

            try {
                System.out.print("Masukkan luas tanah : ");
                this.luasTanah = setLuas.nextInt();
                loopPanjang = 1;
            } catch (InputMismatchException typeError) {
                System.out.println("Error : " + typeError);
                loopPanjang = 0;
                setLuas.next();
            } catch (Exception type_error) {
                System.out.println("Error : " + type_error);
                loopPanjang = 0;
                setLuas.next();
                // return;
            } finally {
                System.out.println("Luas tanah sudah dijalankan");
            }

        } while (loopPanjang != 1);

    }

    // getter
    public String getAlamat() {
        return this.alamat;
    }

    public int getPanjangTanah() {
        return this.panjangTanah;
    }

    public int getLuasTanah() {
        return this.luasTanah;
    }
}
