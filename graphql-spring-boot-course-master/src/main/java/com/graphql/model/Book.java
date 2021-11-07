/**
 * 
 */
package com.graphql.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import com.graphql.constant.Category;

import lombok.Data;

/**
 * @author Saikrishna Vinjamuri
 *
 */
@Table("books")
@Data
public class Book {
	
	@Id
	private Integer id;
	private String name;
	private int pages;
	private Author author;
	private Integer price;
	private String publisher;
	private Boolean isSoftCopy;
	private Integer edition;
	private Date bookOpenDate;
	private String Language;
	private Category category;
	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getPages() {
		return pages;
	}


	public void setPages(int pages) {
		this.pages = pages;
	}


	public Author getAuthor() {
		return author;
	}


	public void setAuthor(Author author) {
		this.author = author;
	}


	public Integer getPrice() {
		return price;
	}


	public void setPrice(Integer price) {
		this.price = price;
	}


	public String getPublisher() {
		return publisher;
	}


	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}


	public Boolean getIsSoftCopy() {
		return isSoftCopy;
	}


	public void setIsSoftCopy(Boolean isSoftCopy) {
		this.isSoftCopy = isSoftCopy;
	}


	public Integer getEdition() {
		return edition;
	}


	public void setEdition(Integer edition) {
		this.edition = edition;
	}


	public Date getBookOpenDate() {
		return bookOpenDate;
	}


	public void setBookOpenDate(Date bookOpenDate) {
		this.bookOpenDate = bookOpenDate;
	}


	public String getLanguage() {
		return Language;
	}


	public void setLanguage(String language) {
		Language = language;
	}


	public Category getCategory() {
		return category;
	}


	public void setCategory(Category category) {
		this.category = category;
	}

	public Book() { }

}
