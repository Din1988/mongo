package com.example.demo.repository;

import com.example.demo.item.ReaderItem;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReaderRepository extends MongoRepository<ReaderItem, String> {
}
