/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.membership;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Shinichi
 */
public class MySqlConnection {
    // Deklarasi variabel untuk URL database, username, dan password.
    private final String DB_URL = "jdbc:mysql://localhost/pp2_membership";
    private final String DB_USER = "root";
    private final String DB_PASS = "";
    
    // Deklarasi variabel untuk menyimpan instance kelas MySqlConnection.
    private static MySqlConnection instance;
    
    // Metode untuk mendapatkan instance dari kelas MySqlConnection.
    // Digunakan untuk mengatur keberadaan instance kelas.
    public static MySqlConnection getInstance() {
        if (instance == null) {
            instance = new MySqlConnection();
        }
        return instance;
    }
    
    // Metode untuk mendapatkan koneksi ke database.
    // Menggunakan desain pattern Singleton dan Double-Checked Locking.
    public Connection getConnection() throws SQLException {
        Connection connection = null;
        try{
            // Menggunakan class.forName untuk mengakses driver MySQL.
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Menggunakan DriverManager.getConnection untuk mendapatkan koneksi ke database.
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
        } catch (ClassNotFoundException e) {
            // Menangani kesalahan ketika driver MySQL tidak ditemukan.
            e.printStackTrace();
        }
        return connection;
    }
}
