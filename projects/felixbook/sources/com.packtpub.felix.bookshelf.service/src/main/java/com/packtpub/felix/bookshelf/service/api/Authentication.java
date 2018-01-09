/**
 * 
 */
package com.packtpub.felix.bookshelf.service.api;

/**
 * Authentication interface. It is based on a username and password and creates a session
 * when the authentication information is accepted.
 * 
 * @author glonghitano
 *
 */
public interface Authentication 
{
	/**
	 * 
	 * @param username
	 * @param password
	 * @return
	 * @throws InvalidCredentialsException
	 */
	String login(String username, char[] password) throws InvalidCredentialsException;
	
	/**
	 * 
	 * @param sessionId
	 */
	void logout(String sessionId);
	
	/**
	 * 
	 * @param sessionId
	 * @return
	 */
	boolean sessionIsValid(String sessionId);
}
