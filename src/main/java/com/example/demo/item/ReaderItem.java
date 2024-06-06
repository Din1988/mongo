package com.example.demo.item;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.ArrayList;
import java.util.List;

@Document("readeritems")
public class ReaderItem {
	@Id
	private String id;
	private String name;
	private String surName;
	private String email;
	@DocumentReference(lazy = true)
	@ReadOnlyProperty
	private List<RentedBookInfoItem> books = new ArrayList<>();

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

	public String getSurName() {
		return surName;
	}

	public void setSurName(String surName) {
		this.surName = surName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<RentedBookInfoItem> getBooks() {
		return books;
	}

	public void setBooks(List<RentedBookInfoItem> books) {
		this.books = books;
	}
}
