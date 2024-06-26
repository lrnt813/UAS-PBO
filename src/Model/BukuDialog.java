package Model;

import Config.Koneksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

public class BukuDialog {
    private Connection conn;
    
    public BukuDialog() {
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

        try {
            String sql = "SELECT * FROM Buku";
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                model.addRow(new Object[]{rs.getString("ID_Buku"), rs.getString("Judul_Buku"), rs.getString("Kategori"), rs.getString("Pengarang_Buku"), rs.getString("Penerbit"), rs.getString("Tahun_Terbit")});
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

        try {
            String sql = "SELECT * FROM Buku WHERE ID_Buku LIKE ? OR Judul_Buku LIKE ? OR Kategori LIKE ? OR Pengarang_Buku LIKE ? OR Penerbit LIKE ? OR Tahun_Terbit LIKE ?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, "%" + keyword + "%");
            st.setString(2, "%" + keyword + "%");
            st.setString(3, "%" + keyword + "%");
            st.setString(4, "%" + keyword + "%");
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                model.addRow(new Object[]{rs.getString("ID_Buku"), rs.getString("Judul_Buku"), rs.getString("Kategori"), rs.getString("Pengarang_Buku"), rs.getString("Penerbit"), rs.getString("Tahun_Terbit")});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return model;
    }
}
