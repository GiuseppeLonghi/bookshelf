/**
 * The Book interface only expose read access to the book attribute. It is usually a good practice
 * to separate immutable parts of the interface from mutable parts.
 * This way, we can separate between parts of the application taht do read-only access to the data and others that 
 * are allowed to update it.
 */
package com.packtpub.felix.bookshelf.inventory.api;

/**
 * @author glonghitano
 *
 */
public interface Book 
{
	/**
	 * 
	 * @return The International Standard Book Number
	 */
	String getISBN();
	
	/**
	 * 
	 * @return Book's title
	 */
	String getTitle();
	
	/**
	 * 
	 * @return Book's Author
	 */
	String getAuthor();
	
	/**
	 * 
	 * @return Book's category
	 */
	String getCategory();
	
	/**
	 * 
	 * @return Book's rating
	 */
	int getRating();

	/**
	 *
	 * @return true whether the book has been started
	 */
	boolean getStarted();

	/**
	 *
	 * @return true whether the book has been finished
	 */
	boolean getFinished();
}
