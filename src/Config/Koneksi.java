/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Config;
/**
 *
 * @author laure
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Koneksi {
    private static Connection conn;
    
    public static Connection getConnection() {
        if(conn == null){
            try {
                // URL SQLite menunjuk ke file database, misalnya "database.db"
                String url = "jdbc:sqlite:C:\\Users\\laure\\OneDrive\\Documents\\Tugas PBO\\Projek Akhir\\src\\Database\\literastis.db";

                // Register driver SQLite (opsional, terkadang tidak diperlukan)
                Class.forName("org.sqlite.JDBC");

                // Membuat koneksi ke SQLite
                conn = DriverManager.getConnection(url);
            } catch (SQLException e) {
                Logger.getLogger(Koneksi.class.getName()).log(Level.SEVERE, null, e);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Koneksi.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return conn;
    }
}

