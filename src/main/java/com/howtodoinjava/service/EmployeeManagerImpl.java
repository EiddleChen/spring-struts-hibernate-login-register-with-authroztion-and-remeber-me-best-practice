package com.howtodoinjava.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.howtodoinjava.dao.EmployeeDAO;
import com.howtodoinjava.entity.EmployeeEntity;
import com.howtodoinjava.exceptions.InvalidFrontEndAccessException;

public class EmployeeManagerImpl implements EmployeeManager {
	//Employee dao injected by Spring context
    private EmployeeDAO employeeDAO;
	
	//This method will be called when a employee object is added
	@Override
	@Transactional
	public void addEmployee(EmployeeEntity employee) {
		employeeDAO.addEmployee(employee);
	}
	
	//This method return list of employees in database
	@Override
	@Transactional
	public List<EmployeeEntity> getAllEmployees(String owner) {
		return employeeDAO.getAllEmployees(owner);
	}
	//Deletes a employee by it's id
	@Override
	@Transactional
	public void deleteEmployee(String owner, Integer employeeId) throws InvalidFrontEndAccessException {
		if (employeeDAO.authorizeUsernameAndId(owner, employeeId)){
			employeeDAO.deleteEmployee(employeeId);
		} else {
			throw new InvalidFrontEndAccessException();
		}
	}
	
	//This setter will be used by Spring context to inject the dao's instance
	public void setEmployeeDAO(EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}
}
