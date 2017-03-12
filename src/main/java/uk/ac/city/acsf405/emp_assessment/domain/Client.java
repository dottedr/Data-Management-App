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
@Table(name = "client")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Client.findAll", query = "SELECT c FROM Client c")
    , @NamedQuery(name = "Client.findByClientID", query = "SELECT c FROM Client c WHERE c.clientID = :clientID")
    , @NamedQuery(name = "Client.findByName", query = "SELECT c FROM Client c WHERE c.name = :name")
    , @NamedQuery(name = "Client.findByAddress", query = "SELECT c FROM Client c WHERE c.address = :address")
    , @NamedQuery(name = "Client.findByContactPerson", query = "SELECT c FROM Client c WHERE c.contactPerson = :contactPerson")
    , @NamedQuery(name = "Client.findByContactNumber", query = "SELECT c FROM Client c WHERE c.contactNumber = :contactNumber")})
public class Client implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "clientID")
    private Short clientID;
    @Size(max = 20)
    @Column(name = "name")
    private String name;
    @Size(max = 30)
    @Column(name = "address")
    private String address;
    @Size(max = 20)
    @Column(name = "contactPerson")
    private String contactPerson;
    @Size(max = 20)
    @Column(name = "contactNumber")
    private String contactNumber;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "client")
    private Collection<Assignment> assignmentCollection;

    public Client() {
    }

    public Client(Short clientID) {
        this.clientID = clientID;
    }

    public Short getClientID() {
        return clientID;
    }

    public void setClientID(Short clientID) {
        this.clientID = clientID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    @XmlTransient
    public Collection<Assignment> getAssignmentCollection() {
        return assignmentCollection;
    }

    public void setAssignmentCollection(Collection<Assignment> assignmentCollection) {
        this.assignmentCollection = assignmentCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (clientID != null ? clientID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Client)) {
            return false;
        }
        Client other = (Client) object;
        if ((this.clientID == null && other.clientID != null) || (this.clientID != null && !this.clientID.equals(other.clientID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uk.ac.city.acsf405.emp_assessment.domain.Client[ clientID=" + clientID + " ]";
    }
    
}
