/**
 * 
 */
package com.packtpub.felix.bookshelf.inventory.impl.mock;

import com.packtpub.felix.bookshelf.inventory.api.MutableBook;

/**
 * @author glonghitano
 *
 */
public class MutableBookImpl implements MutableBook 
{
	private String isbn;
	private String author;
	private String title;
	private String category;
	private int rating;

	/**
	 * @param isbn
	 */
	public MutableBookImpl(String isbn) 
	{
		setISBN(isbn);
	}

	
	/**{@inheritDoc}*/
	public String getTitle() 
	{
		return this.title;
	}

	
	/**{@inheritDoc}*/
	public String getAuthor() 
	{
		return this.author;
	}

	/**{@inheritDoc}*/
	public String getCategory() 
	{
		return this.category;
	}

	/**{@inheritDoc}*/
	public int getRating() 
	{
		return this.rating;
	}

	/**{@inheritDoc}*/
	public void setISBN(String isbn) 
	{
		this.isbn = isbn;
	}

	/**{@inheritDoc}*/
	public void setTitle(String title) 
	{
		this.title = title;
	}

	/**{@inheritDoc}*/
	public void setAuthor(String author) 
	{
		this.author = author;
	}

	/**{@inheritDoc}*/
	public void setCategory(String category) 
	{
		this.category = category;
	}

	/**{@inheritDoc}*/
	public void setRating(int rating) 
	{
		this.rating = rating;
	}

	/**{@inheritDoc}*/
	public String getISBN() 
	{
		return this.isbn;
	}
	
	public String toString()
	{
		StringBuffer buf = new StringBuffer();
		buf.append(getCategory()).append(": ");
		buf.append(getTitle()).append(" from ").append(getAuthor());
		buf.append(" [").append(getRating()).append("]");
		return buf.toString();
	}
}