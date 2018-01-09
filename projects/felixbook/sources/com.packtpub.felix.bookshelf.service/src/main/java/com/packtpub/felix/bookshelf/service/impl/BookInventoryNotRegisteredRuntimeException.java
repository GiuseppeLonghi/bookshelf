/**
 * 
 */
package com.packtpub.felix.bookshelf.service.impl;

/**
 * @author glonghitano
 *
 */
public class BookInventoryNotRegisteredRuntimeException extends RuntimeException
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2703729843770954428L;

	public BookInventoryNotRegisteredRuntimeException(String className)
	{
		super("BookInventory not registered, looking under: " + className);		
	}
}
