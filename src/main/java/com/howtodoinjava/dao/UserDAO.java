package com.howtodoinjava.dao;

import com.howtodoinjava.entity.UserEntity;
import com.howtodoinjava.exceptions.InvalidCookiesException;
import com.howtodoinjava.exceptions.InvalidDataAccessException;

public interface UserDAO {

	String getPasswordsByUsername(String username);

	void createPersistentLoginsEntity(String username, String series, String token, String LastUsed);

	String getUsernameBySeriesAndToken(String series, String token) throws InvalidCookiesException;

	void setTokenBySeries(String series, String token) throws InvalidDataAccessException;

	void addUserEntity(UserEntity userEntity) throws InvalidDataAccessException;

}
