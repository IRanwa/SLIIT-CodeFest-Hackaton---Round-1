/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codefest;

import java.time.LocalTime;
import java.util.Timer;

/**
 *
 * @author USER
 */
public class Calculations extends Thread{
    
    

    public Double processingRate(int Counter,Timer timer) {
       
        String tString = timer.toString();
        Double t = Double.parseDouble(tString);
        Double processingrate = (Counter/t);
        
        return processingrate;
    }
    
    public Double ErrorRate (int total, int errorNum){
        
        Double errorPercentage = ((double)errorNum/total)*100.0;
        
        return errorPercentage;
    }
}
