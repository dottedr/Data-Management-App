/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.city.acsf405.emp_assessment.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Asus
 */
@Embeddable
public class AssignmentPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "clientID")
    private short clientID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "employeeID")
    private short employeeID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "workdate")
    @Temporal(TemporalType.DATE)
    private Date workdate;

    public AssignmentPK() {
    }

    public AssignmentPK(short clientID, short employeeID, Date workdate) {
        this.clientID = clientID;
        this.employeeID = employeeID;
        this.workdate = workdate;
    }

    public short getClientID() {
        return clientID;
    }

    public void setClientID(short clientID) {
        this.clientID = clientID;
    }

    public short getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(short employeeID) {
        this.employeeID = employeeID;
    }

    public Date getWorkdate() {
        return workdate;
    }

    public void setWorkdate(Date workdate) {
        this.workdate = workdate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) clientID;
        hash += (int) employeeID;
        hash += (workdate != null ? workdate.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AssignmentPK)) {
            return false;
        }
        AssignmentPK other = (AssignmentPK) object;
        if (this.clientID != other.clientID) {
            return false;
        }
        if (this.employeeID != other.employeeID) {
            return false;
        }
        if ((this.workdate == null && other.workdate != null) || (this.workdate != null && !this.workdate.equals(other.workdate))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uk.ac.city.acsf405.emp_assessment.domain.AssignmentPK[ clientID=" + clientID + ", employeeID=" + employeeID + ", workdate=" + workdate + " ]";
    }
    
}
