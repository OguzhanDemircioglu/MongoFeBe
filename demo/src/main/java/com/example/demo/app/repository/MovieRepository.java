package com.example.demo.app.repository;

import com.example.demo.app.models.Movie;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends MongoRepository<Movie, ObjectId> {
    List<Movie> findMoviesByImdbId(String id);
}
