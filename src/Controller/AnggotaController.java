package Controller;

import Model.Anggota;
import javax.swing.table.DefaultTableModel;

public class AnggotaController {
    private Anggota model;

    public AnggotaController(Anggota model) {
        this.model = model;
    }

    public String generateIDAnggota() {
        return model.setIDAnggota();
    }

    public DefaultTableModel getAnggotaTableModel() {
        return model.getAnggotaTableModel();
    }

    public DefaultTableModel searchAnggota(String keyword) {
        return model.searchAnggota(keyword);
    }

    public boolean addAnggota(String nama, String email, String telepon, String tgl, String jk) {
        String id = model.setIDAnggota();
        return model.insertData(id, nama, email, telepon, tgl, jk);
    }

    public boolean updateAnggota(String id, String nama, String email, String telepon, String tgl, String jk) {
        return model.updateData(id, nama, email, telepon, tgl, jk);
    }

    public boolean deleteAnggota(String id) {
        return model.deleteData(id);
    }
}
