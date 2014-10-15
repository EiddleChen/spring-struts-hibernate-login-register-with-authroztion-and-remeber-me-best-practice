package com.howtodoinjava.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.howtodoinjava.entity.EmployeeEntity;
import com.howtodoinjava.entity.PersistentLoginsEntity;
import com.howtodoinjava.entity.UserEntity;
import com.howtodoinjava.exceptions.InvalidCookiesException;
import com.howtodoinjava.exceptions.InvalidDataAccessException;

@Repository
public class UserDAOImpl implements UserDAO {
    private SessionFactory sessionFactory;
    
	//This setter will be used by Spring context to inject the sessionFactory instance
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	
	}

	@SuppressWarnings("unchecked") 
	@Override
	public String getPasswordsByUsername(String username) {
		
		Query query = sessionFactory.getCurrentSession().createQuery(
				"FROM UserEntity WHERE USERNAME = :username");
		query.setParameter("username", username);
		List <UserEntity> UserEntities = query.list();
		return UserEntities.get(0).getPassword();
	}

	@Override
	public void createPersistentLoginsEntity(String username, String series, String token, String LastUsed) {
		PersistentLoginsEntity persistentLoginsEntity = new PersistentLoginsEntity();
		persistentLoginsEntity.setUsername(username);
		persistentLoginsEntity.setSeries(series);
		persistentLoginsEntity.setToken(token);
		persistentLoginsEntity.setLastUsed(LastUsed);
		this.sessionFactory.getCurrentSession().save(persistentLoginsEntity);
	}

	@SuppressWarnings("unchecked")
	@Override
	public String getUsernameBySeriesAndToken(String series, String token) throws InvalidCookiesException {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"FROM PersistentLoginsEntity WHERE SERIES = :series AND TOKEN = :token " );
		query.setParameter("series", series);
		query.setParameter("token", token);		
		List <PersistentLoginsEntity> PersistentLoginsEntities = query.list();
		if (PersistentLoginsEntities.get(0) != null){
			return PersistentLoginsEntities.get(0).getUsername();
		} else {
			throw new InvalidCookiesException();
		}
	}

	@Override
	public void setTokenBySeries(String series, String token) throws InvalidDataAccessException {
		try {
			Query query  = sessionFactory.getCurrentSession().createQuery(
				"UPDATE PersistentLoginsEntity SET TOKEN = :token WHERE SERIES = :series");
			query.setParameter("series", series);
			query.setParameter("token", token);
			query.executeUpdate();
		} catch (Exception e){
			throw new InvalidDataAccessException();
		}
	}

	@Override
	public void addUserEntity(UserEntity userEntity) throws InvalidDataAccessException {
		try {
			this.sessionFactory.getCurrentSession().save(userEntity);
		} catch (Exception e){
			throw new InvalidDataAccessException();
		}
	}
}