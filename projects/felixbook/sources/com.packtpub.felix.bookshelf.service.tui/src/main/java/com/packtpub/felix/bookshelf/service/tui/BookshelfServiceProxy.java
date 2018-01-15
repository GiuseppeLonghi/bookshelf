package com.packtpub.felix.bookshelf.service.tui;

import java.util.Set;

import com.packtpub.felix.bookshelf.inventory.api.Book;
import com.packtpub.felix.bookshelf.inventory.api.BookAlreadyExistsException;
import com.packtpub.felix.bookshelf.inventory.api.BookNotFoundException;
import com.packtpub.felix.bookshelf.inventory.api.InvalidBookException;
import com.packtpub.felix.bookshelf.service.api.InvalidCredentialsException;

public interface BookshelfServiceProxy
{
	String SCOPE = "book";
	
	String[] FUNCTIONS = new String[] {"add", "finished", "get", "remove", "search", "started"};
	
	String FUNCTION_STR = "[add, finished, get, remove, search, started]";
	
	Set<Book> search (String username, String password, String attribute, String filter) throws InvalidCredentialsException;
	
	Set<Book> search(String username, String password, String attribute, int lower, int upper) throws InvalidCredentialsException;
	
	String add(String username, String password, String isbn, String title, String author, String category, int rating) throws InvalidCredentialsException, BookAlreadyExistsException, InvalidBookException;
	
	String get(String username, String password, String isbn) throws InvalidCredentialsException, BookNotFoundException;
	
	String remove(String username, String password, String isbn) throws InvalidCredentialsException, BookNotFoundException;
	
	String started(String username, String password, String isbn, boolean value) throws InvalidCredentialsException, BookNotFoundException, InvalidBookException;
	
	String finished(String username, String password, String isbn, boolean value) throws InvalidCredentialsException, BookNotFoundException, InvalidBookException;
}
