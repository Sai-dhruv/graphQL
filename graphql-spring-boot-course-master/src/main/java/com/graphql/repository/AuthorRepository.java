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

import com.graphql.model.Author;

import reactor.core.publisher.Mono;

/**
 * @author Saikrishna Vinjamuri
 *
 */
@Repository
public class AuthorRepository {
	
	@Autowired
	private R2dbcEntityTemplate template;
	
	public Mono<Integer> createAuthor(Author author) {
		Random rand = new Random();
        int authorId = rand.nextInt(1000);
		author.setId(authorId);
		return template.insert(Author.class).using(author).thenReturn(authorId);
	}
	
	public Mono<Author> getAuthor(Integer bookId) {
		return template.select(Author.class).matching(Query.query(Criteria.where("book_id").is(bookId))).one();
	}
}
