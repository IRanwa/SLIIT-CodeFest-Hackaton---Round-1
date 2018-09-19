/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codefest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author USER
 */
class Database {
    
    public static Connection getConnection(){
        String URL = "jdbc:mysql://localhost:3306/codefest";
        String username = "root";
        String password = "underthekeyboard";
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = (Connection) DriverManager.getConnection(URL,username, password);
            return con;
        }catch(ClassNotFoundException | SQLException ex){
            System.out.println("Database.getConnection() Error ---> "+ex.getMessage());
            return null;
        }
    }
    
    public static void close(Connection con){
        try{
            con.close();
        }catch(Exception ex){
            
        }
    }
}
