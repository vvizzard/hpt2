/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class ConnectPG {
    
 private static Connection conn;
 public static Connection connect() throws SQLException {
     Connection cn=null;   
     try {
            // Load the mysql driver
            Class.forName("org.postgresql.Driver");

            // Create a connection to the database
            String serverName = "localhost:5432";
            String mydatabase = "Creche";
            String url = "jdbc:postgresql://" + serverName + "/" + mydatabase; // a JDBC url
            String username = "postgres";
            String password = "itu";
            cn=DriverManager.getConnection(url, username, password);
            setConn(cn);
    
        } 
        catch (ClassNotFoundException e) {
            
            e.getMessage();
            
        }
       
        return cn;

    }

    /**
     * @return the conn
     */
    public static Connection getConn() {
        return conn;
    }

    /**
     * @param aConn the conn to set
     */
    public static void setConn(Connection aConn) {
        conn = aConn;
    }
}

