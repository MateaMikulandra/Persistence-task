
package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DbConnector {

    private static Connection conn;

    private DbConnector() {

    }
    public static Connection getConnection() throws SQLException{
        
        if(conn == null){
           conn =  DriverManager.getConnection("jdbc:mysql://localhost/zaposlen", "root", "milisav8");
        }
        return conn;
    }
}
