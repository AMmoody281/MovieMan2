package com.MovieMan.MovieMan.Service;

import com.MovieMan.MovieMan.Model.MovieEntity;
import com.MovieMan.MovieMan.Model.ReviewEntity;
import org.bson.types.ObjectId;

import java.util.List;
import java.util.Optional;

public interface ReviewService {

    List<ReviewEntity> findAll();
    Optional<ReviewEntity> findById(String id);

    List<ReviewEntity> findByMovie(MovieEntity movie);

    List<ReviewEntity> searchByTitle(String title);

    List<ReviewEntity> findReviewsWithRatingGreaterThan(float rating);
    void deleteReviewById(String id);
}
