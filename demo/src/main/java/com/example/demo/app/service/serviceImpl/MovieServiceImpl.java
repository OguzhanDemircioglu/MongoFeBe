package com.example.demo.app.service.serviceImpl;

import com.example.demo.app.models.Movie;
import com.example.demo.app.repository.MovieRepository;
import com.example.demo.app.service.MovieService;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Optional<Movie> getMoviesByID(ObjectId id) {
        return movieRepository.findById(id);
    }

    @Override
    public List<Movie> getMoviesByImdbId(String id) {
        return movieRepository.findMoviesByImdbId(id);
    }
}
