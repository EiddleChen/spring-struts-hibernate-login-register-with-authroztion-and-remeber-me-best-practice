package com.howtodoinjava.controller;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.SessionAware;

import com.howtodoinjava.entity.EmployeeEntity;
import com.howtodoinjava.exceptions.InvalidFrontEndAccessException;
import com.howtodoinjava.service.EmployeeManager;
import com.howtodoinjava.service.UserDetails;
import com.howtodoinjava.service.UserManager;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

public class EditEmployeeAction extends ActionSupport implements Preparable, SessionAware
{
	// Session injected by SessionAware
	private Map session;
	
	private static final long serialVersionUID = 1L;	
	//Logger configured using log4j
	private static final Logger logger = Logger.getLogger(EditEmployeeAction.class);
	//List of employees; Setter and Getter are below
	private List<EmployeeEntity> employees;
	//Employee object to be added; Setter and Getter are below
	private EmployeeEntity employee;
	
	//Employee manager injected by spring context; This is cool !!
	private EmployeeManager employeeManager;


	//This method return list of employees in database
	public String listEmployees() {
		logger.info("listEmployees method called");
		employees = employeeManager.getAllEmployees(getUsernameFromCurrentSession());
		return SUCCESS;
	}

	//This method will be called when a employee object is added
	public String addEmployee() {
		logger.info("addEmployee method called");
		employee.setOwner(((UserDetails)session.get(LoginInterceptor.USER_SESSION_KEY)).getUsername());
		employeeManager.addEmployee(employee);
		return SUCCESS;
	}

	//Deletes a employee by it's id passed in path parameter
	public String deleteEmployee() throws InvalidFrontEndAccessException {
		logger.info("deleteEmployee method called");
		employeeManager.deleteEmployee(this.getUsernameFromCurrentSession(),employee.getId());
		return SUCCESS;
	}
	
	//This method will be called before any of Action method is invoked;
	//So some pre-processing if required.
	@Override
	public void prepare() throws Exception {
		employee = null;
	}

	public void setEmployeeManager(EmployeeManager employeeManager) {
		this.employeeManager = employeeManager;
	}

	public List<EmployeeEntity> getEmployees() {
		return employees;
	}

	public void setEmployees(List<EmployeeEntity> employees) {
		this.employees = employees;
	}

	public EmployeeEntity getEmployee() {
		return employee;
	}

	public void setEmployee(EmployeeEntity employee) {
		this.employee = employee;
	}

	@Override
	public void setSession(Map session) {
		this.session = session;
	}
	
	private String getUsernameFromCurrentSession(){
		return ((UserDetails)this.session.get(LoginInterceptor.USER_SESSION_KEY)).getUsername();
	}
}
