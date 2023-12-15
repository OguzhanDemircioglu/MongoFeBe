package com.example.demo.app.controller;

import com.example.demo.app.service.MovieService;
import org.bson.types.ObjectId;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/movies")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/")
    public ResponseEntity<?> showMovies(){
        try {
            return new ResponseEntity<>(movieService.getAllMovies(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("Servise Ulaşılamamaktadır",HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/movie/{id}")
    public ResponseEntity<?> showMovieById(@PathVariable ObjectId id){
        try {
            return new ResponseEntity<>(movieService.getMoviesByID(id), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("Servise Ulaşılamamaktadır",HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/imdb/{id}")
    public ResponseEntity<?> showMoviesByImdbId(@PathVariable String id){
        try {
            return new ResponseEntity<>(movieService.getMoviesByImdbId(id), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("Servise Ulaşılamamaktadır",HttpStatus.BAD_REQUEST);
        }
    }
}
