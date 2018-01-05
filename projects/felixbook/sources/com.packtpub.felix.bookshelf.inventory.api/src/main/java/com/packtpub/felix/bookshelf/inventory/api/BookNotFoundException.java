/**
 * 
 */
package com.packtpub.felix.bookshelf.inventory.api;

/**
 * @author glonghitano
 *
 */
public class BookNotFoundException extends Exception 
{

	private static final long serialVersionUID = 1L;
	
	public BookNotFoundException(String isbn)
	{
		super("Book not found: " + isbn);
	}

}
