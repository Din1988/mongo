package com.example.demo.controller;

import com.example.demo.item.ReaderItem;
import com.example.demo.repository.ReaderRepository;
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
@RequestMapping("readers")
public class ReaderController {

	@Autowired
	private ReaderRepository readerRepository;

	@PostMapping(path = "/save")
	public ReaderItem create(@RequestBody ReaderItem readerItem) {
		return readerRepository.save(readerItem);
	}

	@GetMapping("/{id}")
	public Optional<ReaderItem> getById(@PathVariable String id) {
		return readerRepository.findById(id);
	}

	@GetMapping()
	public List<ReaderItem> getAll() {
		return readerRepository.findAll();
	}
}
