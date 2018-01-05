/**
 * This interface abstracts over the repository implementation specifics.
 * It provides two main functionalities:
 * - CRUD functionality
 * - offers a factory method for creating new book entries.
 * 
 * CRUD is short for Create-Retrieve-Update-Delete
 * 
 */
package com.packtpub.felix.bookshelf.inventory.api;

import java.util.Map;
import java.util.Set;

/**
 * @author glonghitano
 *
 */
public interface BookInventory 
{
	/**
	 * @author glonghitano
	 *
	 */
	enum SearchCriteria
	{
		ISBN_LIKE,
		TITLE_LIKE,
		AUTHOR_LIKE,
		GROUP_LIKE,
		CATEGORY_LIKE,
		RATING_GT,
		RATING_LT
	}
	
	/**
	 * This method gives back the list of book categories.
	 * @return A collection that contains books of all categories.
	 */
	Set<String> getCategories();
	
	/**
	 * Factory method. It is used to create a new book for a given ISBN and throws a
	 * BookAlreadyExistsException if a book with that ISBN is already inventoried.
	 * @param isbn
	 * @return a MutableBook object
	 * @throws BookAlreadyExistsException
	 */
	MutableBook createBook(String isbn) throws BookAlreadyExistsException;
	
	/**
	 * This method will retrieve a book that's already created or throw a BookNotFoundException
	 * if the book is not in the inventory.
	 * @param isbn
	 * @return a MutableBook object
	 * @throws BookNotFoundException
	 */
	MutableBook loadBookForEdit(String isbn) throws BookNotFoundException;
	
	/**
	 * Method used to store a book into the inventory.
	 * It is used to save changes made to a book. It will check the book has 
	 * all mandatory attributes set and throw an InvalidBookException if it's not
	 * the case.
	 * @param book
	 * @return It returns the ISBN of the book that was stored.
	 * @throws InvalidBookException
	 */
	String storeBook(MutableBook book) throws InvalidBookException;
	
	/**
	 * This method loads an existing book, given its ISBN reference.
	 * It returns a read-only Book or throws a BookNotFoundException if no
	 * book was previously stored with this particular ISBN reference.
	 * @param isbn
	 * @return A Book Object
	 * @throws BookNotFoundException
	 */
	Book loadBook(String isbn) throws BookNotFoundException;
	
	/**
	 * It removes a book from inventory, based on its ISBN reference,
	 * or throws a BookNotFoundException, if no book was previously stored with this
	 * ISBN reference.
	 * @param isbn
	 * @throws BookNotFoundException 
	 * @throws BookNotFoundExcpetion
	 */
	void removeBook(String isbn) throws BookNotFoundException;
	
	/**
	 * This method finds the books in the bookshelf that match a given set of criteria.
	 * @param criteria
	 * @return It returns the set of ISBNs for the books that match the search criteria.
	 */
	Set<String> searchBook(Map<SearchCriteria, String> criteria);
}
