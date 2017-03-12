/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.city.acsf405.emp_assessment.domain;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Asus
 */
@Entity
@Table(name = "employee")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Employee.findAll", query = "SELECT e FROM Employee e")
    , @NamedQuery(name = "Employee.findByEmployeeID", query = "SELECT e FROM Employee e WHERE e.employeeID = :employeeID")
    , @NamedQuery(name = "Employee.findByName", query = "SELECT e FROM Employee e WHERE e.name = :name")
    , @NamedQuery(name = "Employee.findByJob", query = "SELECT e FROM Employee e WHERE e.job = :job")})
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "employeeID")
    private Short employeeID;
    @Size(max = 25)
    @Column(name = "name")
    private String name;
    @Size(max = 25)
    @Column(name = "job")
    private String job;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employee")
    private Collection<Assignment> assignmentCollection;
    @JoinColumn(name = "departmentID", referencedColumnName = "departmentID")
    @ManyToOne
    private Department departmentID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employee")
    private Collection<Employeeskills> employeeskillsCollection;

    public Employee() {
    }

    public Employee(Short employeeID) {
        this.employeeID = employeeID;
    }

    public Short getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(Short employeeID) {
        this.employeeID = employeeID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @XmlTransient
    public Collection<Assignment> getAssignmentCollection() {
        return assignmentCollection;
    }

    public void setAssignmentCollection(Collection<Assignment> assignmentCollection) {
        this.assignmentCollection = assignmentCollection;
    }

    public Department getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(Department departmentID) {
        this.departmentID = departmentID;
    }

    @XmlTransient
    public Collection<Employeeskills> getEmployeeskillsCollection() {
        return employeeskillsCollection;
    }

    public void setEmployeeskillsCollection(Collection<Employeeskills> employeeskillsCollection) {
        this.employeeskillsCollection = employeeskillsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (employeeID != null ? employeeID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Employee)) {
            return false;
        }
        Employee other = (Employee) object;
        if ((this.employeeID == null && other.employeeID != null) || (this.employeeID != null && !this.employeeID.equals(other.employeeID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uk.ac.city.acsf405.emp_assessment.domain.Employee[ employeeID=" + employeeID + " ]";
    }
    
}
