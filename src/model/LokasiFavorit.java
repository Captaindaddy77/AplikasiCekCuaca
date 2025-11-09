/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.util.ArrayList;
import java.util.List;
import java.io.*;
/**
 *
 * @author acer
 */
public class LokasiFavorit {
        private List<String> daftarFavorit = new ArrayList<>();

    // ====== Konstruktor ======
    public LokasiFavorit() {
        // Saat pertama kali dijalankan, coba muat data dari file
        loadFromFile();
    }

    // ====== Menambah kota favorit ======
    public void tambahFavorit(String kota) {
        if (!daftarFavorit.contains(kota)) {
            daftarFavorit.add(kota);
        }
    }

    // ====== Menghapus kota favorit ======
    public void hapusFavorit(String kota) {
        daftarFavorit.remove(kota);
    }

    // ====== Mendapatkan semua favorit ======
    public List<String> getDaftarFavorit() {
        return daftarFavorit;
    }

    // ====== Simpan daftar favorit ke file ======
    public void saveToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("lokasi_favorit.txt"))) {
            for (String kota : daftarFavorit) {
                writer.write(kota);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Gagal menyimpan daftar favorit: " + e.getMessage());
        }
    }

    // ====== Muat daftar favorit dari file ======
    public void loadFromFile() {
        File file = new File("lokasi_favorit.txt");
        if (!file.exists()) return; // kalau belum ada file, lewati saja

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            daftarFavorit.clear();
            while ((line = reader.readLine()) != null) {
                daftarFavorit.add(line.trim());
            }
        } catch (IOException e) {
            System.out.println("Gagal memuat daftar favorit: " + e.getMessage());
        }
    }
}

