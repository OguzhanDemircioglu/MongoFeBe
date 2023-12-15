package com.example.demo.app.service;

import com.example.demo.app.models.Movie;
import org.bson.types.ObjectId;

import java.util.List;
import java.util.Optional;

public interface MovieService {

    List<Movie> getAllMovies();
    Optional<Movie> getMoviesByID(ObjectId id);
    List<Movie> getMoviesByImdbId(String id);
}
