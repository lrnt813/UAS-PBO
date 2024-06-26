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
public class Buku {
    private Connection conn;
    
    public Buku() {
        conn = Koneksi.getConnection();
    }
    
    public DefaultTableModel getBukuTableModel() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID Buku");
        model.addColumn("Judul Buku");
        model.addColumn("Kategori");
        model.addColumn("Pengarang");
        model.addColumn("Penerbit");
        model.addColumn("Tahun Terbit");
        model.addColumn("Stok Buku");

        try {
            String sql = "SELECT * FROM Buku";
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                model.addRow(new Object[]{rs.getString("ID_Buku"), rs.getString("Judul_Buku"), rs.getString("Kategori"), rs.getString("Pengarang_Buku"), rs.getString("Penerbit"), rs.getString("Tahun_Terbit"), rs.getString("Stok")});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return model;
    }

    public DefaultTableModel searchBuku(String keyword) {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID Buku");
        model.addColumn("Judul Buku");
        model.addColumn("Kategori");
        model.addColumn("Pengarang");
        model.addColumn("Penerbit");
        model.addColumn("Tahun Terbit");
        model.addColumn("Stok Buku");

        try {
            String sql = "SELECT * FROM Buku WHERE ID_Buku LIKE ? OR Judul_Buku LIKE ? OR Kategori LIKE ? OR Pengarang_Buku LIKE ? OR Penerbit LIKE ? OR Tahun_Terbit LIKE ?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, "%" + keyword + "%");
            st.setString(2, "%" + keyword + "%");
            st.setString(3, "%" + keyword + "%");
            st.setString(4, "%" + keyword + "%");
            st.setString(5, "%" + keyword + "%");
            st.setString(6, "%" + keyword + "%");
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                model.addRow(new Object[]{rs.getString("ID_Buku"), rs.getString("Judul_Buku"), rs.getString("Kategori"), rs.getString("Pengarang_Buku"), rs.getString("Penerbit"), rs.getString("Tahun_Terbit")});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return model;
    }
    
    public String setIDBuku() {
        String urutan = null;
        Date now = new Date();
        SimpleDateFormat noFormat = new SimpleDateFormat("yyMM");
        String no = noFormat.format(now);

       String sql = "SELECT SUBSTR(ID_Buku, -4) AS Nomor FROM Buku WHERE ID_Buku LIKE 'BK" + no + "%' ORDER BY ID_Buku DESC LIMIT 1";
    
        try (PreparedStatement st = conn.prepareStatement(sql)) {
            ResultSet rs = st.executeQuery();
            
            if (rs.next()) {
                int nomor = Integer.parseInt(rs.getString("Nomor")) + 1;
                urutan = "BK" + no + String.format("%03d", nomor);
            } else {
                urutan = "BK" + no + "0001";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return urutan;
    }
    
    public boolean insertData(String idBuku, String judulBuku, String kategoriBuku, String pengarangBuku, String penerbitBuku, String tahunBuku, String stokBuku) {
        try {
            String sql = "INSERT INTO Buku (ID_Buku, Judul_Buku, Kategori, Pengarang_Buku, Penerbit, Tahun_Terbit, Stok) VALUES (?,?,?,?,?,?,?)";
            try (PreparedStatement st = conn.prepareStatement(sql)) {
                st.setString(1, idBuku);
                st.setString(2, judulBuku);
                st.setString(3, kategoriBuku);
                st.setString(4, pengarangBuku);
                st.setString(5, penerbitBuku);
                st.setString(6, tahunBuku);
                st.setString(7, stokBuku);

                int rowInserted = st.executeUpdate();
                return rowInserted > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateData(String idBuku, String judulBuku, String kategoriBuku, String pengarangBuku, String penerbitBuku, String tahunBuku, String stokBuku) {
        try {
            String sql = "UPDATE Buku SET Judul_Buku=?, Kategori=?, Pengarang_Buku=?, Penerbit=?, Tahun_Terbit=?, Stok=? WHERE ID_Buku=?";
            try (PreparedStatement st = conn.prepareStatement(sql)) {
                st.setString(1, judulBuku);
                st.setString(2, kategoriBuku);
                st.setString(3, pengarangBuku);
                st.setString(4, penerbitBuku);
                st.setString(5, tahunBuku);
                st.setString(6, stokBuku);
                st.setString(7, idBuku);

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
            String sql = "DELETE FROM Buku WHERE ID_Buku=?";
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
