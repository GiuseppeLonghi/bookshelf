/**
 * 
 */
package com.packtpub.felix.bookshelf.service.api;

import java.util.Set;

import com.packtpub.felix.bookshelf.inventory.api.Book;
import com.packtpub.felix.bookshelf.inventory.api.BookAlreadyExistsException;
import com.packtpub.felix.bookshelf.inventory.api.BookNotFoundException;
import com.packtpub.felix.bookshelf.inventory.api.InvalidBookException;

/**
 * @author glonghitano
 *
 */
public interface BookshelfService extends Authentication 
{
	public enum StatusBook
	{
		STARTED,
		FINISHED
	}
	
	/**
	 * Method used to get set of categories' book stored into the bookshelf
	 * @param sessionId
	 * @return
	 */
	Set<String> getCategories(String sessionId);
	
	/**
	 * Method used to add a new book to the bookshelf
	 * @param sessionId
	 * @param isbn
	 * @param title
	 * @param author
	 * @param category
	 * @param rating
	 */
	void addBook(String sessionId, String isbn, String title, String author, String category, int rating) throws BookAlreadyExistsException, InvalidBookException;
	
	/**
	 * Method used to modify the Book category of a stored book
	 * @param sessionId
	 * @param isbn
	 * @param category
	 * @throws BookNotFoundException
	 * @throws InvalidBookException
	 */
	void modifyBookCategory(String sessionId, String isbn, String category) throws BookNotFoundException, InvalidBookException;
	
	/**
	 * Method used to modify the Book rating of a stored book
	 * @param sessionId
	 * @param isbn
	 * @param rating
	 * @throws BookNotFoundException
	 * @throws InvalidBookException
	 */
	void modifyBookRating(String sessionId, String isbn, int rating) throws BookNotFoundException, InvalidBookException;
	
	/**
	 * Method used to modify the Book status attributes of a stored book
	 * @param sessionId
	 * @param isbn
	 * @param status
	 * @param value
	 * @throws BookNotFoundException
	 * @throws InvalidBookException
	 */
	void modifyBookStatus(String sessionId, String isbn, StatusBook status, boolean value) throws BookNotFoundException, InvalidBookException;
	
	/**
	 * Method used to remove the Book with specific isbn Id stored in the bookshelf
	 * @param sessionId
	 * @param isbn
	 * @throws BookNotFoundException
	 */
	void removeBook(String sessionId, String isbn) throws BookNotFoundException;
	
	/**
	 * Method used to retrieve a specific book from the bookshelf
	 * @param sessionId
	 * @param isbn
	 * @return
	 * @throws BookNotFoundException
	 */
	Book getBook(String sessionId, String isbn) throws BookNotFoundException;
	
	/**
	 * Method used to search for a book, based on Category filter
	 * @param sessionId
	 * @param categoryLike
	 * @return
	 */
	Set<String> searchBooksByCategory(String sessionId, String categoryLike);
	
	/**
	 * Method used to search for a book, based on Author filter
	 * @param sessionId
	 * @param authorLike
	 * @return
	 */
	Set<String> searchBooksByAuthor(String sessionId, String authorLike);
	
	/**
	 * Method used to search for a book, based on Title filter
	 * @param sessionId
	 * @param titleLike
	 * @return
	 */
	Set<String> searchBooksByTitle(String sessionId, String titleLike);
	
	/**
	 * Method used to search for a book, based on Rating filter
	 * @param sessionId
	 * @param ratingLower
	 * @param ratingUpper
	 * @return
	 */
	Set<String> searchBooksByRating(String sessionId, int ratingLower, int ratingUpper);
}
