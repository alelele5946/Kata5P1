package kata5p1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class InsertarDatosTabla {
    private Connection connect() {
        String url = "jdbc:sqlite:mail.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException ex) {
            Logger.getLogger(InsertarDatosTabla.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    
    }
    public void insert(String email){
        String sql = "INSERT INTO direcc_email(direccion) VALUES(?)";
        try (Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1, email);
            pstmt.executeUpdate();
            System.out.println("Tabla creada");

        } catch (SQLException e){
            System.out.println(e.getMessage());
        

        }
    
    
    }
}
