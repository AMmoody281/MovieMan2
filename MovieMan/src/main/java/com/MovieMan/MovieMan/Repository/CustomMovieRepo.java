package com.MovieMan.MovieMan.Repository;

import com.MovieMan.MovieMan.Model.MovieEntity;
import com.MovieMan.MovieMan.Model.ReviewEntity;

public interface CustomMovieRepo {
    MovieEntity addReviewToMovie(String movieId, ReviewEntity review);
}
