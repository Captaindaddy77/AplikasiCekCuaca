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
    private String namaKota;
    private String negara;
    private double suhu;
    private String kondisi;
    private String deskripsi;
    private int kelembapan;
    private double kecepatanAngin;
    private String waktu;
    private String iconUrl;

    public Cuaca(String namaKota, String negara, double suhu, String kondisi,
                 String deskripsi, int kelembapan, double kecepatanAngin, String waktu, String iconUrl) {
        this.namaKota = namaKota;
        this.negara = negara;
        this.suhu = suhu;
        this.kondisi = kondisi;
        this.deskripsi = deskripsi;
        this.kelembapan = kelembapan;
        this.kecepatanAngin = kecepatanAngin;
        this.waktu = waktu;
        this.iconUrl = iconUrl;
    }

    // Getter untuk semua field
    public String getNamaKota() { return namaKota; }
    public String getNegara() { return negara; }
    public double getSuhu() { return suhu; }
    public String getKondisi() { return kondisi; }
    public String getDeskripsi() { return deskripsi; }
    public int getKelembapan() { return kelembapan; }
    public double getKecepatanAngin() { return kecepatanAngin; }
    public String getWaktu() { return waktu; }
    public String getIconUrl() {return iconUrl; }
}
                                                                                            
