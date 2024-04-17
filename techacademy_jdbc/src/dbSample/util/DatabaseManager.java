package dbSample.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DatabaseManager {

private static Connection con;

public static Connection getConnection() throws SQLException,ClassNotFoundException{
    
    Class.forName("com.mysql.cj.jdc.Driver");
    
    con=DriverManager.getConnection(
            "jdbc:mysql://localhost/world?useSSL=false&allowPublicKeyRetrieal=true",
            "root",
            "Xfhy_27967"
            );
    
    return con;
} 
   
public  static void close() {
    
    if(con!=null) {
        try {
            con.close();
        }catch(SQLException e) {
            e.printStackTrace();
            
        }
    
}
}

}
