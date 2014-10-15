package com.howtodoinjava.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.howtodoinjava.entity.EmployeeEntity;

@Repository
public class EmployeeDaoImpl implements EmployeeDAO  
{
	//Session factory injected by spring context
    private SessionFactory sessionFactory;
	
    //This method will be called when a employee object is added
	@Override
	public void addEmployee(EmployeeEntity employee) {
		this.sessionFactory.getCurrentSession().save(employee);
	}

	//This method return list of employees in database
	@SuppressWarnings("unchecked")
	@Override
	public List<EmployeeEntity> getAllEmployees(String owner) {
		Query query = this.sessionFactory.getCurrentSession().createQuery("from EmployeeEntity WHERE OWNER = :owner");
		query.setParameter("owner", owner);
		return query.list();
	}

	//Deletes a employee by it's id
	@Override
	public void deleteEmployee(Integer employeeId) {
		EmployeeEntity employee = (EmployeeEntity) sessionFactory.getCurrentSession()
										.load(EmployeeEntity.class, employeeId);
        if (null != employee) {
        	this.sessionFactory.getCurrentSession().delete(employee);
        }
	}

	//This setter will be used by Spring context to inject the sessionFactory instance
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public Boolean authorizeUsernameAndId(String username, Integer Id){
		Query query = this.sessionFactory.getCurrentSession().createQuery("from EmployeeEntity WHERE ID = :id AND OWNER = :username" );
		query.setParameter("username", username);
		query.setParameter("id", Id);
		if (query.uniqueResult() != null){
			return true;
		}
		return false;
	}
}
