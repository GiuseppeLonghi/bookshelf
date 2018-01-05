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
	String getISBN();
	String getTitle();
	String getAuthor();
	String getCategory();
	int getRating();	
}
