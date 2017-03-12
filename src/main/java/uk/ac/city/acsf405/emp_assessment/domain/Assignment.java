/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.city.acsf405.emp_assessment.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Asus
 */
@Entity
@Table(name = "assignment")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Assignment.findAll", query = "SELECT a FROM Assignment a")
    , @NamedQuery(name = "Assignment.findByClientID", query = "SELECT a FROM Assignment a WHERE a.assignmentPK.clientID = :clientID")
    , @NamedQuery(name = "Assignment.findByEmployeeID", query = "SELECT a FROM Assignment a WHERE a.assignmentPK.employeeID = :employeeID")
    , @NamedQuery(name = "Assignment.findByWorkdate", query = "SELECT a FROM Assignment a WHERE a.assignmentPK.workdate = :workdate")
    , @NamedQuery(name = "Assignment.findByHours", query = "SELECT a FROM Assignment a WHERE a.hours = :hours")})
public class Assignment implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AssignmentPK assignmentPK;
    @Column(name = "hours")
    private Integer hours;
    @JoinColumn(name = "clientID", referencedColumnName = "clientID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Client client;
    @JoinColumn(name = "employeeID", referencedColumnName = "employeeID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Employee employee;

    public Assignment() {
    }

    public Assignment(AssignmentPK assignmentPK) {
        this.assignmentPK = assignmentPK;
    }

    public Assignment(short clientID, short employeeID, Date workdate) {
        this.assignmentPK = new AssignmentPK(clientID, employeeID, workdate);
    }

    public AssignmentPK getAssignmentPK() {
        return assignmentPK;
    }

    public void setAssignmentPK(AssignmentPK assignmentPK) {
        this.assignmentPK = assignmentPK;
    }

    public Integer getHours() {
        return hours;
    }

    public void setHours(Integer hours) {
        this.hours = hours;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (assignmentPK != null ? assignmentPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Assignment)) {
            return false;
        }
        Assignment other = (Assignment) object;
        if ((this.assignmentPK == null && other.assignmentPK != null) || (this.assignmentPK != null && !this.assignmentPK.equals(other.assignmentPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uk.ac.city.acsf405.emp_assessment.domain.Assignment[ assignmentPK=" + assignmentPK + " ]";
    }
    
}
