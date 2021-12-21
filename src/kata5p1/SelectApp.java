package kata5p1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectApp {
    // conecta con la BD y devuelve un objeto Connection
    private Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:KATA5.db" ;
        Connection conn = null;
        
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
        
        
    }
    
    // Seleccionamos todos los registros de la tabla
    public void SelectAll(){
        String sql = "SELECT * FROM PEOPLE";
        try (
            
            Connection conn = this.connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)){
            
            //Bucle sobre el conjunto de registros.
            while (rs.next()){
                System.out.println(rs.getInt("Id")+ "\t" + rs.getString("Name")+ "\t" + rs.getString("Apellidos")+ "\t" + rs.getString("Departamento") + "\t");
            }
        
        }
         catch (SQLException e) {
             System.out.println(e.getMessage());
         }
    }
}
