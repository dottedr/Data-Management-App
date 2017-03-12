/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.city.acsf405.emp_assessment.services;

import uk.ac.city.acsf405.emp_assessment.domain.*;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import uk.ac.city.acsf405.emp_assessment.dataaccess.EmployeeDataManager;

/**
 *
 * @author Elmar Talibzade
 */

@Stateless
public class EmployeeManagementServiceImpl implements EmployeeManagementService
{
    @EJB
    private EmployeeDataManager dao;
    
    @Override
    public List<Department> findAllDepartments() 
    {
        return dao.AllDepartments();
    }

    @Override
    public List<Client> findAllClients() 
    {
        return dao.AllClients();
    }
    
    @Override
    public List<Employee> findAllEmployees() 
    {
        return dao.AllEmployees();
    }
    
    @Override
    public Employee findEmployeeById(int ID) 
    {
        return dao.findEmployeeById(ID);
    }

    @Override
    public Client findClientByName(String name) 
    {
        return dao.findClientByName(name);
    }

    @Override
    public List<Employee> addEmployee(Employee newEmployee) 
    {
        dao.AddEmployee(newEmployee);
        return dao.AllEmployees();
    }
}