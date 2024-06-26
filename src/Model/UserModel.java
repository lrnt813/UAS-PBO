package Model;

import Config.Koneksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class UserModel {
    private Connection conn;

    public UserModel() {
        conn = Koneksi.getConnection();
    }

    public Map<String, String> checkLogin(String username, String password) {
        Map<String, String> result = new HashMap<>();

        if (conn != null) {
            try {
                String sql = "SELECT * FROM User WHERE Username=? AND Password=?";
                PreparedStatement st = conn.prepareStatement(sql);
                st.setString(1, username);
                st.setString(2, password);

                ResultSet rs = st.executeQuery();
                if (rs.next()) {
                    result.put("ID_User", rs.getString("ID_User"));
                    result.put("Nama_User", rs.getString("Nama_User"));
                    result.put("Level", rs.getString("Level"));
                    return result;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
