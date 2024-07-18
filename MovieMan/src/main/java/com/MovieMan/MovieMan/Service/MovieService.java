package com.MovieMan.MovieMan.Service;

import com.MovieMan.MovieMan.Model.MovieEntity;
import com.MovieMan.MovieMan.Model.ReviewEntity;
import org.bson.types.ObjectId;

import java.util.List;
import java.util.Optional;

public interface MovieService {
    List<MovieEntity> findAll();

    ReviewEntity addReviewToMovie(String movieId, ReviewEntity review);

    Optional<MovieEntity> findById(String id);

    MovieEntity saveOrUpdateMovie(MovieEntity movie);

    List<MovieEntity> searchByGenre(String genre);

    List<MovieEntity> searchByTitle(String title);

    List<MovieEntity> findMoviesWithRatingGreaterThan(float rating);

    List<ReviewEntity> findReviewByMovieId(String movieId);

    void deleteMovieById(String id);
}
