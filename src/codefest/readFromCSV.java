/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codefest;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USER
 */
public class readFromCSV {
    
    ArrayList<Shiftlist> shiftdata = new ArrayList<>();
    
    File file = new File("Shift.csv");
    
    Scanner sc;

    public  ArrayList<Shiftlist> readFromCSV() {
        try {
            this.sc = new Scanner(file);
            sc.useDelimiter(",");
            
            while (sc.hasNext()) {                
                String stepId = sc.next();
                String employeeID=sc.next();
                String employeeRole=sc.next();
                
                Shiftlist sl = new Shiftlist(stepId, employeeID, employeeRole);
                
                shiftdata.add(sl);
                
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(readFromCSV.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return shiftdata;
    }
    
    
  
}
