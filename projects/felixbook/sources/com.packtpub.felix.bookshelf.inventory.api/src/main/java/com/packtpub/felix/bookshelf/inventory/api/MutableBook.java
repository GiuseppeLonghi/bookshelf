/**
 * This interface extends Book for mutable type, which provides the
 * additional write access to the Book bean.
 */
package com.packtpub.felix.bookshelf.inventory.api;

/**
 * @author glonghitano
 *
 */
public interface MutableBook extends Book 
{
	/**
	 * @param isbn
	 */
	void setISBN(String isbn);
	/**
	 * @param title
	 */
	void setTitle(String title);
	/**
	 * @param author
	 */
	void setAuthor(String author);
	/**
	 * @param category
	 */
	void setCategory(String category);
	/**
	 * @param rating
	 */
	void setRating(int rating);
	
	/**
	 * Mark a book as just started
	 */
	void setStarted(boolean value);
	
	/**
	 * Mark a book as just finished
	 */
	void setFinished(boolean value);
}
