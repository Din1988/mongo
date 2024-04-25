package com.example.demo.repository;

import com.example.demo.item.BookItem;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository extends MongoRepository<BookItem, String> {
}
