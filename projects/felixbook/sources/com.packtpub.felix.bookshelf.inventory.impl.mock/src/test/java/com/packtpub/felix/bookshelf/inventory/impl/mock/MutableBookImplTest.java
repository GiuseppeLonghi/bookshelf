/**
 * 
 */
package com.packtpub.felix.bookshelf.inventory.impl.mock;

import static org.junit.Assert.*;
import org.junit.Test;


/**
 * @author glonghitano
 *
 */
public class MutableBookImplTest 
{
	/**
	 * Unit test for MutableBookImpl class
	 */
	@Test
	public void testMutableBookImpl()
	{
		MutableBookImpl book = new MutableBookImpl("978-3-16-148410-0");

		assertNotNull(book);
		assertEquals(book.getISBN(), "978-3-16-148410-0");				
		
		book.setTitle("OSGi and Apache Felix 3.0");
		book.setAuthor("Walid Gedeon");
		book.setCategory("Computer Science");
		book.setRating(10);
		book.setISBN("978-1-849511-38-4");
		
		assertEquals(book.getCategory(), "Computer Science");
		assertEquals(book.getTitle(), "OSGi and Apache Felix 3.0");
		assertEquals(book.getAuthor(), "Walid Gedeon");
		assertEquals(book.getRating(), 10);
		assertEquals(book.getISBN(), "978-1-849511-38-4");
		
		assertEquals(book.toString(), "ISBN: 978-1-849511-38-4;" +
									  " Author: Walid Gedeon;" +
									  " Title: OSGi and Apache Felix 3.0;" +
									  " Category: Computer Science;" +
									  " Rating [10];"+
									  " Started: false;" +
									  " Finished: false");
	}
}
