/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codefest;

import java.util.ArrayList;

/**
 *
 * @author USER
 */
public class CodeFest {

    
    public static void main(String[] args) {
        // TODO code application logic here
        
        readFromCSV CSV1 = new readFromCSV();
        DAO dao = new DAO();
        ArrayList<Shiftlist> s = CSV1.readFromCSV();
        dao.addShiftToDB(s);
        
    }
    
}
