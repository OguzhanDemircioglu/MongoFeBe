package com.example.demo.app.service;

import com.example.demo.app.models.Review;

public interface ReviewService {
    Review createReview(String body, String imdb);
    }
