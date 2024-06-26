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
public class Anggota {
    private Connection conn;
    
    public Anggota() {
        conn = Koneksi.getConnection();
    }
    
    public DefaultTableModel getAnggotaTableModel() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID Anggota");
        model.addColumn("Nama Anggota");
        model.addColumn("Email");
        model.addColumn("Telepon");
        model.addColumn("Tanggal Bergabung");
        model.addColumn("Jenis Kelamin");

        try {
            String sql = "SELECT * FROM Anggota";
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                model.addRow(new Object[]{rs.getString("ID_Anggota"), rs.getString("Nama_Anggota"), rs.getString("Email"), rs.getString("Telepon"), rs.getString("Tanggal_Bergabung"), rs.getString("Jenis_Kelamin")});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return model;
    }

    public DefaultTableModel searchAnggota(String keyword) {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID Anggota");
        model.addColumn("Nama Anggota");
        model.addColumn("Email");
        model.addColumn("Telepon");
        model.addColumn("Tanggal Bergabung");
        model.addColumn("Jenis Kelamin");

        try {
            String sql = "SELECT * FROM Anggota WHERE ID_Anggota LIKE ? OR Nama_Anggota LIKE ? OR Email LIKE ? OR Telepon LIKE ?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, "%" + keyword + "%");
            st.setString(2, "%" + keyword + "%");
            st.setString(3, "%" + keyword + "%");
            st.setString(4, "%" + keyword + "%");
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                model.addRow(new Object[]{rs.getString("ID_Anggota"), rs.getString("Nama_Anggota"), rs.getString("Email"), rs.getString("Telepon"), rs.getString("Tanggal_Bergabung"), rs.getString("Jenis_Kelamin")});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return model;
    }
    
    public String setIDAnggota() {
        String urutan = null;
        Date now = new Date();
        SimpleDateFormat noFormat = new SimpleDateFormat("yyMM");
        String no = noFormat.format(now);

        String sql = "SELECT SUBSTR(ID_Anggota, -3) AS Nomor FROM Anggota WHERE ID_Anggota LIKE 'AGT" + no + "%' ORDER BY ID_Anggota DESC LIMIT 1";

        try (PreparedStatement st = conn.prepareStatement(sql)) {
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                int nomor = Integer.parseInt(rs.getString("Nomor")) + 1;
                urutan = "AGT" + no + String.format("%03d", nomor);
            } else {
                urutan = "AGT" + no + "001";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return urutan;
    }
    
    public boolean insertData(String id, String nama, String email, String telepon, String tgl, String jk) {
        try {
            String sql = "INSERT INTO Anggota (ID_Anggota, Nama_Anggota, Email, Telepon, Tanggal_Bergabung, Jenis_Kelamin) VALUES (?,?,?,?,?,?)";
            try (PreparedStatement st = conn.prepareStatement(sql)) {
                st.setString(1, id);
                st.setString(2, nama);
                st.setString(3, email);
                st.setString(4, telepon);
                st.setString(5, tgl);
                st.setString(6, jk);

                int rowInserted = st.executeUpdate();
                return rowInserted > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateData(String id, String nama, String email, String telepon, String tgl, String jk) {
        try {
            String sql = "UPDATE Anggota SET Nama_Anggota=?, Email=?, Telepon=?, Tanggal_Bergabung=?, Jenis_Kelamin=? WHERE ID_Anggota=?";
            try (PreparedStatement st = conn.prepareStatement(sql)) {
                st.setString(1, nama);
                st.setString(2, email);
                st.setString(3, telepon);
                st.setString(4, tgl);
                st.setString(5, jk);
                st.setString(6, id);

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
            String sql = "DELETE FROM Anggota WHERE ID_Anggota=?";
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
