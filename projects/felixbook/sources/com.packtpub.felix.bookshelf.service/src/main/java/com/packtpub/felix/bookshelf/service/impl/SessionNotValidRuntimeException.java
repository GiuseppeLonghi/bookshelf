/**
 * 
 */
package com.packtpub.felix.bookshelf.service.impl;

/**
 * @author glonghitano
 *
 */
public class SessionNotValidRuntimeException extends RuntimeException
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5055821605780551907L;

	public SessionNotValidRuntimeException(String session) 
	{
		super("Session not valid ("+session+"), or session expired; you must login.");
	}
}
