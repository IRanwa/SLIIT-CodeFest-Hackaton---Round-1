/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codefest;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author USER
 */
public class CodeFest {

    final static int noOfIOTDev = 5; 
    
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

        Timer timer1hrs = new Timer();
        ArrayList<Calculations> calList = new ArrayList<>();
        for (int x = 0; noOfIOTDev > x; x++) {
            calList.add(new Calculations());
        }

        timer1hrs.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {

                Timer timer5min = new Timer();

                timer5min.scheduleAtFixedRate(new TimerTask() {
                    @Override
                    public void run() {

                        Timer timer1second = new Timer();

                        timer1second.scheduleAtFixedRate(new TimerTask() {

                            //Get current time in milliseconds
                            long start = System.currentTimeMillis();

                            @Override
                            public void run() {
                                System.out.println("Seconds");
                                
                                //Reset error and total count of each IOT device every 1 second
                                for (int x = 0; x < calList.size(); x++) {
                                    calList.get(x).reset();
                                }
                                
                                //Randomly generate messages
                                Random r = new Random();
                                //Get no of items go through each product line randomly (Between 800 - 1000 Items)
                                int noOfItem = r.nextInt(1000 - 800+1)+800;
                                for (int x = 0; x < noOfItem; x++) {
                                    //Get IOT Device No
                                    int iotDevNo = r.nextInt(5 - 1 + 1) + 1;
                                    //Get Received item error or not (error when value = 1)
                                    int num = r.nextInt(2 - 1 + 1) + 1;
                                    if (num == 1) {
                                        //Increment each IOT Device error count
                                        calList.get(iotDevNo - 1).incrementError();
                                    }
                                    //Increment each IOT Device total count
                                    calList.get(iotDevNo - 1).incrementTotal();
                                }

                                //Display each IOT device error rate and processing rate per second
                                for (int x = 0; x < calList.size(); x++) {
                                    System.out.println("IOT Device " + x + "\n------------------------------------");
                                    System.out.println("Error Rate " + calList.get(x).ErrorRate());
                                    System.out.println("Processing Rate "
                                            + calList.get(x).processingRate(System.currentTimeMillis() - start));
                                    System.out.println("");
                                }
                                System.out.println("");
                                //Get current time in milliseconds
                                start = System.currentTimeMillis();
                            }
                        }, 0, 1000);
                        //Display each IOT device error rate and processing rate every 5 Minutes
                        System.out.println("Hourly");
                        for (int x = 0; x < calList.size(); x++) {
                            System.out.println("IOT Device " + x + "\n------------------------------------");
                            System.out.println("Error Rate " + calList.get(x).error5MinRate());
                            System.out.println("Processing Rate "
                                    + calList.get(x).process5MinRate());
                            System.out.println("");
                        }
                    }
                }, 0, 1000 * 60 * 5);
                
            }
        }, 0, 1000 * 60 * 60);

    }

}
