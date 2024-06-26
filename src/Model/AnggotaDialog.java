package Model;

import Config.Koneksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

public class AnggotaDialog {
    private Connection conn;
    
    public AnggotaDialog() {
        conn = Koneksi.getConnection();
    }

    public DefaultTableModel getAnggotaTableModel() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID Anggota");
        model.addColumn("Nama Anggota");
        model.addColumn("Email");
        model.addColumn("Telepon");

        try {
            String sql = "SELECT * FROM Anggota";
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                model.addRow(new Object[]{rs.getString("ID_Anggota"), rs.getString("Nama_Anggota"), rs.getString("Email"), rs.getString("Telepon")});
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

        try {
            String sql = "SELECT * FROM Anggota WHERE ID_Anggota LIKE ? OR Nama_Anggota LIKE ? OR Email LIKE ? OR Telepon LIKE ?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, "%" + keyword + "%");
            st.setString(2, "%" + keyword + "%");
            st.setString(3, "%" + keyword + "%");
            st.setString(4, "%" + keyword + "%");
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                model.addRow(new Object[]{rs.getString("ID_Anggota"), rs.getString("Nama_Anggota"), rs.getString("Email"), rs.getString("Telepon")});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return model;
    }
}
