/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codefest;

import Model.DailyProcess;
import Model.Employee;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Imesh Ranawaka
 */
public class loadData {

    int noOfIOTDev;
    DAO dao;

    public loadData() {
        dao = new DAO();
        readFromCSV CSV1 = new readFromCSV();
        ArrayList<Shiftlist> list = CSV1.readFromCSV();
        
        ArrayList<String> shifts = new ArrayList<>();
        ArrayList<String> steps = new ArrayList<>();
        
        if (list != null && list.size() > 0) {
            for (Shiftlist s : list) {
                String shiftId = s.getShiftId();
                String stepId = s.getStepId();
                String empId = s.getEmployeeID();
                String empName = s.getEmployeeName();
                String empRole = s.getEmployeeRole();
                
                //Adding Employee Details
                Employee emp;
                if (empRole.equalsIgnoreCase("manager")) {
                    emp = new Employee(empId, empName, 'M');
                }else{
                    emp = new Employee(empId, empName, 'E');
                }
                dao.addEmployee(emp);
                
                boolean flag = true;
                for(String shift : shifts){
                    if(shift.equals(shiftId)){
                        flag = false;
                        break;
                    }
                }
                if(flag){
                    shifts.add(shiftId);
                }
                
                flag = true;
                for(String step : steps){
                    if(step.equals(stepId)){
                        flag = false;
                        break;
                    }
                }
                if(flag){
                    steps.add(stepId);
                }
            }
            
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date();
            DailyProcess dailyProcess = new DailyProcess(formatter.format(date), shifts, steps);
            dao.addShiftDetails(dailyProcess);
            
            
            //dao.addEmployeeStats(, employee)
        } else {
            JOptionPane.showMessageDialog(new JPanel(), "No Shift Details!", "", JOptionPane.ERROR_MESSAGE);
        }
    }
}
