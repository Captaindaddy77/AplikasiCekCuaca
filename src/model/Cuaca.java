/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author acer
 */
public class Cuaca {
        private String kota;
    private double suhu;
    private String kondisi;
    private String waktu;

    public Cuaca(String kota, double suhu, String kondisi, String waktu) {
        this.kota = kota;
        this.suhu = suhu;
        this.kondisi = kondisi;
        this.waktu = waktu;
    }

    // Getter dan Setter
    public String getKota() { return kota; }
    public double getSuhu() { return suhu; }
    public String getKondisi() { return kondisi; }
    public String getWaktu() { return waktu; }
}

