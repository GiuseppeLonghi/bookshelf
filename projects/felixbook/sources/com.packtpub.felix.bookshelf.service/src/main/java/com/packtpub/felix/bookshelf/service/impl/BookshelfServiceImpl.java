/**
 * 
 */
package com.packtpub.felix.bookshelf.service.impl;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import com.packtpub.felix.bookshelf.inventory.api.Book;
import com.packtpub.felix.bookshelf.inventory.api.BookAlreadyExistsException;
import com.packtpub.felix.bookshelf.inventory.api.BookInventory;
import com.packtpub.felix.bookshelf.inventory.api.BookInventory.SearchCriteria;
import com.packtpub.felix.bookshelf.inventory.api.BookNotFoundException;
import com.packtpub.felix.bookshelf.inventory.api.InvalidBookException;
import com.packtpub.felix.bookshelf.inventory.api.MutableBook;
import com.packtpub.felix.bookshelf.service.api.BookshelfService;
import com.packtpub.felix.bookshelf.service.api.InvalidCredentialsException;

/**
 * @author glonghitano
 *
 */
public class BookshelfServiceImpl implements BookshelfService 
{
	private String sessionId;
	
	private BundleContext context;
	
	public BookshelfServiceImpl(BundleContext context) 
	{
		this.context = context;
	}
	
	/**{@inheritDoc}*/
	public String login(String username, char[] password) throws InvalidCredentialsException 
	{
		if("admin".equals(username) && Arrays.equals(password, "admin".toCharArray()))
		{
			this.sessionId = Long.toString(System.currentTimeMillis());
			return this.sessionId;
		}
		throw new InvalidCredentialsException(username);
	}

	/**{@inheritDoc}*/
	public void logout(String sessionId) 
	{
		checkSession(sessionId);
		this.sessionId = null;
	}

	/**{@inheritDoc}*/
	public boolean sessionIsValid(String sessionId) 
	{
		return this.sessionId!=null && this.sessionId.equals(sessionId);
	}
	
	/**
	 * Session check is a simple one: we only allow one active session at a time.
	 * If the sessionId is set, it must match the one that's passed, otherwise the check fails.
	 * @param sessionId
	 */
	protected void checkSession(String sessionId)
	{
		if(!sessionIsValid(sessionId))
		{
			throw new SessionNotValidRuntimeException(sessionId);
		}
	}

	/**{@inheritDoc}*/
	public Set<String> getCategories(String sessionId) 
	{
		checkSession(sessionId);
		BookInventory inventory = lookupBookInventory();
		return inventory.getCategories();
	}

	/**{@inheritDoc}*/
	public void addBook(String sessionId, String isbn, String title, String author, String category, int rating) throws BookAlreadyExistsException, InvalidBookException
	{
		checkSession(sessionId);
		BookInventory inventory = lookupBookInventory();

		MutableBook book = inventory.createBook(isbn);

		book.setTitle(title);
		book.setAuthor(author);
		book.setCategory(category);
		book.setRating(rating);

		inventory.storeBook(book);
	}

	/**{@inheritDoc}*/
	public void modifyBookCategory(String sessionId, String isbn, String category) throws BookNotFoundException, InvalidBookException 
	{
		checkSession(sessionId);
		BookInventory inventory = lookupBookInventory();
		
		MutableBook book = inventory.loadBookForEdit(isbn);
		book.setCategory(category);
		inventory.storeBook(book);
	}

	/**{@inheritDoc}*/
	public void modifyBookRating(String sessionId, String isbn, int rating) throws BookNotFoundException, InvalidBookException 
	{
		checkSession(sessionId);
		BookInventory inventory = lookupBookInventory();

		MutableBook book = inventory.loadBookForEdit(isbn);
		book.setRating(rating);
		inventory.storeBook(book);
	}

	/**{@inheritDoc}
	 * @throws InvalidBookException */
	public void modifyBookStatus(String sessionId, String isbn, StatusBook status, boolean value) throws BookNotFoundException, InvalidBookException 
	{
		checkSession(sessionId);
		BookInventory inventory = lookupBookInventory();
		
		MutableBook book = inventory.loadBookForEdit(isbn);
		
		switch(status)
		{
			case STARTED:
				book.setStarted(value);
				break;
			case FINISHED:
				book.setFinished(value);
				break;
			default:
				break;
		}
		
		inventory.storeBook(book);
	}

	/**{@inheritDoc}*/
	public void removeBook(String sessionId, String isbn) throws BookNotFoundException 
	{	
		checkSession(sessionId);
		BookInventory inventory = lookupBookInventory();
		
		inventory.removeBook(isbn);
	}

	/**{@inheritDoc}*/
	public Book getBook(String sessionId, String isbn) throws BookNotFoundException 
	{
		checkSession(sessionId);
		BookInventory inventory = lookupBookInventory();
		return inventory.loadBook(isbn);
	}

	/**{@inheritDoc}*/
	public Set<String> searchBooksByCategory(String sessionId, String categoryLike) 
	{
		checkSession(sessionId);
		BookInventory inventory = lookupBookInventory();
		
		Map<SearchCriteria, String> criteria = new TreeMap<SearchCriteria, String>();
		criteria.put(SearchCriteria.CATEGORY_LIKE, categoryLike);
		
		Set<String> result = inventory.searchBooks(criteria);

		return result;
	}

	/**{@inheritDoc}*/
	public Set<String> searchBooksByAuthor(String session, String authorLike) 
	{
		checkSession(sessionId);
		BookInventory inventory = lookupBookInventory();
		
		Map<SearchCriteria, String> criteria = new TreeMap<SearchCriteria, String>();
		criteria.put(SearchCriteria.AUTHOR_LIKE, authorLike);
		
		Set<String> result = inventory.searchBooks(criteria);

		return result;	
	}

	/**{@inheritDoc}*/
	public Set<String> searchBooksByTitle(String session, String titleLike) 
	{
		checkSession(sessionId);
		BookInventory inventory = lookupBookInventory();
		
		Map<SearchCriteria, String> criteria = new TreeMap<SearchCriteria, String>();
		criteria.put(SearchCriteria.TITLE_LIKE, titleLike);
		
		Set<String> result = inventory.searchBooks(criteria);

		return result;
	}

	/**{@inheritDoc}*/
	public Set<String> searchBooksByRating(String session, int ratingLower, int ratingUpper) 
	{
		checkSession(sessionId);
		BookInventory inventory = lookupBookInventory();
		
		Map<SearchCriteria, String> criteria = new TreeMap<SearchCriteria, String>();
		criteria.put(SearchCriteria.RATING_GT, Integer.toString(ratingLower));
		criteria.put(SearchCriteria.RATING_LT, Integer.toString(ratingUpper));
		
		Set<String> result = inventory.searchBooks(criteria);

		return result;
	}

	/**
	 * This method is used to store context reference to retrieve
	 * BookInventory service instance from the framework's registered services
	 * and the return it.
	 * @return BookInventory service reference or BookInventoryNotRegisteredRuntimeException is thrown.
	 */
	private BookInventory lookupBookInventory()
	{
		String name = BookInventory.class.getName();
		
		ServiceReference ref = this.context.getServiceReference(name);
		/*
		 * Note: Since there is no coupling between the bookshelf service
		 * and the inventory component, we need to make sure that there is an implementation
		 * registered for the BookInventory interface. This is why we check if ref is null
		 * before using it.
		 */
		//TODO: to implement a retry mechanism before to throw a Runtime Exception
		if (ref == null)
		{
			throw new BookInventoryNotRegisteredRuntimeException(name);
		}
		return (BookInventory) this.context.getService(ref);
	}
}
