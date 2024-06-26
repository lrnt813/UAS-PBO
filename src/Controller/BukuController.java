package Controller;

import Model.Buku;
import javax.swing.table.DefaultTableModel;

public class BukuController {
    private Buku model;

    public BukuController(Buku model) {
        this.model = model;
    }

    public String generateIDBuku() {
        return model.setIDBuku();
    }

    public DefaultTableModel getBukuTableModel() {
        return model.getBukuTableModel();
    }

    public DefaultTableModel searchBuku(String keyword) {
        return model.searchBuku(keyword);
    }

    public boolean addBuku(String idBuku, String judulBuku, String kategoriBuku, String pengarangBuku, String penerbitBuku, String tahunBuku, String stokBuku) {
        String id = model.setIDBuku();
        return model.insertData(idBuku, judulBuku, kategoriBuku, pengarangBuku, penerbitBuku, tahunBuku, stokBuku);
    }

    public boolean updateBuku(String idBuku, String judulBuku, String kategoriBuku, String pengarangBuku, String penerbitBuku, String tahunBuku, String stokBuku) {
        return model.updateData(judulBuku, kategoriBuku, pengarangBuku, penerbitBuku, tahunBuku, stokBuku, idBuku);
    }

    public boolean deleteBuku(String id) {
        return model.deleteData(id);
    }
}
