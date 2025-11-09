/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import org.json.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import model.Cuaca;
import service.APICuacaService;
/**
 *
 * @author acer
 */
public class CuacaController {
    private APICuacaService apiService;

    public CuacaController() {
        apiService = new APICuacaService();
    }

    /**
     * Ambil data cuaca dari API dan ubah ke model Cuaca
     */
    public Cuaca getDataCuaca(String kota) throws Exception {
        // Ambil data dari API
        JSONObject data = apiService.getCuaca(kota);

        // Ambil data dari JSON OpenWeatherMap
        String namaKota = data.getString("name");
        String negara = data.getJSONObject("sys").getString("country");
        JSONObject main = data.getJSONObject("main");
        JSONObject wind = data.getJSONObject("wind");
        JSONObject weather = data.getJSONArray("weather").getJSONObject(0);

        double suhu = main.getDouble("temp");
        int kelembapan = main.getInt("humidity");
        double kecepatanAngin = wind.getDouble("speed");
        String kondisi = weather.getString("main");
        String deskripsi = weather.getString("description");
        String iconCode = weather.getString("icon"); // ambil kode ikon
        String iconUrl = "http://openweathermap.org/img/wn/" + iconCode + "@2x.png";

        // Format waktu pengecekan
        LocalDateTime waktu = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String waktuStr = waktu.format(formatter);

        // Kembalikan sebagai objek Cuaca
        return new Cuaca(
            namaKota,
            negara,
            suhu,
            kondisi,
            deskripsi,
            kelembapan,
            kecepatanAngin,
            waktuStr,
            iconUrl
        );
    }
}
