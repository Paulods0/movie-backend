package com.example.movies.controllers;

import com.example.movies.models.MovieModel;
import com.example.movies.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/movies")
@CrossOrigin(origins = "http://localhost:5173")
public class MovieController {
    @Autowired
    private MovieService movieService;
    @GetMapping
    public ResponseEntity<List<MovieModel>> getAllMovies(){
        return ResponseEntity.status(HttpStatus.OK).body(movieService.getAllMovies());
    }
    @GetMapping("/{imdbId}")
    public ResponseEntity<Optional<MovieModel>> getSingleMovie(@PathVariable(value = "imdbId")String imdbId){
        return ResponseEntity.status(HttpStatus.OK).body(movieService.findById(imdbId));
    }
}
