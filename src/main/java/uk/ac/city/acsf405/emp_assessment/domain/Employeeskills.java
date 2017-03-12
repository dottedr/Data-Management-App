/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.city.acsf405.emp_assessment.domain;

import java.io.Serializable;
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
@Table(name = "employeeskills")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Employeeskills.findAll", query = "SELECT e FROM Employeeskills e")
    , @NamedQuery(name = "Employeeskills.findByEmployeeID", query = "SELECT e FROM Employeeskills e WHERE e.employeeskillsPK.employeeID = :employeeID")
    , @NamedQuery(name = "Employeeskills.findBySkill", query = "SELECT e FROM Employeeskills e WHERE e.employeeskillsPK.skill = :skill")})
public class Employeeskills implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EmployeeskillsPK employeeskillsPK;
    @JoinColumn(name = "employeeID", referencedColumnName = "employeeID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Employee employee;

    public Employeeskills() {
    }

    public Employeeskills(EmployeeskillsPK employeeskillsPK) {
        this.employeeskillsPK = employeeskillsPK;
    }

    public Employeeskills(short employeeID, String skill) {
        this.employeeskillsPK = new EmployeeskillsPK(employeeID, skill);
    }

    public EmployeeskillsPK getEmployeeskillsPK() {
        return employeeskillsPK;
    }

    public void setEmployeeskillsPK(EmployeeskillsPK employeeskillsPK) {
        this.employeeskillsPK = employeeskillsPK;
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
        hash += (employeeskillsPK != null ? employeeskillsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Employeeskills)) {
            return false;
        }
        Employeeskills other = (Employeeskills) object;
        if ((this.employeeskillsPK == null && other.employeeskillsPK != null) || (this.employeeskillsPK != null && !this.employeeskillsPK.equals(other.employeeskillsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uk.ac.city.acsf405.emp_assessment.domain.Employeeskills[ employeeskillsPK=" + employeeskillsPK + " ]";
    }
    
}