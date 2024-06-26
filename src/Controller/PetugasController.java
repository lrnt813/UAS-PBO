package Controller;

import Model.Petugas;
import javax.swing.table.DefaultTableModel;

public class PetugasController {
    private Petugas model;

    public PetugasController(Petugas model) {
        this.model = model;
    }

    public String generateIDPetugas() {
        return model.setIDPetugas();
    }

    public DefaultTableModel getPetugasTableModel() {
        return model.getPetugasTableModel();
    }

    public DefaultTableModel searchPetugas(String keyword) {
        return model.searchPetugas(keyword);
    }

    public boolean addPetugas(String idUser, String namaUser, String usernameUser, String emailUser, String levelUser, String passUser) {
        String id = model.setIDPetugas();
        return model.insertData(idUser, namaUser, usernameUser, emailUser, levelUser, passUser);
    }

    public boolean updatePetugas(String idUser, String namaUser, String usernameUser, String emailUser, String levelUser) {
        return model.updateData(namaUser, usernameUser, emailUser, levelUser, idUser);
    }

    public boolean deletePetugas(String id) {
        return model.deleteData(id);
    }
}
