package com.lazaro.firstmvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.lazaro.firstmvc.models.Book;
import com.lazaro.firstmvc.repositories.BookRepository;

@Service
public class BookService {
	private final BookRepository bookRepository;
	
	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	
	// returns all the books
    public List<Book> allBooks() {
        return bookRepository.findAll();
    }
    // creates a book
    public Book createBook(Book b) {
        return bookRepository.save(b);
    }
    
    public Book updateBook(Long id, String title, String desc, String lang, Integer numOfPages) {
    	Book foundBook = this.findBook(id);
    	foundBook.setId(id);
    	foundBook.setTitle(title);
    	foundBook.setDescription(desc);
    	foundBook.setLanguage(lang);
    	foundBook.setNumberOfPages(numOfPages);
    	return bookRepository.save(foundBook);
    }

    public Book deleteBook(Long id) {
    	Book delThisBook = this.findBook(id);
    	bookRepository.deleteById(id);
    	return delThisBook;
    }
    
    // retrieves a book
    public Book findBook(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }
    
    
}
