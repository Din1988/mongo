package com.example.demo.controller;

import com.example.demo.item.BookItem;
import com.example.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("books")
public class BookController {

	@Autowired
	private BookRepository bookRepository;

	@PostMapping(path = "/save")
	public BookItem create(@RequestBody BookItem bookItem) {
		return bookRepository.save(bookItem);
	}

	@GetMapping()
	public List<BookItem> getAll() {
		return bookRepository.findAll();
	}

	@GetMapping("/{id}")
	public Optional<BookItem> getById(@PathVariable String id) {
		return bookRepository.findById(id);
	}


}
