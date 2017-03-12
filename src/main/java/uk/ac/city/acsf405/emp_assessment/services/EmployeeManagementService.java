/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.city.acsf405.emp_assessment.services;
import java.util.List;
import uk.ac.city.acsf405.emp_assessment.domain.*;

/**
 *
 * @author Elmar Talibzade
 */
public interface EmployeeManagementService 
{
    List<Employee> findAllEmployees();
    List<Department> findAllDepartments();
    List<Client> findAllClients();
    
    Employee findEmployeeById(int ID);
    Client findClientByName(String name);
    
    List<Employee> addEmployee(Employee newEmployee);
}