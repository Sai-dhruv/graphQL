/**
 * 
 */
package com.graphql.service;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.graphql.constant.Category;
import com.graphql.model.Book;
import com.graphql.repository.BookRepository;

import graphql.schema.DataFetcher;

/**
 * @author Gaurav Sharma
 */
@Service
public class BookService {
	
	@Autowired
	private BookRepository bookRepository;
	@Autowired
	private AuthorService authorService;
	
	public DataFetcher<CompletableFuture<Book>> getBook() {
		return env -> {
			String bookId = env.getArgument("id");
			return bookRepository.getBook(Integer.parseInt(bookId)).toFuture();
		};
	}
	
	public DataFetcher<CompletableFuture<List<Book>>> getBooks() {
		return env -> bookRepository.getBooks().collectList().toFuture();
	}
	
	public DataFetcher<CompletableFuture<String>> createBook() {
		return env -> {
			String bookName = env.getArgument("name");
			int pages = env.getArgument("pages");
			int price = env.getArgument("price");
			String publisher =  env.getArgument("publisher");
            Boolean isSoftCopy = env.getArgument("isSoftCopy");
            int edition = env.getArgument("edition");
            
            String authorName = env.getArgument("authorName");
            int age = env.getArgument("age");
			
			Book book = new Book();
            book.setName(bookName);
            book.setPages(pages);
            book.setPrice(price);
            book.setPublisher(publisher);
           // book.setIsSoftCopy(isSoftCopy);
            book.setEdition(edition);
			return bookRepository.createBook(book).flatMap(
					bookId -> authorService.createAuthor(authorName, age, bookId)
					.map(authourId -> bookId.toString()))
			.toFuture();
		};
	}
}
