package com.howtodoinjava.service;
import java.io.UnsupportedEncodingException;

import com.howtodoinjava.exceptions.InvalidCookiesException;
import com.howtodoinjava.exceptions.InvalidDataAccessException;
import com.howtodoinjava.exceptions.InvalidUsernameOrPasswordException;

public interface UserManager {
	public UserDetails userLoginWithUsernameAndPassword(String username,
			String password) throws InvalidUsernameOrPasswordException, UnsupportedEncodingException;
	public UserDetails userLoginWithCookies(String value) throws UnsupportedEncodingException, InvalidCookiesException, InvalidDataAccessException;
	public UserDetails getUserDetails();
	public void addUser(String username, String password) throws InvalidDataAccessException;
	public boolean usernameExist(String username);
}

