/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;
import java.net.*;
import java.io.*;
import org.json.*;
/**
 *
 * @author acer
 */
public class APICuacaService {
    // ✅ Ganti dengan API key kamu sendiri
    private static final String API_KEY = "42aaf40e285676d1f0f9a99e1d878660";

    public JSONObject getCuaca(String kota) throws IOException, JSONException {
        // Pastikan nama kota tidak kosong
        if (kota == null || kota.trim().isEmpty()) {
            throw new IllegalArgumentException("Nama kota tidak boleh kosong");
        }

        // Pastikan nama kota dikodekan agar URL valid (contoh: "New York" jadi "New%20York")
        String encodedCity = URLEncoder.encode(kota, "UTF-8");

        // ✅ Gunakan format API yang benar dan jelas metric-nya
        String urlStr = "https://api.openweathermap.org/data/2.5/weather?q=" 
                        + encodedCity + "&appid=" + API_KEY + "&units=metric&lang=id";

        // Membuka koneksi
        URL url = new URL(urlStr);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        int responseCode = conn.getResponseCode();
        if (responseCode != 200) {
            throw new IOException("Gagal mengambil data: Response code " + responseCode);
        }

        // Baca hasil dari API
        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        StringBuilder response = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            response.append(line);
        }
        br.close();

        // Kembalikan hasil dalam bentuk JSON
        return new JSONObject(response.toString());
    }   
}

    