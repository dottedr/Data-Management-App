/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.city.acsf405.emp_assessment.dataaccess;

import java.util.List;
import uk.ac.city.acsf405.emp_assessment.domain.*;

/**
 *
 * @author Elmar Talibzade
 */
public interface EmployeeDataManager 
{
    List<EmployeeskillsPK> AllEmployeeSkillsPK();
    List<AssignmentPK> AllAssigmentsPK();
    List<Employeeskills> AllEmployeeSkills();
    
    List<Employee> AllEmployees();
    List<Department> AllDepartments();
    List<Client> AllClients();
    List<Assignment> AllAssignments();
    
    Employee findEmployeeById(int ID);
    Client findClientByName(String name);
    
    void AddEmployee(Employee newEmployee);
}