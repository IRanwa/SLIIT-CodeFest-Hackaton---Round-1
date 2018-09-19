/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codefest;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Timer;

/**
 *
 * @author USER
 */
public class Calculations {

    Double processingrate = 0.0;
    Double errorPercentage = 0.0;
    int errorCount;
    int totalCount;

    public void incrementError(){
        errorCount++;
    }
    
    public void incrementTotal(){
        totalCount++;
    }
    
    public Double processingRate( long longNum) {
        //System.out.println(Counter + " " + longNum);
        if (longNum != 0) {
            double tempPRate = ((double) totalCount / longNum) * 1000;
            //System.out.println("prrate" + processingrate);
            processingrate = (processingrate+tempPRate)/2;
            //System.out.println("processing "+processingrate);
            return tempPRate;
        }
        return 0.0;
    }

    public Double ErrorRate() {
        double tempERate = ((double) errorCount / totalCount) * 100.0;
        //System.out.println(errorPercentage);
        errorPercentage = (errorPercentage+tempERate)/2;
        return tempERate;
    }

    void reset() {
        errorCount=0;
        totalCount=0;
    }

    Double error5MinRate() {
        return this.errorPercentage;
    }
    
    Double process5MinRate() {
        return this.processingrate;
    }
    
    
}
