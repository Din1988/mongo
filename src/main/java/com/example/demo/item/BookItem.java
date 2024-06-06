package com.example.demo.item;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("bookitems")
public class BookItem {
	@Id
	private String id;

	private String name;
	private String authors;
	private Short yearPublication;
	private String genre;
	private String ibsn;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthors() {
		return authors;
	}

	public void setAuthors(String authors) {
		this.authors = authors;
	}

	public Short getYearPublication() {
		return yearPublication;
	}

	public void setYearPublication(Short yearPublication) {
		this.yearPublication = yearPublication;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getIbsn() {
		return ibsn;
	}

	public void setIbsn(String ibsn) {
		this.ibsn = ibsn;
	}

	public BookItem(String name, String authors, Short yearPublication, String genre, String ibsn) {
		this.name = name;
		this.authors = authors;
		this.yearPublication = yearPublication;
		this.genre = genre;
		this.ibsn = ibsn;
	}
}
