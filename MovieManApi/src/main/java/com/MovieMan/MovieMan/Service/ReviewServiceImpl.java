package com.MovieMan.MovieMan.Service;

import com.MovieMan.MovieMan.Model.MovieEntity;
import com.MovieMan.MovieMan.Model.ReviewEntity;
import com.MovieMan.MovieMan.Repository.MovieRepository;
import com.MovieMan.MovieMan.Repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService {
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private ReviewRepository reviewRepository;


    @Override
    public List<ReviewEntity> findAll() {
        return reviewRepository.findAll();
    }

    @Override
    public Optional<ReviewEntity> findById(String id) {
        return Optional.empty();
    }

    @Override
    public List<ReviewEntity> findByMovie(MovieEntity movie) {
        return null;
    }

    @Transactional
    @Override
    public ReviewEntity saveOrUpdateReview(ReviewEntity review) {
        updateMovie(review);
        return reviewRepository.saveReview(review);
    }

    @Override
    public MovieEntity updateMovie(ReviewEntity review) {
        MovieEntity movie = movieRepository.findById(review.getMovie().toString()).orElse(null);
        if(movie!=null){
            movieRepository.save(movie.addReview(review.getId()));
        }
        return movie;
    }

    @Override
    public List<ReviewEntity> searchByTitle(String title) {
        return null;
    }

    @Override
    public List<ReviewEntity> findReviewsWithRatingGreaterThan(float rating) {
        return null;
    }


    @Override
    public void deleteReviewById(String id) {

    }
}
