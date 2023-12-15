package com.example.demo.app.repository;

import com.example.demo.app.models.Review;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRespository extends MongoRepository<Review, ObjectId> {
    Review findReviewByBody(String body);
}
