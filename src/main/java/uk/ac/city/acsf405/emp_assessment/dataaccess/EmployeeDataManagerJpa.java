/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.city.acsf405.emp_assessment.dataaccess;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;
import uk.ac.city.acsf405.emp_assessment.domain.Assignment;
import uk.ac.city.acsf405.emp_assessment.domain.AssignmentPK;
import uk.ac.city.acsf405.emp_assessment.domain.Client;
import uk.ac.city.acsf405.emp_assessment.domain.Department;
import uk.ac.city.acsf405.emp_assessment.domain.Employee;
import uk.ac.city.acsf405.emp_assessment.domain.Employeeskills;
import uk.ac.city.acsf405.emp_assessment.domain.EmployeeskillsPK;

/**
 *
 * @author Elmar Talibzade
 */
@Stateless
public class EmployeeDataManagerJpa implements EmployeeDataManager
{
    @PersistenceContext
    private EntityManager em;
    
    @Override
    public List<Client> AllClients() 
    {
        TypedQuery<Client> query = em.createNamedQuery("Client.findAll", Client.class);
        return query.getResultList(); 
    }

    @Override
    public List<Employeeskills> AllEmployeeSkills() 
    {
        TypedQuery<Employeeskills> query = em.createNamedQuery("Employeeskills.findAll", Employeeskills.class);
        return query.getResultList(); 
    }

    @Override
    public List<EmployeeskillsPK> AllEmployeeSkillsPK() 
    {
        TypedQuery<EmployeeskillsPK> query = em.createNamedQuery("EmployeeskillsPK.findAll", EmployeeskillsPK.class);
        return query.getResultList(); 
    }

    @Override
    public List<Assignment> AllAssignments() 
    {
        TypedQuery<Assignment> query = em.createNamedQuery("Assignment.findAll", Assignment.class);
        return query.getResultList(); 
    }

    @Override
    public List<AssignmentPK> AllAssigmentsPK() 
    {
        TypedQuery<AssignmentPK> query = em.createNamedQuery("AssignmentPK.findAll", AssignmentPK.class);
        return query.getResultList(); 
    }
    
    @Override
    public List<Department> AllDepartments() 
    {
        TypedQuery<Department> query = em.createNamedQuery("Department.findAll", Department.class);
        return query.getResultList();    
    }
    
    @Override
    public List<Employee> AllEmployees() 
    {
        TypedQuery<Employee> query = em.createNamedQuery("Employee.findAll", Employee.class);
        return query.getResultList();
    }
    
    @Override
    public Employee findEmployeeById(int ID) 
    {
        TypedQuery<Employee> query = em.createNamedQuery("Employee.findByEmployeeID", Employee.class);
        query.setParameter("employeeID", ID);
        return query.getSingleResult();
    }

    @Override
    public Client findClientByName(String name) 
    {
        TypedQuery<Client> query = em.createNamedQuery("Client.findByName", Client.class);
        query.setParameter("name", name);
        return query.getSingleResult();
    }

    
    
    @Override
    public void AddEmployee(Employee newEmployee) 
    {
        em.persist(newEmployee);
    }    
}