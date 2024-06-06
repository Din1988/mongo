package com.example.demo.item;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.Date;

@Document("rentedbookinfoitems")
public class RentedBookInfoItem {
	@Id
	private String id;
	private BookItem book;
	@DocumentReference(lazy = true, lookup = "{ 'reader' : ?#{#self.id} }")
	private ReaderItem reader;
	private Date receivingDate;
	private Date returnDate;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public BookItem getBook() {
		return book;
	}

	public void setBook(BookItem book) {
		this.book = book;
	}

	public ReaderItem getReader() {
		return reader;
	}

	public void setReader(ReaderItem reader) {
		this.reader = reader;
	}

	public Date getReceivingDate() {
		return receivingDate;
	}

	public void setReceivingDate(Date receivingDate) {
		this.receivingDate = receivingDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}
}
