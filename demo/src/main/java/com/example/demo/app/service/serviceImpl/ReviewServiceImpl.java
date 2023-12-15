package com.example.demo.app.service.serviceImpl;

import com.example.demo.app.models.Movie;
import com.example.demo.app.models.Review;
import com.example.demo.app.repository.ReviewRespository;
import com.example.demo.app.service.ReviewService;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Objects;

@Service
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRespository reviewRespository;

    private final MongoTemplate mongoTemplate;

    public ReviewServiceImpl(ReviewRespository reviewRespository, MongoTemplate mongoTemplate) {
        this.reviewRespository = reviewRespository;
        this.mongoTemplate = mongoTemplate;
    }

    public Review createReview(String body, String imdb) {

        Review review = reviewRespository.findReviewByBody(body);

        if (Objects.isNull(review)){
            review = Review.builder().created(LocalDateTime.now()).body(body).id(new ObjectId()).build();
        }else {
            review.setUpdated(LocalDateTime.now());
        }

        reviewRespository.save(review);

        mongoTemplate.update(Movie.class)
                .matching(Criteria.where("imdbId").is(imdb))
                .apply(new Update().push("reviewIds").value(review))
                .first();

        return review;
    }

}
