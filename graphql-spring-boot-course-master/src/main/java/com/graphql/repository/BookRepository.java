/**
 * 
 */
package com.graphql.repository;

import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import org.springframework.data.relational.core.query.Criteria;
import org.springframework.data.relational.core.query.Query;
import org.springframework.stereotype.Repository;

import com.graphql.model.Book;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author Saikrishna Vinjamuri
 *
 */
@Repository
public class BookRepository {
	
	@Autowired
	private R2dbcEntityTemplate template;
	
	public Mono<Book> getBook(Integer id) {
		return template.select(Book.class).matching(Query.query(Criteria.where("id").is(id))).one();
	}
	
	public Flux<Book> getBooks() {
		return template.select(Book.class).all();
	}

	public Mono<Integer> createBook(Book book) {
		Random rand = new Random();
        Integer bookId = rand.nextInt(1000);
        book.setId(bookId);
       
		return template.insert(Book.class).using(book).thenReturn(bookId);
	}
}
