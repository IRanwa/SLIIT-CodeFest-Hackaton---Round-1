/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codefest;

/**
 *
 * @author USER
 */
class Shiftlist {
    String stepId;
    String employeeID;
    String employeeRole;

    public Shiftlist(String stepId, String employeeID, String employeeRole) {
        this.stepId = stepId;
        this.employeeID = employeeID;
        this.employeeRole = employeeRole;
    }

    Shiftlist() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getStepId() {
        return stepId;
    }

    public void setStepId(String stepId) {
        this.stepId = stepId;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getEmployeeRole() {
        return employeeRole;
    }

    public void setEmployeeRole(String employeeRole) {
        this.employeeRole = employeeRole;
    }
    
    
    
}
