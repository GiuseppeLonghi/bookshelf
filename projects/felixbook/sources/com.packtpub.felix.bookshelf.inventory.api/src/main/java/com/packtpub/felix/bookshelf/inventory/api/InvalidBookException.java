/**
 * 
 */
package com.packtpub.felix.bookshelf.inventory.api;

/**
 * @author glonghitano
 *
 */
public class InvalidBookException extends Exception 
{

	private static final long serialVersionUID = 1L;

	public InvalidBookException(String message) 
	{
		super("Book invalid: " + message);
	}
}
