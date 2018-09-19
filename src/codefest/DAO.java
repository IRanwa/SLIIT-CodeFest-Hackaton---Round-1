/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codefest;

import Model.DailyProcess;
import Model.Filter;
import Model.Employee;
import Model.Report;
import Model.Stats;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USER
 */
public class DAO {

    private final Connection connection;

    public DAO() {
        connection = Database.getConnection();
    }

    public boolean addEmployee(Employee employee) {
        try {
            PreparedStatement ps = connection.prepareStatement("Insert into employee(EmpID,EmpName,EmpRole) values(?,?,?)");
            ps.setString(1, employee.getEmpId());
            ps.setString(2, employee.getEmpName());
            ps.setString(3, String.valueOf(employee.getEmpRole()));
            return ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean addShiftDetails(DailyProcess dailyProc) {
        try {
            ArrayList<String> shiftsList = dailyProc.getShifts();
            ArrayList<String> stepsList = dailyProc.getSteps();
            
            for (int shiftC = 0; shiftC < shiftsList.size(); shiftC++) {
                for (int stepsC=0;stepsC<stepsList.size();shiftC++ ) {
                    PreparedStatement ps = connection.prepareStatement("Insert into shiftreference(Date,Shift,Step) values(?,?,?)");
                    ps.setString(1, dailyProc.getDate());
                    ps.setString(2, shiftsList.get(shiftC));
                    ps.setString(3, stepsList.get(stepsC));
                    ps.execute();
                }
            }
            return  true;
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean addEmployeeStats(String shiftId, Employee employee){
        try {
            PreparedStatement ps = connection.prepareStatement("Insert into employeestats(id,EmpID) values(?,?,?)");
            ps.setString(1, shiftId);
            ps.setString(2, employee.getEmpId());
            return ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean addReport(Report report){
        try {
            PreparedStatement ps = connection.prepareStatement
        ("Insert into reporttable(shiftRefId,StartTime,EndTime,ProcessRate,Error) values(?,?,?,?,?)");
            ps.setString(1, report.getShiftId());
            ps.setString(2, report.getStartTime());
            ps.setString(3, report.getEndTime());
            ps.setString(4, report.getProcessRate());
            ps.setString(5, report.getErrorRate());
            return ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public List<String> getStepID(){
    
         List<String> StepID = new ArrayList<>();
        try {
           
            PreparedStatement ps = connection.prepareStatement("select Step from shiftreference group by Step");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                String id = rs.getString("Step");
                StepID.add(id);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return StepID;
    }
    
    public List<String> getEmpName(Filter filter, String shift){
    
        List<String> EmpName = new ArrayList<>();
        try {
            
           // List<Integer> tempShiftId = new ArrayList<>();
           // List<String> tempEmpID = new ArrayList<>();
//        String sql= "Select reporttable.shiftRefId from ((reportable inner join shiftreference on reporttable.shiftRefId )"
//                + "inner join )"

           // String sql ="Select employee.EmpName from ((employee inner join shiftreference on reporttable.shiftRefId =shiftreference.id))"

            //String sql ="Select reporttable.shiftRefId from reporttable inner join shiftreference on reporttable.shiftRefId "
                   // + "= shiftreference.Shift where EndTime between " + filter.getStartDate() + "and" + filter.getEndDate();
            
                   
            
            
            String sql = "select * from employee \n" +
                "where EmpID IN (select EmpID from employeestats \n" +
                "where id IN (select shiftRefId from reporttable \n" +
                "where shiftRefId IN (select id from shiftreference \n" +
                "where Shift= " + shift + ") and EndTime between"+ filter.getStartDate()+ " and " + filter.getEndDate() + "));";
                   
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                
                String name = rs.getString("EmpName");
                EmpName.add(name);
            }
            
//            for(int i :tempShiftId){
//                String s = "Select EmpID from employeestats where id = " +i;
//                PreparedStatement pa = connection.prepareStatement(s);
//                ResultSet ra = pa.executeQuery();
//                
//                String Empid = ra.getString("EmpID");
//                
//                tempEmpID.add(Empid);
//            }
//            
//            for(String d :EmpName){
//                
//                String w = "Select EmpName from employee where EmpId = " +d;
//                
//                PreparedStatement pb = connection.prepareStatement(w);
//                ResultSet rb = pb.executeQuery();
//                
//                String getEmpName = rb.getString("EmpName");
//                
//                EmpName.add(getEmpName);
//                
//            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return EmpName;
    }
    
    public List<Stats> getReportDetails(Filter filter) {
        List<Stats> statsList = new ArrayList<>();
        try {
            String sql = "Select avg(Error) as errorPer, avg(ProcessRate) as processRate from reporttable "
                    + "where EndTime between " + filter.getStartDate() + " and " + filter.getEndDate();
            if (!filter.getStepId().equals("All")) {
                sql += "and shiftRefId IN (select id from shiftreference where Step=" + filter.getStepId() + ") ";
            }
            if (!filter.getEmpName().equals("All")) {
                sql += "and shiftRefId IN (select id from employeestatus where "
                        + "EmpID IN (select EmpID from employee where EmpName=" + filter.getEmpName() + ")) ";
            }
            
            switch(filter.getAggTime()){
                case "YEAR":
                    sql+="GROUP by MONTH(EndTime)";
                    break;
                case "Monthly":
                    sql+="GROUP by MONTH(EndTime)";
                    break;
                case "Weekly":
                    sql+="GROUP by WEEK(EndTime)";
                    break;
                case "Daily":
                    sql+="GROUP by DATE(EndTime)";
                    break;
                default:
                    sql+="GROUP by HOUR(EndTime)";
            }
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                double errorRate = rs.getDouble("errorPer");
                double procRate = rs.getDouble("processRate");
                Stats stat = new Stats(errorRate, procRate);
                statsList.add(stat);
            }
            return statsList;
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
