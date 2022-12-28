/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crud;

/**
 *
 * @author abida
 */
import java.sql.*;
import crud.DatabaseError;

public class DatabaseUtil {
    static Connection conn;
    static ResultSet result;
    static Statement stmt;
    
    static String database = "dsra";
    static String port = "3306";
    static String url = "jdbc:mysql://localhost:"+port+"/"+database;
    static String user = "root";
    static String pass = "";
  
    public static void CheckConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url,user,pass);
            stmt = conn.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            throw new DatabaseError("Tidak bisa konek database");
        }
    }
}
