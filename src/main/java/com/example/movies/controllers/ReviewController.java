package com.example.movies.controllers;

import com.example.movies.models.ReviewModel;
import com.example.movies.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/reviews")
@CrossOrigin(origins = "http://localhost:5173")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @PostMapping
    public ResponseEntity<ReviewModel> createReview(@RequestBody Map<String,String> payload){
        return new ResponseEntity<ReviewModel>(reviewService.createReview(payload.get("reviewBody"),payload.get("imdbId")) , HttpStatus.CREATED);
    }
}
