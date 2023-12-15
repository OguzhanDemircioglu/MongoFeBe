package com.example.demo.app.controller;

import com.example.demo.app.service.ReviewService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("api/review")
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping("/creteReview")
    public ResponseEntity<?> createReview(@RequestBody Map<String,String> map){
        try{
            return new ResponseEntity<>(
                    this.reviewService.createReview(map.get("body"),map.get("imdb")),
                    HttpStatus.CREATED);

        }catch (Exception e){
            return new ResponseEntity<>("İşlem Gerçekleştirilemiyor",HttpStatus.BAD_REQUEST);
        }
    }
}
