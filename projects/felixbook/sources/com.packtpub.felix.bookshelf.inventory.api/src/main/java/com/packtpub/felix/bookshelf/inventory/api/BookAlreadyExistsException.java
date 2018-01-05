/**
 * 
 */
package com.packtpub.felix.bookshelf.inventory.api;

/**
 * @author glonghitano
 *
 */
public class BookAlreadyExistsException extends Exception 
{

	private static final long serialVersionUID = 4987836194598323626L;

	/**
	 * @param isbn
	 */
	public BookAlreadyExistsException(String isbn) 
	{
		super("Book already exists: " + isbn);
	}
}
