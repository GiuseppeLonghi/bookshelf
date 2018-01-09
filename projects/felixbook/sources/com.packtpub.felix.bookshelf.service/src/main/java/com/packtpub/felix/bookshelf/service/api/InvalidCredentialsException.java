/**
 * 
 */
package com.packtpub.felix.bookshelf.service.api;

/**
 * @author glonghitano
 *
 */
public class InvalidCredentialsException extends Exception
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1166613455723457289L;

	/**
	 * 
	 * @param username
	 */
	public InvalidCredentialsException(String username) 
	{
        super("Invalid credentials for " + username);
    }

}
