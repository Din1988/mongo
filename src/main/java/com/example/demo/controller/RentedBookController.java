package com.example.demo.controller;

import com.example.demo.item.BookItem;
import com.example.demo.item.ReaderItem;
import com.example.demo.item.RentedBookInfoItem;
import com.example.demo.repository.BookRepository;
import com.example.demo.repository.ReaderRepository;
import com.example.demo.repository.RentedBookInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("rentedBooks")
public class RentedBookController {

	@Autowired
	private RentedBookInfoRepository rentedBookInfoRepository;
	@Autowired
	private BookRepository bookRepository;
	@Autowired
	private ReaderRepository readerRepository;
	@Autowired
	private MongoTemplate mongoTemplate;

	@PostMapping(path = "/save")
	public RentedBookInfoItem create(@RequestBody RentedBook rentedBook) {
		RentedBookInfoItem rentedBookInfoItem = new RentedBookInfoItem();
		rentedBookInfoItem.setReceivingDate(new Date());
		Optional<ReaderItem> readerItemOptional = readerRepository.findById(rentedBook.getReaderId());
		Optional<BookItem> optionalBookItem = bookRepository.findById(rentedBook.getBookId());
		if (readerItemOptional.isPresent() && optionalBookItem.isPresent()) {
			ReaderItem reader = readerItemOptional.get();
			rentedBookInfoItem.setReader(readerItemOptional.get());
			rentedBookInfoItem.setBook(optionalBookItem.get());
			readerRepository.save(reader);
			return rentedBookInfoRepository.save(rentedBookInfoItem);
		}
		return null;
	}

	@GetMapping()
	public List<RentedBookInfoItem> getAll() {
		return rentedBookInfoRepository.findAll();
	}
}
