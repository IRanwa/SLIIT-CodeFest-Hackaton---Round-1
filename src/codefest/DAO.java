/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codefest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USER
 */
public class DAO {
    
    private Connection connection;
    
    public DAO(){
        connection = Database.getConnection();
    }
    
    public void addShiftToDB(ArrayList<Shiftlist> s){
        
        
        try {
            Iterator it = s.iterator();
            
            while (it.hasNext()) {                
                
                Shiftlist sl = (Shiftlist)it.next();
                
                PreparedStatement ps = connection.prepareStatement("Insert to ReportTable(StepID,EmployeeID,EmployeeRole) values(?,?,?,)");
                ps.setString(1,sl.getStepId());
                ps.setString(2, sl.getEmployeeID());
                ps.setString(3, sl.getEmployeeRole());

            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    
    
    }
}
