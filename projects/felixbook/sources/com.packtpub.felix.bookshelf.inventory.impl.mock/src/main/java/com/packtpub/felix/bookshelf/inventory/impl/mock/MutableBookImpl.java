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
	private boolean started;
	private boolean finished;

	/**
	 * @param isbn
	 */
	public MutableBookImpl(String isbn) 
	{
		setISBN(isbn);
	}

	/**{@inheritDoc}*/
	public void setStarted(boolean value) 
	{
		this.started = value;
	}

	/**{@inheritDoc}*/
	public void setFinished(boolean value) 
	{
		this.finished = value;
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

	/**{@inheritDoc}*/
	public boolean getStarted() 
	{
		return this.started;
	}

	/**{@inheritDoc}*/
	public boolean getFinished() 
	{
		return this.finished;
	}

	public String toString()
	{
		StringBuffer buf = new StringBuffer();
		
		buf.append("ISBN: ").append(getISBN());
		buf.append("; Author: ").append(getAuthor());
		buf.append("; Title: ").append(getTitle());
		buf.append("; Category: ").append(getCategory());
		buf.append("; Rating [").append(getRating()).append("]");
		buf.append("; Started: ").append(getStarted());
		buf.append("; Finished: ").append(getFinished());
		
		return buf.toString();
	}
}