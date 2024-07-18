package com.MovieMan.MovieMan.Controller;

import com.MovieMan.MovieMan.Model.MovieEntity;
import com.MovieMan.MovieMan.Model.ReviewEntity;
import com.MovieMan.MovieMan.Service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("movies/reviews")
public class ReviewController {
    private final ReviewService reviewService;

    @Autowired
    public ReviewController (ReviewService reviewService){
        this.reviewService = reviewService;
    }

    @GetMapping("")
    public List<ReviewEntity> getAllReviews(){
        return reviewService.findAll();
    }
}
