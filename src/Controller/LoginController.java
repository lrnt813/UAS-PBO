package Controller;

import Model.UserModel;
import View.LoginView;
import View.Menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

public class LoginController {
    private LoginView view;
    private UserModel model;

    public LoginController(LoginView view, UserModel model) {
        this.view = view;
        this.model = model;
        this.view.addLoginListener(new LoginListener());
    }

    class LoginListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (view.validasiInput()) {
                String username = view.getUsername();
                String password = view.getPassword();

                Map<String, String> loginResult = model.checkLogin(username, password);

                if (loginResult != null) {
                    String userID = loginResult.get("ID_User");
                    String namaUser = loginResult.get("Nama_User");
                    String levelUser = loginResult.get("Level");

                    Menu mn = new Menu(userID, namaUser, levelUser);
                    mn.setVisible(true);
                    mn.revalidate();
                    view.dispose();
                } else {
                    view.showError("Username dan Password salah");
                }
            }
        }
    }
}
