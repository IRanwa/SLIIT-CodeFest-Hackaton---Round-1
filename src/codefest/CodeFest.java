/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codefest;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

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
        
        LocalDate date = java.time.LocalDate.now();
        String d = String.valueOf(date);
        
        System.out.println(d);
        
        LocalTime startTime = java.time.LocalTime.now();
        String st = String.valueOf(startTime);
        System.out.println(st);
        
        Timer timer= new Timer();
        
        timer.scheduleAtFixedRate(new TimerTask(){
            @Override
            public void run() {
                Calculations iot2 = new Calculations();
                Calculations iot3 = new Calculations();
                Calculations iot4 = new Calculations();
                Calculations iot5 = new Calculations();
                
                int counter = 0;
                iot2.processingRate(counter,timer);
                iot3.processingRate(counter, timer);
                iot4.processingRate(counter, timer);
                iot5.processingRate(counter, timer);
                
                
            }
        
        },0,3600000);
        
        
        
        
        
    }
    
}
