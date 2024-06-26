/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Config.Koneksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;

/**
 *
 * @author laure
 */
public class Petugas {
    private Connection conn;
    
    public Petugas() {
        conn = Koneksi.getConnection();
    }
    
    public DefaultTableModel getPetugasTableModel() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID Petugas");
        model.addColumn("Nama Petugas");
        model.addColumn("Username Petugas");
        model.addColumn("Email Petugas");
        model.addColumn("Level Petugas");

        try {
            String sql = "SELECT * FROM User";
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                model.addRow(new Object[]{rs.getString("ID_User"), rs.getString("Nama_User"), rs.getString("Username"), rs.getString("Email"), rs.getString("Level")});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return model;
    }

    public DefaultTableModel searchPetugas(String keyword) {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID Petugas");
        model.addColumn("Nama Petugas");
        model.addColumn("Username Petugas");
        model.addColumn("Email Petugas");
        model.addColumn("Level Petugas");

        try {
            String sql = "SELECT * FROM User WHERE ID_User LIKE ? OR Nama_User LIKE ? OR Username LIKE ? OR Email LIKE ? OR Level LIKE ?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, "%" + keyword + "%");
            st.setString(2, "%" + keyword + "%");
            st.setString(3, "%" + keyword + "%");
            st.setString(4, "%" + keyword + "%");
            st.setString(5, "%" + keyword + "%");
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                model.addRow(new Object[]{rs.getString("ID_User"), rs.getString("Nama_User"), rs.getString("Username"), rs.getString("Email"), rs.getString("Level")});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return model;
    }
    
    public String setIDPetugas() {
        String urutan = null;
        Date now = new Date();
        SimpleDateFormat noFormat = new SimpleDateFormat("yyMM");
        String no = noFormat.format(now);

        String sql = "SELECT SUBSTR(ID_User, -3) AS Nomor FROM User WHERE ID_User LIKE 'USR" + no + "%' ORDER BY ID_User DESC LIMIT 1";
    
        try (PreparedStatement st = conn.prepareStatement(sql)) {
            ResultSet rs = st.executeQuery();
            
            if (rs.next()) {
                int nomor = Integer.parseInt(rs.getString("Nomor")) + 1;
                urutan = "USR" + no + String.format("%03d", nomor);
            } else {
                urutan = "USR" + no + "001";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return urutan;
    }
    
    public boolean insertData(String idUser, String namaUser, String usernameUser, String emailUser, String levelUser, String passUser) {
        try {
            String sql = "INSERT INTO User (ID_User, Nama_User, Username, Email, Level, Password) VALUES (?,?,?,?,?,?)";
            try (PreparedStatement st = conn.prepareStatement(sql)) {
                st.setString(1, idUser);
                st.setString(2, namaUser);
                st.setString(3, usernameUser);
                st.setString(4, emailUser);
                st.setString(5, levelUser);
                st.setString(6, passUser);

                int rowInserted = st.executeUpdate();
                return rowInserted > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateData(String idUser, String namaUser, String usernameUser, String emailUser, String levelUser) {
        try {
            String sql = "UPDATE User SET Nama_User=?, Username=?, Email=?, Level=? WHERE ID_User=?";
            try (PreparedStatement st = conn.prepareStatement(sql)) {
                st.setString(1, namaUser);
                st.setString(2, usernameUser);
                st.setString(3, emailUser);
                st.setString(4, levelUser);
                st.setString(5, idUser);

                int rowUpdated = st.executeUpdate();
                return rowUpdated > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteData(String id) {
        try {
            String sql = "DELETE FROM User WHERE ID_User=?";
            try (PreparedStatement st = conn.prepareStatement(sql)) {
                st.setString(1, id);

                int rowDeleted = st.executeUpdate();
                return rowDeleted > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
