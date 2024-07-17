package com.MovieMan.MovieMan.Service;

import com.MovieMan.MovieMan.Model.MovieEntity;
import com.MovieMan.MovieMan.Model.ReviewEntity;
import org.bson.types.ObjectId;

import java.util.List;
import java.util.Optional;

public interface MovieService {
    List<MovieEntity> findAll();

    ReviewEntity addReviewToMovie(String movieId, ReviewEntity review);

    Optional<MovieEntity> findById(ObjectId id);

    MovieEntity saveOrUpdateMovie(MovieEntity movie);

    List<MovieEntity> searchByGenre(String genre);

    List<MovieEntity> searchByTitle(String title);

    List<MovieEntity> findMoviesWithRatingGreaterThan(float rating);

    void deleteMovieById(ObjectId id);
}
