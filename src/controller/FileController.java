/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import java.io.*;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.Cuaca;
/**
 *
 * @author acer
 */
public class FileController {

    // Simpan daftar data cuaca ke file CSV
    public void simpanKeCSV(List<Cuaca> dataCuaca, File file) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            // Header CSV
            writer.write("Kota,Negara,Suhu,Kondisi,Deskripsi,Kelembapan,KecepatanAngin,Waktu");
            writer.newLine();

            // Data isi
            for (Cuaca c : dataCuaca) {
                writer.write(
                    c.getNamaKota() + "," +
                    c.getNegara() + "," +
                    c.getSuhu() + "," +
                    c.getKondisi() + "," +
                    c.getDeskripsi() + "," +
                    c.getKelembapan() + "," +
                    c.getKecepatanAngin() + "," +
                    c.getWaktu()
                );
                writer.newLine();
            }
        }
    }

    // Muat data CSV ke tabel dari file tertentu
    public void muatDariCSV(DefaultTableModel tableModel, File file) throws IOException {
    if (!file.exists()) return;

    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
        String line;
        tableModel.setRowCount(0); // hapus data lama

        // Lewati header
        reader.readLine();

        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            if (parts.length == 8) {
                // Tetap simpan semua sebagai String, jangan parse ke Double
                tableModel.addRow(parts);
            }
        }
    }
}
}