package com.example.movies.services;

import com.example.movies.models.MovieModel;
import com.example.movies.repository.MovieRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    @Autowired
     private MovieRepository movieRepository;
    public List<MovieModel> getAllMovies(){
        return movieRepository.findAll();
    }
    public Optional<MovieModel> findById(String imdbId){
        return movieRepository.findMovieByImdbId(imdbId);
    }
}
