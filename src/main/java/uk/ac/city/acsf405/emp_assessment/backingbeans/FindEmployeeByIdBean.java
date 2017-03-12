/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.city.acsf405.emp_assessment.backingbeans;

import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import uk.ac.city.acsf405.emp_assessment.domain.*;
import uk.ac.city.acsf405.emp_assessment.services.EmployeeManagementService;

/**
 *
 * @author Elmar Talibzade
 */

@ManagedBean (name="findEmployeeByIdBean")
public class FindEmployeeByIdBean 
{
    @EJB
    private EmployeeManagementService service;
    private Employee employee;
    
    public String findEmployeeById(int ID)
    {
        employee = service.findEmployeeById(ID);
        return "allEmployees";
    }
}