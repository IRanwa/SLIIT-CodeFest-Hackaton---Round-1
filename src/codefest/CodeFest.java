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
        
        Timer timer1hrs= new Timer();
       
        timer1hrs.scheduleAtFixedRate(new TimerTask(){
            @Override
            public void run() {
                
                Timer timer5min = new Timer();
                
                timer5min.scheduleAtFixedRate(new TimerTask() {
                    @Override
                    public void run() {
                        
                        Timer timer1second = new Timer();
                        
                        timer1second.scheduleAtFixedRate(new TimerTask() {
                            
                             long start = System.currentTimeMillis();
                             
                            @Override
                            public void run() {
                                
//                                System.out.println("Time "+ (System.currentTimeMillis()-start));
//                                int x =0;
//                                for(;x<100000;x++){
//                                
//                                }
//                                
//                                System.out.println("intms" + x);
//                                
//                                start= System.currentTimeMillis();
                                Calculations iot2 = new Calculations();
                                Calculations iot3 = new Calculations();
                                Calculations iot4 = new Calculations();
                                Calculations iot5 = new Calculations();

                                int counter = 0;
                                iot2.processingRate(counter,timer1second);
                                iot3.processingRate(counter, timer1second);
                                iot4.processingRate(counter, timer1second);
                                iot5.processingRate(counter, timer1second);
                                    }
                        }, 0, 1000);
                        
                
                
                    }
                }, 0, 300000);
                
            }
        
        },0,3600000);
        
        
        
        
    }
    
}
