package com.example.demo.repository;

import com.example.demo.item.RentedBookInfoItem;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RentedBookInfoRepository extends MongoRepository<RentedBookInfoItem, String> {
}
