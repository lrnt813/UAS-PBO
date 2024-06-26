package Model;

import Config.Koneksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

public class PeminjamanDialog {
    private Connection conn;
    
    public PeminjamanDialog() {
        conn = Koneksi.getConnection();
    }

    public DefaultTableModel getPeminjamanTableModel() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID Peminjaman");
        model.addColumn("Tanggal Peminjaman");
        model.addColumn("Tanggal Pengembalian");
        model.addColumn("ID Anggota");
        model.addColumn("Nama Anggota");
        model.addColumn("ID Buku");
        model.addColumn("Judul Buku");
        model.addColumn("Pengarang");
        model.addColumn("Penerbit");
        model.addColumn("Jumlah Buku");

        try {
            String sql = "SELECT Detail_Peminjaman.ID_Peminjaman, Tanggal_Peminjaman, Tanggal_Pengembalian, Anggota.ID_Anggota, Nama_Anggota, Buku.ID_Buku, Judul_Buku, Pengarang_Buku, Penerbit, Jumlah_Pinjam "
                       + "FROM Detail_Peminjaman "
                       + "INNER JOIN Peminjaman ON Peminjaman.ID_Peminjaman = Detail_Peminjaman.ID_Peminjaman "
                       + "INNER JOIN Anggota ON Anggota.ID_Anggota = Peminjaman.ID_Anggota "
                       + "INNER JOIN Buku ON Buku.ID_Buku = Detail_Peminjaman.ID_Buku "
                       + "WHERE Status_Peminjaman = 'Sedang dipinjam'";
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                model.addRow(new Object[]{rs.getString("ID_Peminjaman"), rs.getString("Tanggal_Peminjaman"), rs.getString("Tanggal_Pengembalian"), rs.getString("ID_Anggota"), rs.getString("Nama_Anggota"), rs.getString("ID_Buku"), rs.getString("Judul_Buku"), rs.getString("Pengarang_Buku"), rs.getString("Penerbit"), rs.getString("Jumlah_Pinjam")});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return model;
    }

    public DefaultTableModel searchPeminjaman(String keyword) {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID Peminjaman");
        model.addColumn("Tanggal Peminjaman");
        model.addColumn("Tanggal Pengembalian");
        model.addColumn("ID Anggota");
        model.addColumn("Nama Anggota");
        model.addColumn("ID Buku");
        model.addColumn("Judul Buku");
        model.addColumn("Pengarang");
        model.addColumn("Penerbit");
        model.addColumn("Jumlah Buku");

        try {
            String sql = "SELECT Detail_Peminjaman.ID_Peminjaman, Tanggal_Peminjaman, Tanggal_Pengembalian, Anggota.ID_Anggota, Nama_Anggota, Buku.ID_Buku, Judul_Buku, Pengarang_Buku, Penerbit "
                       + "FROM Detail_Peminjaman "
                       + "INNER JOIN Peminjaman ON Peminjaman.ID_Peminjaman = Detail_Peminjaman.ID_Peminjaman "
                       + "INNER JOIN Anggota ON Anggota.ID_Anggota = Peminjaman.ID_Anggota "
                       + "INNER JOIN Buku ON Buku.ID_Buku = Detail_Peminjaman.ID_Buku "
                       + "WHERE Status_Peminjaman = 'Sedang dipinjam' AND (Detail_Peminjaman.ID_Peminjaman LIKE ? OR Tanggal_Peminjaman LIKE ? OR Tanggal_Pengembalian LIKE ? OR Anggota.ID_Anggota LIKE ? OR Nama_Anggota LIKE ? OR Buku.ID_Buku LIKE ? OR Judul_Buku LIKE ? OR Pengarang_Buku LIKE ? OR Penerbit LIKE ?)";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, "%" + keyword + "%");
            st.setString(2, "%" + keyword + "%");
            st.setString(3, "%" + keyword + "%");
            st.setString(4, "%" + keyword + "%");
            st.setString(5, "%" + keyword + "%");
            st.setString(6, "%" + keyword + "%");
            st.setString(7, "%" + keyword + "%");
            st.setString(8, "%" + keyword + "%");
            st.setString(9, "%" + keyword + "%");
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                model.addRow(new Object[]{rs.getString("ID_Peminjaman"), rs.getString("Tanggal_Peminjaman"), rs.getString("Tanggal_Pengembalian"), rs.getString("ID_Anggota"), rs.getString("Nama_Anggota"), rs.getString("ID_Buku"), rs.getString("Judul_Buku"), rs.getString("Pengarang_Buku"), rs.getString("Penerbit")});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return model;
    }
}
