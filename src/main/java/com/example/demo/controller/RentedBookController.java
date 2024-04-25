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
	public RentedBookInfoItem create(@RequestBody RentedBookInfoItem rentedBookInfo) {
		rentedBookInfo.setReceivingDate(new Date());
		Optional<ReaderItem> readerItemOptional = readerRepository.findById(rentedBookInfo.getReaderId());
		if (readerItemOptional.isPresent()) {
			ReaderItem reader = readerItemOptional.get();
			Optional<BookItem> book = bookRepository.findById(rentedBookInfo.getBookId());
			reader.addBooks(book.get());
			readerRepository.save(reader);
		}
		return rentedBookInfoRepository.save(rentedBookInfo);
	}

	@GetMapping()
	public List<RentedBookInfoItem> getAll() {
		Aggregation aggregation = Aggregation.newAggregation(
				Aggregation.lookup("bookitems", "id", "bookId", "bookitem"),
				Aggregation.project()
						.andExpression("_id").as("id")
						.andExpression("bookitem.id").as("bookId")
						.andExpression("bookitem.authors").as("readerId")
						.andExpression("receivingDate").as("receivingDate")
						.andExpression("returnDate").as("returnDate")
		);
		AggregationResults<RentedBookInfoItem> results = mongoTemplate.aggregate(aggregation, "rentedbookinfoitems", RentedBookInfoItem.class);
		return results.getMappedResults();
	}
}
